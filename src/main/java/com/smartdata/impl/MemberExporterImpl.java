package com.smartdata.impl;

import com.smartdata.Member;
import com.smartdata.api.MemberExporter;

import java.io.File;
import java.io.Writer;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 5:18 PM
 */
public class MemberExporterImpl implements MemberExporter {
    @Override
    public void write(File outputFile, Member member, Writer writer) {
        StringBuilder line = new StringBuilder();
        line.append(member.getId() + "\t");
        line.append(member.getFirst_name() + "\t");
        line.append(member.getLast_name() + "\t");
        line.append(member.getAddress() + "\t");
        line.append(member.getEmail() + "\t");
        line.append(member.getPhone_no() + "\n");

        try {
            writer.write(line.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
