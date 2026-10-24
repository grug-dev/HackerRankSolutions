package com.kkpa.hackerrank.datasctructures.heap;

import com.kkpa.TestSupport;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/qheap1/problem
 * Add a value, delete a value, and print the minimum.
 * The heap is a static field and the methods are private, so each test empties it first
 * and calls the methods by reflection.
 */
public class QHeap1Test {

  @Before
  public void emptyTheHeap() {
    QHeap1.pQueue.clear();
  }

  private static void add(int value) {
    TestSupport.invokeStatic(QHeap1.class, "addToHead", new Class<?>[]{int.class}, value);
  }

  private static void delete(int value) {
    TestSupport.invokeStatic(QHeap1.class, "removeFromHeap", new Class<?>[]{int.class}, value);
  }

  private static String printMinimum() {
    return TestSupport.captureOutput(
            () -> TestSupport.invokeStatic(QHeap1.class, "printMinimumValueFromHeap", new Class<?>[]{}));
  }

  @Test
  public void hackerRankSample() {
    add(4);
    add(9);
    assertEquals("4\n", printMinimum());
    delete(4);
    assertEquals("9\n", printMinimum());
  }

  @Test
  public void deletesOnlyOneCopyOfADuplicate() {
    add(5);
    add(5);
    delete(5);
    assertEquals("5\n", printMinimum());
  }

  @Test
  public void minimumChangesAfterEachInsert() {
    add(10);
    assertEquals("10\n", printMinimum());
    add(3);
    assertEquals("3\n", printMinimum());
    add(-2);
    assertEquals("-2\n", printMinimum());
  }
}
