package com.kkpa.hackerrank.java.strings;

/**
 * https://www.hackerrank.com/challenges/tag-content-extractor/problem?isFullScreen=true
 */

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {

  // Same opening and closing tag name (\1), and content with no other tag inside.
  private static final Pattern VALID_TAG = Pattern.compile("<(.+)>([^<]+)</\\1>");

  /**
   * Returns the content of every valid tag in the line, in order. Empty when there is none
   * (HackerRank prints "None" in that case).
   */
  public List<String> extract(String line) {
    List<String> contents = new ArrayList<>();
    Matcher m = VALID_TAG.matcher(line);
    while (m.find()) {
      contents.add(m.group(2));
    }
    return contents;
  }

}
