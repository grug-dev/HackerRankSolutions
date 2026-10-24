package com.kkpa.hackerrank.dynamicprogramming.memoization;

import com.kkpa.TestSupport;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Can targetSum be built from the numbers? Each number can be used many times.
 */
public class CanSumTest {

  private static boolean canSum(long targetSum, int... numbers) {
    return TestSupport.invokeStatic(CanSum.class, "canSum", new Class<?>[]{long.class, int[].class}, targetSum, numbers);
  }

  @Test
  public void possibleSums() {
    assertTrue(canSum(7, 2, 3));
    assertTrue(canSum(7, 5, 3, 4, 7));
    assertTrue(canSum(8, 2, 3, 5));
  }

  @Test
  public void impossibleSums() {
    assertFalse(canSum(7, 2, 4));
    assertFalse(canSum(7));
  }

  @Test
  public void zeroIsAlwaysPossible() {
    assertTrue(canSum(0, 5));
  }

  @Test(timeout = 2000)
  public void largeImpossibleSumNeedsMemoization() {
    assertFalse(canSum(300, 7, 14));
  }
}
