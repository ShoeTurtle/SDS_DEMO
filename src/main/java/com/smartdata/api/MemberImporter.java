package com.smartdata.api;

import com.smartdata.Member;

import java.io.File;
import java.util.List;

/**
 * User: Binay
 * Date: 16/01/15
 * Time: 2:50 PM
 */
public interface MemberImporter {
    public List<Member> prepareMember(File inputPath);
}
