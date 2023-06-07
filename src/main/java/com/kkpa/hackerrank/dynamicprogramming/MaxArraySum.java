package com.kkpa.hackerrank.dynamicprogramming;

import java.util.List;

public class MaxArraySum {

  /*
   * Complete the 'maxSubsetSum' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public int maxSubsetSum(List<Integer> arr) {
    int size = arr.size();
    if (size == 0) {
      return 0;
    }

    int[] dp = new int[size];
    dp[0] = Math.max(0, arr.get(0));

    if (size > 1) {
      dp[1] = Math.max(dp[0], arr.get(1));
    }

    for (int i = 2; i < size; i++) {
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + arr.get(i));
    }

    return dp[size - 1];
  }
}
