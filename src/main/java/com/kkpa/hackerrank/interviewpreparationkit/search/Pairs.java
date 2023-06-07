package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

  public static void main(String[] args) {
    System.out.println(pairs(1, Arrays.asList(1, 2, 3, 4)));
    System.out.println(pairs(2, Arrays.asList(1, 5, 3, 4, 2)));
  }

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
