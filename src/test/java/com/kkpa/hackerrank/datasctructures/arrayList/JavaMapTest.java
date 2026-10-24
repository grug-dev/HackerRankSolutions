package com.kkpa.hackerrank.datasctructures.arrayList;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/phone-book/problem
 * For each query, return "name=phone" or "Not found".
 */
public class JavaMapTest {

  private static Map<String, Integer> phoneBook() {
    Map<String, Integer> phoneBook = new HashMap<>();
    phoneBook.put("uncle sam", 99912222);
    phoneBook.put("tom", 11122222);
    phoneBook.put("harry", 12299933);
    return phoneBook;
  }

  @Test
  public void nameInThePhoneBook() {
    assertEquals("uncle sam=99912222", JavaMap.findEntry(phoneBook(), "uncle sam"));
    assertEquals("harry=12299933", JavaMap.findEntry(phoneBook(), "harry"));
  }

  @Test
  public void nameNotInThePhoneBook() {
    assertEquals("Not found", JavaMap.findEntry(phoneBook(), "uncle tom"));
  }

  @Test
  public void namesAreCaseSensitive() {
    assertEquals("Not found", JavaMap.findEntry(phoneBook(), "Tom"));
  }
}
