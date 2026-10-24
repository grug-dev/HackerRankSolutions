package com.kkpa.hackerrank.datasctructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-dequeue/problem
 * Return the maximum number of unique values in any window of m consecutive values.
 */
public class JavaDequeueTest {

  @Test
  public void hackerRankSample() {
    assertEquals(3, JavaDequeue.maxUnique(new int[]{5, 3, 5, 2, 3, 2}, 3));
  }

  @Test
  public void allValuesEqual() {
    assertEquals(1, JavaDequeue.maxUnique(new int[]{1, 1, 1, 1}, 2));
  }

  @Test
  public void allValuesUnique() {
    assertEquals(4, JavaDequeue.maxUnique(new int[]{1, 2, 3, 4, 5, 6}, 4));
  }

  @Test
  public void windowIsTheWholeArray() {
    assertEquals(2, JavaDequeue.maxUnique(new int[]{7, 7, 8}, 3));
  }
}
