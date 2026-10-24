package com.kkpa.hackerrank.datasctructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/arrays-ds/problem
 * Return the array in reverse order.
 */
public class ArraysDSTest {

  @Test
  public void hackerRankSample() {
    assertArrayEquals(new int[]{2, 3, 4, 1}, ArraysDS.reverseArray(new int[]{1, 4, 3, 2}));
  }

  @Test
  public void singleElement() {
    assertArrayEquals(new int[]{7}, ArraysDS.reverseArray(new int[]{7}));
  }

  @Test
  public void emptyArray() {
    assertArrayEquals(new int[]{}, ArraysDS.reverseArray(new int[]{}));
  }

  @Test
  public void doesNotChangeTheInput() {
    int[] input = {1, 2, 3};
    ArraysDS.reverseArray(input);
    assertArrayEquals(new int[]{1, 2, 3}, input);
  }
}
