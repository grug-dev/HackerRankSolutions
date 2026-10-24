package com.kkpa.hackerrank.datasctructures.linkedlist;

import com.kkpa.TestSupport;
import com.kkpa.hackerrank.datasctructures.linkedlist.PrintElementsOfALinkedList.SinglyLinkedList;
import com.kkpa.hackerrank.datasctructures.linkedlist.PrintElementsOfALinkedList.SinglyLinkedListNode;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
 * Print each value of the list on its own line.
 */
public class PrintElementsOfALinkedListTest {

  private static String print(int... values) {
    SinglyLinkedList list = new SinglyLinkedList();
    for (int value : values) {
      list.insertNode(value);
    }
    return TestSupport.captureOutput(() -> PrintElementsOfALinkedList.printLinkedList(list.head));
  }

  @Test
  public void hackerRankSample() {
    assertEquals("16\n13\n", print(16, 13));
  }

  @Test
  public void singleNode() {
    assertEquals("7\n", print(7));
  }

  @Test
  public void keepsInsertionOrder() {
    assertEquals("1\n2\n3\n4\n", print(1, 2, 3, 4));
  }
}
