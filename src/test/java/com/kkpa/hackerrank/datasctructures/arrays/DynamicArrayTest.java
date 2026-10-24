package com.kkpa.hackerrank.datasctructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/dynamic-array/problem
 * Query 1 x y appends y to list ((x ^ lastAnswer) % n).
 * Query 2 x y sets lastAnswer to element (y % size) of that list and records it.
 */
public class DynamicArrayTest {

  @Test
  public void hackerRankSample() {
    int[][] queries = {{1, 0, 5}, {1, 1, 7}, {1, 0, 3}, {2, 1, 0}, {2, 1, 1}};
    assertArrayEquals(new int[]{7, 3}, DynamicArray.dynamicArray(2, queries));
  }

  @Test
  public void noType2QueryReturnsEmptyResult() {
    int[][] queries = {{1, 0, 5}, {1, 1, 7}};
    assertArrayEquals(new int[]{}, DynamicArray.dynamicArray(2, queries));
  }

  @Test
  public void eachCallStartsWithEmptyLists() {
    int[][] queries = {{1, 0, 5}, {2, 0, 0}};
    assertArrayEquals(new int[]{5}, DynamicArray.dynamicArray(1, queries));
    assertArrayEquals(new int[]{5}, DynamicArray.dynamicArray(1, queries));
  }
}
