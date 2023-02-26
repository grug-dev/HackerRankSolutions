package com.kkpa.hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
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

  public static void main(String arg[]) {

    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] arr = new int[n];
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
    }
    int[] result = cutTheSticks(arr);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
    }
    System.out.println("");


    in.close();
  }

}
