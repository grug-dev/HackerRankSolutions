package com.kkpa.hackerrank.interviewpreparationkit.warmup;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem
 * The string s repeats forever. Count the letter 'a' in the first n characters.
 * The logic lives in the package-private class Result, in RepeatedString.java.
 */
public class RepeatedStringTest {

  @Test
  public void hackerRankSample0() {
    assertEquals(7L, Result.repeatedString("aba", 10));
  }

  @Test
  public void hackerRankSample1() {
    assertEquals(1000000000000L, Result.repeatedString("a", 1000000000000L));
  }

  @Test
  public void partialRepetitionAtTheEnd() {
    assertEquals(4L, Result.repeatedString("abcac", 10));
  }

  @Test
  public void noLetterA() {
    assertEquals(0L, Result.repeatedString("b", 5));
  }

  @Test
  public void nSmallerThanTheString() {
    assertEquals(1L, Result.repeatedString("abaa", 2));
  }
}
