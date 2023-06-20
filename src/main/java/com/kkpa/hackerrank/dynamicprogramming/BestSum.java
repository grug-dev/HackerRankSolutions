package com.kkpa.hackerrank.dynamicprogramming;

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


  private static List<Long> bestSum(long targetSum, int[] numbers) {
    HashMap<Long, List<Long>> memo = new HashMap<>();
    return bestSum(targetSum, numbers, memo);
  }

  public static void main(String[] args) {
    System.out.println(" true " + bestSum(7, new int[]{2, 3}));
    System.out.println(" true " + bestSum(7, new int[]{8, 2, 4, 1, 7}));
    System.out.println(" false " + bestSum(100, new int[]{1, 4, 5, 25}));
  }

}
