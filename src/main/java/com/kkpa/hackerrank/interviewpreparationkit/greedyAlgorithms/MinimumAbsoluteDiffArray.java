package com.kkpa.hackerrank.interviewpreparationkit.greedyAlgorithms;

import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDiffArray {

  public static int minimumAbsoluteDifference(List<Integer> arr) {
    int result = Integer.MAX_VALUE;
    int length = arr.size();
    Collections.sort(arr);

    for (int j = 0; j < length - 1; j++) {
      int tmp = Math.abs(arr.get(j + 1) - arr.get(j));
      if (tmp < result) {
        result = tmp;
      }
    }

    return result;
  }
}
