package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BubbleSort {

  public static void countSwaps(List<Integer> lst) {
    // Write your code here
    int n = lst.size();
    int swapCounts = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        // Swap adjacent elements if they are in decreasing order
        if (lst.get(j) > lst.get(j + 1)) {
          Collections.swap(lst, j, j + 1);
          swapCounts++;
        }
      }
    }
    System.out.println("Array is sorted in " + swapCounts + " swaps");
    System.out.println("First Element: " + lst.get(0));
    System.out.println("Last Element: " + lst.get(n - 1));
  }

  public static void main(String[] args) {
    countSwaps(Arrays.asList(1, 2, 3));
  }
}
