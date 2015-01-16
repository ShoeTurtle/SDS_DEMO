package com.smartdata.api;

import com.smartdata.Eligibility;
import com.smartdata.Member;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

/**
 * User: Binay
 * Date: 16/01/15
 */
public abstract class MemberLineFilter {

    public void convert(File memberInputPath, File eligibilityInputPath, File outputPath) {
        MemberImporter memberImporter = getMemberImporter();
        EligibilityImporter eligibilityImporter = getEligibilityImporter();
        MemberExporter memberExporter = getMemberExporter();

        List<Member> member_collection = memberImporter.prepareMember(memberInputPath);
        List<Eligibility> eligibility_collection = eligibilityImporter.prepareEligibility(eligibilityInputPath);

        try {
            Writer writer = new FileWriter(outputPath);

            for (Member member : member_collection) {
                if (isMemberEligible(member, eligibility_collection))
                    memberExporter.write(outputPath, member, writer);
            }

            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract MemberImporter getMemberImporter();
    public abstract MemberExporter getMemberExporter();
    public abstract EligibilityImporter getEligibilityImporter();
    public abstract boolean isMemberEligible(Member member, List<Eligibility> eligibility);
}
