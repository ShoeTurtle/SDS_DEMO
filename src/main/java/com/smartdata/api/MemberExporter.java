package com.smartdata.api;

import com.smartdata.Member;

import java.io.File;
import java.io.Writer;

/**
 * User: Binay
 * Date: 16/01/15
 */
public interface MemberExporter {
    public void write(File outputFile, Member member, Writer writer);
}
