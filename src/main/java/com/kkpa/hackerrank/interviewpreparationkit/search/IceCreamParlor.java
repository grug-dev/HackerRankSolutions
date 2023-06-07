package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
public class IceCreamParlor {

  public static void whatFlavors(List<Integer> cost, int money) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < cost.size(); i++) {
      int target = money - cost.get(i);
      if (map.containsKey(target)) {
        System.out.println(map.get(target) + " " + (i + 1));
        break;
      }
      map.put(cost.get(i), i + 1);
    }
  }

  public static void main(String[] args) {
    whatFlavors(Arrays.asList(1, 4, 5, 3, 2), 4);
    whatFlavors(Arrays.asList(2, 2, 4, 3), 4);
  }
}
