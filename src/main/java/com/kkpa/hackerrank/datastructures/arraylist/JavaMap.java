package com.kkpa.hackerrank.datastructures.arraylist;


import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true
 */
public class JavaMap {

  /**
   * Returns "name=phone" when the name is in the phone book, otherwise "Not found".
   */
  public static String findEntry(Map<String, Integer> phoneBook, String name) {
    Integer phone = phoneBook.get(name);
    return phone != null ? String.format("%s=%d", name, phone) : "Not found";
  }
}
