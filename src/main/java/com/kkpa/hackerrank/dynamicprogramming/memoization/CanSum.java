package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.HashMap;

public class CanSum {

  /**
   * The function should return a boolean indicating whether or not i
   * is possible to generate the targetSum using numbers from the array.
   * <p>
   * You may use an element of the array as many times as needed.
   * You may assume that all input numbers are nonnegative.
   *
   * @param targetSum
   * @param numbers
   * @return
   */
  private static boolean canSum(long targetSum, int[] numbers, HashMap<Long, Boolean> memo) {
    boolean result = false;
    Boolean memoVal = memo.getOrDefault(targetSum, null);
    if (memoVal != null) return memoVal;
    if (targetSum == 0) return true;
    if (targetSum < 0) return false;

    for (int n : numbers) {
      long remainder = targetSum - n;
      result = canSum(remainder, numbers, memo);
      memo.put((long) remainder, result);
      if (result) {
        return result;
      }
    }

    return result;
  }

  private static boolean canSum(long targetSum, int[] numbers) {
    return canSum(targetSum, numbers, new HashMap<>());
  }

}
