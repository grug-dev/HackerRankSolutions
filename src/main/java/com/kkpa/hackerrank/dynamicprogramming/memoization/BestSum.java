package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BestSum {

  /**
   * Write a function `bestSum(targetSum,numbers)` that takes in a targetSum and an array of numbers as arguments.
   * <p>
   * The function should return an array containing the shortest combination of numbers that add up to exactly the target sum.
   * <p>
   * If there is a tie for the shortest combination, you may return any of the shortest.
   */
  private static List<Long> bestSum(
          long targetSum,
          int[] numbers,
          HashMap<Long, List<Long>> memo
  ) {

    List<Long> memoVal = memo.getOrDefault(targetSum, null);
    if (memoVal != null) return memoVal;

    List<Long> shortest = null;
    if (targetSum == 0) return new ArrayList<>();
    if (targetSum < 0) return null;

    for (int n : numbers) {
      long remainder = targetSum - n;
      List<Long> result = bestSum(remainder, numbers, memo);
      if (result != null) {
        result.add((long) n);
        if (shortest == null || result.size() < shortest.size()) {
          if (shortest == null) {
            shortest = new ArrayList<>();
          }
          shortest.addAll(result);
        }
      }
    }

    memo.put(targetSum, shortest);
    return shortest;
  }

  static List<Long> bestSum(long targetSum, int[] numbers) {
    HashMap<Long, List<Long>> memo = new HashMap<>();
    return bestSum(targetSum, numbers, memo);
  }

}
