package com.kkpa.hackerrank.datastructures.arrays;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ArrayManipulation {

  // Complete the arrayManipulation function below.
  static long arrayManipulation(int n, int[][] queries) {
    Map<Integer, Long> fragments = new TreeMap<>();
    Arrays.stream(queries)
        .forEach(
            q -> {
              long k = q[2];
              fragments.merge(q[0], k, Long::sum);
              fragments.merge(q[1] + 1, -k, Long::sum);
            });
    long overlappingValue = 0, result = 0;
    for (long value : fragments.values()) {
      result = Long.max(overlappingValue += value, result);
    }
    return result;
  }
}
