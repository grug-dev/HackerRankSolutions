package com.kkpa.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CutTheSticks {

  static int[] cutTheSticks(int[] arr) {
    List<Integer> stick = Arrays.stream(arr).boxed().collect(Collectors.toList());
    List<Integer> result = new ArrayList<>();

    while (!stick.isEmpty()) {
      result.add(stick.size());
      int min = stick.stream().min(Integer::compareTo).orElse(null);
      stick = stick.stream().filter(n -> n.intValue() != min).collect(Collectors.toList());
    }
    return result.stream().mapToInt(Integer::intValue).toArray();
  }

}
