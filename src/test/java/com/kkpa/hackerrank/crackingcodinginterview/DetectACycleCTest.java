package com.kkpa.hackerrank.crackingcodinginterview;

import com.kkpa.hackerrank.crackingcodinginterview.DetectACycleC.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem
 * hasCycle prints a debug counter; the tests ignore that output.
 */
public class DetectACycleCTest {

  /**
   * Builds a list with the given values. If cycleTo >= 0, the last node points back to the node at that index.
   */
  private static Node list(int cycleTo, int... values) {
    Node[] nodes = new Node[values.length];
    for (int i = 0; i < values.length; i++) {
      nodes[i] = new Node(values[i]);
      if (i > 0) {
        nodes[i - 1].assignNext(nodes[i]);
      }
    }
    if (cycleTo >= 0) {
      nodes[values.length - 1].assignNext(nodes[cycleTo]);
    }
    return nodes[0];
  }

  @Test
  public void emptyListHasNoCycle() {
    assertFalse(DetectACycleC.hasCycle(null));
  }

  @Test
  public void singleNodeWithoutCycle() {
    assertFalse(DetectACycleC.hasCycle(list(-1, 1)));
  }

  @Test
  public void singleNodePointingToItself() {
    assertTrue(DetectACycleC.hasCycle(list(0, 1)));
  }

  @Test
  public void listWithoutCycle() {
    assertFalse(DetectACycleC.hasCycle(list(-1, 1, 2, 3, 4, 5)));
    assertFalse(DetectACycleC.hasCycle(list(-1, 1, 2, 3, 4)));
  }

  @Test
  public void lastNodePointsBackToTheHead() {
    assertTrue(DetectACycleC.hasCycle(list(0, 1, 2, 3)));
  }

  @Test
  public void cycleInTheMiddle() {
    assertTrue(DetectACycleC.hasCycle(list(2, 1, 2, 3, 4, 5, 6)));
  }
}
