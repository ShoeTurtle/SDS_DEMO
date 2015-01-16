package com.smartdata.impl;

import com.smartdata.Eligibility;
import com.smartdata.api.EligibilityImporter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 5:18 PM
 */
public class EligibilityImporterImpl implements EligibilityImporter {
    @Override
    public List<Eligibility> prepareEligibility(File inputFile) {
        List<Eligibility> eligibilityCollection = new ArrayList<Eligibility>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            String line;
            while ((line = br.readLine()) != null) {
                Eligibility eligibility = new Eligibility();

                List<String> parts = Arrays.asList(line.split("[\\|]"));

                SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
                Date eligibilityStartDate = simpleDate.parse(parts.get(1).trim());
                Date eligibilityEndDate = simpleDate.parse(parts.get(2).trim());

                eligibility.setId(parts.get(0));
                eligibility.setEligibilityStartDate(eligibilityStartDate);
                eligibility.setEligibilityEndDate(eligibilityEndDate);

                eligibilityCollection.add(eligibility);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eligibilityCollection;
    }
}
