package com.kkpa.hackerrank.datastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 * An hourglass is 3 cells on top, 1 in the middle, 3 at the bottom. Return the largest hourglass sum in a 6x6 array.
 */
public class Arrays2DSTest {

  @Test
  public void hackerRankSample() {
    int[][] arr = {
            {1, 1, 1, 0, 0, 0},
            {0, 1, 0, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
            {0, 0, 2, 4, 4, 0},
            {0, 0, 0, 2, 0, 0},
            {0, 0, 1, 2, 4, 0}};
    assertEquals(19, Arrays2DS.hourglassSum(arr));
  }

  @Test
  public void allNegativeValues() {
    int[][] arr = {
            {-1, -1, 0, -9, -2, -2},
            {-2, -1, -6, -8, -2, -5},
            {-1, -1, -1, -2, -3, -4},
            {-1, -9, -2, -4, -4, -5},
            {-7, -3, -3, -2, -9, -9},
            {-1, -3, -1, -2, -4, -5}};
    assertEquals(-6, Arrays2DS.hourglassSum(arr));
  }

  @Test
  public void middleRowCornersAreNotPartOfTheHourglass() {
    // A 3x3 array has only one hourglass. The two 100s are outside it.
    int[][] arr = {
            {1, 1, 1},
            {100, 1, 100},
            {1, 1, 1}};
    assertEquals(7, Arrays2DS.hourglassSum(arr));
  }
}
