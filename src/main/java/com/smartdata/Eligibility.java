package com.smartdata;

import java.util.Date;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 2:54 PM
 */
public class Eligibility {
    String id;
    Date eligibilityStartDate;
    Date eligibilityEndDate;

    public void setId(String id) {
        this.id = id;
    }

    public void setEligibilityStartDate(Date eligibilityStartDate) {
        this.eligibilityStartDate = eligibilityStartDate;
    }

    public void setEligibilityEndDate(Date eligibilityEndDate) {
        this.eligibilityEndDate = eligibilityEndDate;
    }

    public String getId() {
        return this.id;
    }

    public Date getEligibilityStartDate() {
        return this.eligibilityStartDate;
    }

    public Date getEligibilityEndDate() {
        return this.eligibilityEndDate;
    }

    public String toString() {
        return id + " " + eligibilityStartDate + " " + eligibilityEndDate;
    }
}
