package com.kkpa.hackerrank.algorithms.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Insertion_Sort_Part1 {

  public String insertionSort1(int n, int[] arr) {
    List<Integer> data = Arrays.stream(arr).boxed().collect(Collectors.toList());

    int pivot = data.get(n - 1);

    for (int j = n - 2; j >= 0; j--) {
      int value = data.get(j);
      if (value < pivot) {
        data.set(j + 1, pivot);
        System.out.println("" + data.stream().map(d -> "" + d).collect(Collectors.joining(" ")));
        break;
      } else {
        data.set(j + 1, value);
        data.set(j, value);
        System.out.println("" + data.stream().map(d -> "" + d).collect(Collectors.joining(" ")));
      }

    }

    return data.stream().map(d -> "" + d).collect(Collectors.joining(" "));
  }
}
