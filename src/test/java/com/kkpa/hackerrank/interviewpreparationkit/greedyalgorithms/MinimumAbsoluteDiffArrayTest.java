package com.kkpa.hackerrank.interviewpreparationkit.greedyalgorithms;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 * Return the smallest |a[i] - a[j]| over all pairs i != j.
 */
public class MinimumAbsoluteDiffArrayTest {

  private static List<Integer> list(Integer... values) {
    return new ArrayList<>(Arrays.asList(values));
  }

  @Test
  public void hackerRankSample0() {
    assertEquals(3, MinimumAbsoluteDiffArray.minimumAbsoluteDifference(list(3, -7, 0)));
  }

  @Test
  public void hackerRankSample1() {
    assertEquals(1, MinimumAbsoluteDiffArray.minimumAbsoluteDifference(list(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)));
  }

  @Test
  public void hackerRankSample2() {
    assertEquals(3, MinimumAbsoluteDiffArray.minimumAbsoluteDifference(list(1, -3, 71, 68, 17)));
  }

  @Test
  public void duplicatesGiveZero() {
    assertEquals(0, MinimumAbsoluteDiffArray.minimumAbsoluteDifference(list(4, 9, 4)));
  }

  @Test
  public void twoElements() {
    assertEquals(7, MinimumAbsoluteDiffArray.minimumAbsoluteDifference(list(10, 3)));
  }
}
