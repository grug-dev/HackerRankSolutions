package com.kkpa.hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/sparse-arrays/problem
 * For each query, count how many input strings are exactly equal to it.
 */
public class SparseArraysTest {

  @Test
  public void hackerRankSample0() {
    String[] strings = {"aba", "baba", "aba", "xzxb"};
    String[] queries = {"aba", "xzxb", "ab"};
    assertArrayEquals(new int[]{2, 1, 0}, SparseArrays.matchingStrings(strings, queries));
  }

  @Test
  public void hackerRankSample1() {
    String[] strings = {"def", "de", "fgh"};
    String[] queries = {"de", "lmn", "fgh"};
    assertArrayEquals(new int[]{1, 0, 1}, SparseArrays.matchingStrings(strings, queries));
  }

  @Test
  public void matchIsExactNotPartial() {
    String[] strings = {"abc", "ab", "abcd"};
    String[] queries = {"ab", "abc"};
    assertArrayEquals(new int[]{1, 1}, SparseArrays.matchingStrings(strings, queries));
  }
}
