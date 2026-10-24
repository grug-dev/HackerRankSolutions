package com.kkpa.hackerrank.interviewpreparationkit.greedyAlgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/angry-children/problem
 * Pick k numbers so that max - min is as small as possible. Return that difference.
 */
public class MaxMinTest {

  private static List<Integer> list(Integer... values) {
    return new ArrayList<>(Arrays.asList(values));
  }

  @Test
  public void hackerRankSample0() {
    assertEquals(20, MaxMin.maxMin(3, list(10, 100, 300, 200, 1000, 20, 30)));
  }

  @Test
  public void hackerRankSample1() {
    assertEquals(3, MaxMin.maxMin(4, list(1, 2, 3, 4, 10, 20, 30, 40, 100, 200)));
  }

  @Test
  public void hackerRankSample2() {
    assertEquals(0, MaxMin.maxMin(2, list(1, 2, 1, 2, 1)));
  }

  @Test
  public void bestGroupAtTheEnd() {
    assertEquals(2, MaxMin.maxMin(3, list(100, 200, 300, 350, 400, 401, 402)));
  }

  @Test
  public void kEqualsTheSizeOfTheArray() {
    assertEquals(9, MaxMin.maxMin(3, list(5, 1, 10)));
  }
}
