package com.smartdata;

import com.smartdata.api.EligibilityImporter;
import com.smartdata.api.MemberExporter;
import com.smartdata.api.MemberImporter;
import com.smartdata.api.MemberLineFilter;
import com.smartdata.impl.EligibilityImporterImpl;
import com.smartdata.impl.MemberExporterImpl;
import com.smartdata.impl.MemberImporterImpl;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 4:46 PM
 */
public class MemberReports extends MemberLineFilter {
    @Override
    public MemberImporter getMemberImporter() {
        return new MemberImporterImpl();
    }

    @Override
    public MemberExporter getMemberExporter() {
        return new MemberExporterImpl();
    }

    @Override
    public EligibilityImporter getEligibilityImporter() {
        return new EligibilityImporterImpl();
    }

    @Override
    public boolean isMemberEligible(Member member, List<Eligibility> eligibilities) {
        Date member_termination = null;
        for (Eligibility eligibility : eligibilities) {
            if (member.getId().equalsIgnoreCase(eligibility.getId())) {
                member_termination = eligibility.getEligibilityEndDate();
                break;
            }
        }

        if (member_termination != null)
            return member_termination.after(new Date()) ? true : false;

        return false;
    }

    public static void main(String[] args) throws IOException {
        String root_path = "/Users/Binay/Development/SDS/src/main/resources/";

        String member_input_path = root_path + "MemberInfo.dat";
        String eligibilty_input_path = root_path + "EligibilityInfo.dat";
        String member_output_path = root_path + "MemberOutput.dat";

        File memberInputFile = new File(member_input_path);
        File eligibilityInputFile = new File(eligibilty_input_path);
        File memberOutputFile = new File(member_output_path);

        MemberReports reports = new MemberReports();
        reports.convert(memberInputFile, eligibilityInputFile, memberOutputFile);
    }
}
