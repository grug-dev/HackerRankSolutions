package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HowSum {

  /**
   * Write a function howSum(targetSum, numbers) that should return an array containing any combination of elements
   * that add up to exactly the targetSum. If there is no combination that adds up to the targetSum, then return null;
   * <p>
   * If there are multiple combinations possible, you may return any single one.
   */
  private static List<Long> howSum(
          long targetSum,
          int[] numbers,
          HashMap<Long, List<Long>> memo
  ) {

    List<Long> memoVal = memo.getOrDefault(targetSum, null);
    if (memoVal != null) return memoVal;
    if (targetSum == 0) return new ArrayList<>();
    if (targetSum < 0) return null;

    List<Long> result = null;
    for (int n : numbers) {
      long remainder = targetSum - n;
      result = howSum(remainder, numbers, memo);
      if (result != null) {
        result.add((long) n);
        memo.put(targetSum, result);
        return result;
      }
    }

    return result;
  }

  static List<Long> howSum(long targetSum, int[] numbers) {
    return howSum(targetSum, numbers, new HashMap<>());
  }

}
