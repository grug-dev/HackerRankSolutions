package com.kkpa.hackerrank.interviewpreparationkit.linkedlist;


public class DoublyLinkedListNodeSolution {
  public static class DoublyLinkedListNode {
    public int data;
    public DoublyLinkedListNode next;
    public DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int nodeData) {
      this.data = nodeData;
      this.next = null;
      this.prev = null;
    }
  }


  /**
   * @param llist DoublyLinkedListNode pointer head: a reference to the head of a doubly-linked list
   * @param data  An integer denoting the value of the  field for the DoublyLinkedListNode you must insert into the list
   * @return DoublyLinkedListNode pointer head.
   */
  public DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    DoublyLinkedListNode currentNode = llist;
    DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);

    boolean added = false;
    do {
      if (currentNode.data > data) {
        newNode.prev = currentNode.prev;
        newNode.next = currentNode;
        if (currentNode.prev != null) {
          currentNode.prev.next = newNode;
          currentNode.prev = newNode;
        } else {
          currentNode.prev = newNode;
        }
        added = true;
        break;
      }
      currentNode = currentNode.next;
    } while (currentNode != null);

    if (currentNode == null && !added) {
      currentNode = llist;
      while (currentNode.next != null) {
        currentNode = currentNode.next;
        if (currentNode.next == null) {
          currentNode.next = newNode;
          currentNode.next.prev = currentNode;
          break;
        }
      }
    }

    DoublyLinkedListNode result = currentNode;
    while (result.prev != null) {
      result = result.prev;
    }
    return result;
  }

}
