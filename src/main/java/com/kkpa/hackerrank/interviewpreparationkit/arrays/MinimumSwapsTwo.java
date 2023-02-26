package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MinimumSwapsTwo {

  // Complete the minimumSwaps function below.
  public int minimumSwaps(int[] arr) {
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

}
