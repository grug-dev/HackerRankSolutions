package com.kkpa.hackerrank.datasctructures.arrays;

import java.util.HashSet;
import java.util.Set;

public class JavaHashSet {

  public static void uniquePairs(String[] pairLeft, String[] pairRight) {
    Set<String> pairSet = new HashSet<>();

    int n = pairLeft.length;
    for (int i = 0; i < n; i++) {
      String pair = String.join("-", pairLeft[i], pairRight[i]);
      pairSet.add(pair);
      System.out.println(pairSet.size());
    }
  }
}
