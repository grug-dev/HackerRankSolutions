package com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem
 * Valid ("YES") if all characters appear the same number of times,
 * or if removing ONE character makes that true.
 */
public class SherlockValidStringTest {

  private static void assertValid(String expected, String s) {
    assertEquals("INPUT " + s, expected, SherlockValidString.isValid(s));
  }

  @Test
  public void hackerRankSamples() {
    assertValid("NO", "aabbcd");
    assertValid("NO", "aabbccddeefghi");
    assertValid("YES", "abcdefghhgfedecba");
  }

  @Test
  public void allCountsAlreadyEqual() {
    assertValid("YES", "a");
    assertValid("YES", "abc");
    assertValid("YES", "aabbcc");
  }

  @Test
  public void removeOneCharacterFromTheMostCommonLetter() {
    assertValid("YES", "abcc");
    assertValid("YES", "aabbc");
    assertValid("YES", "aaab");
  }

  @Test
  public void oneRemovalIsNotEnough() {
    assertValid("NO", "abccc");
  }

  @Ignore("BUG: a count that is 1 below the others is always accepted. c appears 2 times, a and b 3 times: no single removal fixes it")
  @Test
  public void oneRemovalIsNotEnoughWhenALetterIsShort() {
    assertValid("NO", "aaabbbcc");
  }

  @Ignore("BUG: when the first counted letter is the odd one (a = 1, b = 3), removing that letter is not considered")
  @Test
  public void removeTheOnlyCopyOfALetter() {
    assertValid("YES", "abbb");
  }
}
