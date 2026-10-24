package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

  public static int pairs(int k, List<Integer> arr) {
    int count = 0;
    Set<Integer> map = new HashSet<>();
    for (int i = 0; i < arr.size(); i++) {
      int val = arr.get(i);
      if (map.contains(Math.abs(k - val))) {
        count++;
      }
      if (map.contains((k + val))) {
        count++;
      }
      map.add(val);
    }
    return count;
  }
}
