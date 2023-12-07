package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.HashMap;

public class GridTraveler {

  public static void main(String[] args) {
    System.out.println(" 1 - " + gridTraveler(1, 1));
    System.out.println(" 3 - " + gridTraveler(2, 3));
    System.out.println(" 3 - " + gridTraveler(3, 2));
    System.out.println(" 6 - " + gridTraveler(3, 3));
    System.out.println(" 2333606220 - " + gridTraveler(18, 18));
  }

  private static long gridTraveler(int m, int n) {
    return gridTraveler(m, n, new HashMap<>());
  }

  private static long gridTraveler(int m, int n, HashMap<String, Long> memo) {

    if (m == 1 && n == 1) {
      return 1;
    }
    if (m == 0 || n == 0) {
      return 0;
    }
    String key = String.format("%d-%d", m, n);
    Long result = memo.getOrDefault(key, null);
    if (result != null) {
      return result;
    }
    result = gridTraveler(m - 1, n, memo) + gridTraveler(m, n - 1, memo);
    memo.put(key, result);
    return result;
  }

}
