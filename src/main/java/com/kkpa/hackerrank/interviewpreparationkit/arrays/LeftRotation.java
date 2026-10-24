package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeftRotation {

  // Complete the rotLeft function below.
  public int[] rotLeft(int[] a, int d) {
    List<Integer> tmpResult = rotateLeft(d, Arrays.stream(a).boxed().collect(Collectors.toList()));

    int n = a.length;
    int[] result = new int[n];
    if (d >= n) {
      d = d % n;
    }

    if (d == 0) {
      return a;
    }

    for (int i = 0; i < n; i++) {
      int newPosition = (n - (d - i));
      if (newPosition >= n) {
        newPosition = newPosition % n;
      }
      result[newPosition] = a[i];
    }
    return result;
  }

  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    int n = arr.size();
    d = d % n;

    List<Integer> result = new ArrayList<>(n);

    for (int i = 0; i < n; i++) {
      int newIndex = (i + d) % n;
      result.add(arr.get(newIndex));
    }

    return result;
  }

}
