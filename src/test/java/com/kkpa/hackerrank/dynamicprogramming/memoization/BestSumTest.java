package com.kkpa.hackerrank.dynamicprogramming.memoization;

import com.kkpa.TestSupport;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * bestSum returns the SHORTEST combination of numbers that adds up to targetSum, or null if none exists.
 * With a tie any shortest combination is valid, so the tests check the sum and the size.
 */
public class BestSumTest {

  private static List<Long> bestSum(long targetSum, int... numbers) {
    return TestSupport.invokeStatic(BestSum.class, "bestSum", new Class<?>[]{long.class, int[].class}, targetSum, numbers);
  }

  private static void assertShortestCombination(long targetSum, int expectedSize, List<Long> combination) {
    assertNotNull("expected a combination for " + targetSum, combination);
    long sum = 0;
    for (long value : combination) {
      sum += value;
    }
    assertEquals("sum of " + combination, targetSum, sum);
    assertEquals("size of " + combination, expectedSize, combination.size());
  }

  @Test
  public void shortestCombinationWithTwoNumbers() {
    assertShortestCombination(7, 3, bestSum(7, 2, 3)); // 3 + 2 + 2
  }

  @Ignore("BUG: a shorter result is appended to 'shortest' (addAll) instead of replacing it, and memoized lists are changed in place. Returns [4, 3, 7]")
  @Test
  public void singleNumberIsTheShortest() {
    assertShortestCombination(7, 1, bestSum(7, 5, 3, 4, 7)); // 7
  }

  @Ignore("BUG: same as singleNumberIsTheShortest. Returns a list that adds up to 43, not 8")
  @Test
  public void shortestIsNotTheFirstFound() {
    assertShortestCombination(8, 2, bestSum(8, 2, 3, 5)); // 3 + 5
    assertShortestCombination(8, 2, bestSum(8, 1, 4, 5)); // 4 + 4
  }

  @Ignore("BUG: impossible remainders are stored as null, and null is read as 'not in memo', so they are computed again. Times out")
  @Test(timeout = 2000)
  public void largeTargetNeedsMemoization() {
    assertShortestCombination(100, 4, bestSum(100, 1, 2, 5, 25)); // 25 * 4
  }

  @Test
  public void zeroTargetReturnsEmptyCombination() {
    assertTrue(bestSum(0, 1, 2).isEmpty());
  }

  @Test
  public void impossibleTargetReturnsNull() {
    assertNull(bestSum(7, 2, 4));
  }
}
