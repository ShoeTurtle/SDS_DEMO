package com.smartdata.api;

import com.smartdata.Eligibility;

import java.io.File;
import java.util.List;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 2:51 PM
 */
public interface EligibilityImporter {
    public List<Eligibility> prepareEligibility(File inputFile);
}
