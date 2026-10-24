package com.kkpa.hackerrank.datastructures.heap;

import java.util.PriorityQueue;

public class QHeap1 {

  static PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();

  static void printMinimumValueFromHeap() {
    System.out.println(pQueue.peek());

  }

  static void addToHead(int value) {
    pQueue.add(value);
  }

  static void removeFromHeap(int value) {
    pQueue.remove(value);
  }

}
