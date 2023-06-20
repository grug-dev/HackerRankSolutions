package com.kkpa.hackerrank.dynamicprogramming;

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

  public static void main(String[] args) {
    System.out.println(" true " + canSum(7, new int[]{2, 3}));
    System.out.println(" true " + canSum(7, new int[]{5, 3, 4, 7}));
    System.out.println(" false " + canSum(7, new int[]{2, 4}));
    System.out.println(" false " + canSum(300, new int[]{7, 14}));
  }

}
