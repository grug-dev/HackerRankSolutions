package com.kkpa.hackerrank.datasctructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/crush/problem
 * Each query [a, b, k] adds k to positions a..b (1-based). Return the largest value at the end.
 */
public class ArrayManipulationTest {

  @Test
  public void hackerRankSample() {
    assertEquals(200L, ArrayManipulation.arrayManipulation(5, new int[][]{{1, 2, 100}, {2, 5, 100}, {3, 4, 100}}));
  }

  @Test
  public void overlappingRanges() {
    assertEquals(10L, ArrayManipulation.arrayManipulation(10, new int[][]{{1, 5, 3}, {4, 8, 7}, {6, 9, 1}}));
    assertEquals(31L, ArrayManipulation.arrayManipulation(10, new int[][]{{2, 6, 8}, {3, 5, 7}, {1, 8, 1}, {5, 9, 15}}));
  }

  @Test
  public void resultLargerThanAnInt() {
    int[][] queries = new int[3][];
    for (int i = 0; i < queries.length; i++) {
      queries[i] = new int[]{1, 10, 1000000000};
    }
    assertEquals(3000000000L, ArrayManipulation.arrayManipulation(10, queries));
  }
}
