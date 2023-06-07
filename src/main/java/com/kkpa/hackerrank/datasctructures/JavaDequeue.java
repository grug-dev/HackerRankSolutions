package com.kkpa.hackerrank.datasctructures;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

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

  public static void main(String[] args) {

    /*
    * Deque interfaces can be implemented using various types of collections such as LinkedList or ArrayDeque classes.
    *  For example, deque can be declared as:

    Deque deque = new LinkedList<>();
    or
    Deque deque = new ArrayDeque<>();
    * */

    Scanner scanner = new Scanner(System.in);
    Deque deque = new LinkedList<>();
    HashSet hashSet = new HashSet<>();
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int max = 0;
    for (int i = 0; i < n; i++) {
      int input = scanner.nextInt();
      deque.add(input);
      hashSet.add(input);
      if (deque.size() == m) {
        max = Math.max(max, hashSet.size());
        int remove = (int) deque.removeFirst();
        if (!deque.contains(remove)) {
          hashSet.remove(remove);
        }
      }
    }
    System.out.println(max);

  }

  private static int checkUniqueNumber(Deque<Integer> deque) {
    return new HashSet<Integer>(deque).size();
  }
}
