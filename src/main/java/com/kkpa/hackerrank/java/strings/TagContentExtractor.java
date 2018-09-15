package com.kkpa.hackerrank.java.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

  public final static String NONE = "None";

  public String extract(String word) {

    Pattern p = Pattern.compile("<(.+)>([^<]+)</\\1>");
    Matcher m = p.matcher(word);

    boolean found = false;
    while (m.find()) {

      // get the matching group
      String codeGroup = m.group(2);

      // print the group
      System.out.format("%s\n", codeGroup);
      found = true;

      return codeGroup;


    }

    if (!found) {
      System.out.println(NONE);
    }


    return NONE;

  }



}
