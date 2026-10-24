package com.kkpa.hackerrank.dynamicprogramming.memoization;

import com.kkpa.TestSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Count the ways to travel from the top-left to the bottom-right of an m x n grid,
 * moving only down or right.
 */
public class GridTravelerTest {

  private static long gridTraveler(int m, int n) {
    return TestSupport.invokeStatic(GridTraveler.class, "gridTraveler", new Class<?>[]{int.class, int.class}, m, n);
  }

  @Test
  public void oneCellHasOneWay() {
    assertEquals(1L, gridTraveler(1, 1));
  }

  @Test
  public void emptyGridHasNoWay() {
    assertEquals(0L, gridTraveler(0, 1));
    assertEquals(0L, gridTraveler(1, 0));
    assertEquals(0L, gridTraveler(0, 0));
  }

  @Test
  public void smallGrids() {
    assertEquals(3L, gridTraveler(2, 3));
    assertEquals(3L, gridTraveler(3, 2));
    assertEquals(6L, gridTraveler(3, 3));
  }

  @Test
  public void largeGridNeedsMemoization() {
    assertEquals(2333606220L, gridTraveler(18, 18));
  }
}
