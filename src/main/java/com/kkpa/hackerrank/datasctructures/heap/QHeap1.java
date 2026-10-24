package com.kkpa.hackerrank.datasctructures.heap;

import java.util.PriorityQueue;

public class QHeap1 {

  static PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

  private static void printMinimumValueFromHeap() {
    System.out.println(pQueue.peek());

  }

  private static void addToHead(int value) {
    pQueue.add(value);
  }

  private static void removeFromHeap(int value) {
    pQueue.remove(value);
  }

}
