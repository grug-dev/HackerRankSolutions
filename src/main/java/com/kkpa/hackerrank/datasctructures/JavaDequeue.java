package com.kkpa.hackerrank.datasctructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://www.hackerrank.com/challenges/java-dequeue/problem?isFullScreen=true&h_r=next-challenge&h_v=zen
 * <p>
 * <p>
 * In computer science, a double-ended queue (dequeue, often abbreviated to deque, pronounced deck)
 * is an abstract data type that generalizes a queue,
 * for which elements can be added to or removed from either the front (head) or back (tail).
 */
public class JavaDequeue {

  private static Deque<Integer> deque = new ArrayDeque<>();

  /**
   * Returns the maximum number of unique values in any window of m consecutive numbers.
   */
  public static int maxUnique(int[] numbers, int m) {
    Deque<Integer> window = new LinkedList<>();
    HashSet<Integer> unique = new HashSet<>();
    int max = 0;
    for (int number : numbers) {
      window.add(number);
      unique.add(number);
      if (window.size() == m) {
        max = Math.max(max, unique.size());
        int remove = window.removeFirst();
        if (!window.contains(remove)) {
          unique.remove(remove);
        }
      }
    }
    return max;
  }

  private static int checkUniqueNumber(Deque<Integer> deque) {
    return new HashSet<Integer>(deque).size();
  }
}
