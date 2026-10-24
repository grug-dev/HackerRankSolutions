package com.kkpa.hackerrank.datasctructures.arrays;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaSubArray {

  public static int negativesFrom(int[] data) {
    AtomicInteger totalNegatives = new AtomicInteger();

    IntStream.range(0, data.length).forEach((i) -> {

      if (data[i] < 0) {
        totalNegatives.getAndIncrement();
      }

      IntStream.range(i + 1, data.length).forEach(j -> {

        List<Integer> subArray = Arrays.stream(data).boxed().collect(Collectors.toList()).subList(i, j + 1);
        int totalSum = subArray.stream().mapToInt(k -> k).sum();
        if (totalSum < 0) {
          totalNegatives.getAndIncrement();
        }

      });
    });

    return totalNegatives.get();
  }

}
