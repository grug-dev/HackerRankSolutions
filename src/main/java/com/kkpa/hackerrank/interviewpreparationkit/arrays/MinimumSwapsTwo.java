package com.kkpa.hackerrank.interviewpreparationkit.arrays;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MinimumSwapsTwo {

  // Complete the minimumSwaps function below.
  public int minimumSwapsCollection(int[] arr) {
    List<Integer> unorderInitial = Arrays.stream(arr).boxed().collect(Collectors.toList());
    int n = arr.length;

    int swapsCount = 0;
    for (int i = 1; i <= n; i++) {
      int value = unorderInitial.get(i - 1);
      if (value == i) {
        continue;
      } else {
        int lastIndex = unorderInitial.lastIndexOf(i);
        Collections.swap(unorderInitial, i - 1, lastIndex);

        swapsCount++;
      }
    }

    return swapsCount;
  }

  public int minimSwapArray(int [] arr) {
    int countSwaps = 0;
int i = 0;

    while (i < arr.length) {
      int correctIdx = arr[i] - 1;

      if (i != correctIdx) {
        int tmp = arr[i];
        arr[i] = arr[correctIdx];
        arr[correctIdx] = tmp;

        countSwaps++;
      }else {
        i++;
      }
    }



    return countSwaps;

  }

}
