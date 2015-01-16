package com.smartdata.impl;

import com.smartdata.Member;
import com.smartdata.api.MemberImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 5:18 PM
 */
public class MemberImporterImpl implements MemberImporter {
    private static List<String> uniqueMemberList = new ArrayList<String>();
    @Override
    public List<Member> prepareMember(File inputPath) {

        List<Member> memberCollection = new ArrayList<Member>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputPath));
            String line;
            while ((line = br.readLine()) != null) {
                Member member = new Member();

                String pattern = "^(.{5})(.{10})(.{20})(.{13})(.{24})(.{10}).*";
                Pattern regex = Pattern.compile(pattern);
                Matcher matcher = regex.matcher(line);

                if (matcher.find()) {
                    member.setId(matcher.group(1).trim());
                    member.setFirst_name(matcher.group(2).trim());
                    member.setLast_name(matcher.group(3).trim());
                    member.setAddress(matcher.group(4).trim());
                    member.setEmail(matcher.group(5).trim());
                    member.setPhone_no(matcher.group(6).trim());

                    if (!checkIfMemberExists(matcher.group(1).trim()))
                        memberCollection.add(member);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return memberCollection;
    }

    public boolean checkIfMemberExists(String member_id) {
        if (uniqueMemberList.contains(member_id)) return true;
        else {
            uniqueMemberList.add(member_id);
            return false;
        }
    }
}
