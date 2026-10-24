package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class MarkAndToys {

  public static int maximumToys(List<Integer> prices, int budget) {
    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

    prices.sort(Integer::compareTo);
    IntStream.range(0, prices.size()).forEach(pointer -> {
      int maxToys = 0;
      int total = 0;
      for (int i = pointer; i < prices.size(); i++) {
        int price = prices.get(i);
        total += price;
        if (total <= budget) {
          maxToys++;
        } else {
          break;
        }
      }
      priorityQueue.add(maxToys);
      if (priorityQueue.size() > 1) {
        priorityQueue.poll();
      }
    });
    return priorityQueue.poll();
  }

}
