package com.kkpa.hackerrank.dynamicprogramming.memoization;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * howSum returns any combination of numbers that adds up to targetSum, or null if none exists.
 * Any valid combination is accepted, so the tests check the sum, not the exact list.
 */
public class HowSumTest {

  private static List<Long> howSum(long targetSum, int... numbers) {
    return HowSum.howSum(targetSum, numbers);
  }

  private static void assertValidCombination(long targetSum, int[] numbers, List<Long> combination) {
    assertNotNull("expected a combination for " + targetSum, combination);
    long sum = 0;
    for (long value : combination) {
      boolean allowed = false;
      for (int n : numbers) {
        allowed |= n == value;
      }
      assertTrue(value + " is not one of the numbers", allowed);
      sum += value;
    }
    assertEquals(targetSum, sum);
  }

  @Test
  public void returnsACombinationThatAddsUpToTheTarget() {
    int[] numbers = {2, 3};
    assertValidCombination(7, numbers, howSum(7, numbers));
  }

  @Test
  public void returnsACombinationWhenSeveralExist() {
    int[] numbers = {8, 2, 4, 1, 7};
    assertValidCombination(7, numbers, howSum(7, numbers));
  }

  @Test
  public void returnsACombinationForALargerTarget() {
    int[] numbers = {2, 3, 5};
    assertValidCombination(8, numbers, howSum(8, numbers));
  }

  @Test
  public void zeroTargetReturnsEmptyCombination() {
    assertTrue(howSum(0, 1, 2).isEmpty());
  }

  @Test
  public void impossibleTargetReturnsNull() {
    assertNull(howSum(7, 2, 4));
  }
}
