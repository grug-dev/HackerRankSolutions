package com.kkpa.hackerrank.algorithms.implementation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * https://www.hackerrank.com/challenges/cut-the-sticks/problem
 * Before each cut, record how many sticks are left. Then cut every stick by the shortest length
 * and throw away the sticks that reach 0.
 */
public class CutTheSticksTest {

  @Test
  public void hackerRankSample0() {
    assertArrayEquals(new int[]{6, 4, 2, 1}, CutTheSticks.cutTheSticks(new int[]{5, 4, 4, 2, 2, 8}));
  }

  @Test
  public void hackerRankSample1() {
    assertArrayEquals(new int[]{8, 6, 4, 1}, CutTheSticks.cutTheSticks(new int[]{1, 2, 3, 4, 3, 3, 2, 1}));
  }

  @Test
  public void allDifferentLengths() {
    assertArrayEquals(new int[]{8, 7, 6, 4, 3, 2, 1}, CutTheSticks.cutTheSticks(new int[]{1, 13, 3, 8, 14, 9, 4, 4}));
  }

  @Test
  public void allSticksTheSameLength() {
    assertArrayEquals(new int[]{3}, CutTheSticks.cutTheSticks(new int[]{7, 7, 7}));
  }
}
