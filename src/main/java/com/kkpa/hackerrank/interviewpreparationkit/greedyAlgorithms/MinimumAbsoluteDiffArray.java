package com.kkpa.hackerrank.interviewpreparationkit.greedyAlgorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDiffArray {

  public static void main(String[] args) {
    List<Integer> arr = Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75);
    System.out.printf("result: " + minimumAbsoluteDifference(arr));
  }

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
