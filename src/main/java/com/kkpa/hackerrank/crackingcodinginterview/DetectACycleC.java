package com.kkpa.hackerrank.crackingcodinginterview;

import java.util.LinkedHashMap;
import java.util.Map;

public class DetectACycleC {

    static class Node {
	int data;
	Node next;

	Node(int data) {
	    this.data = data;
	}

	void assignNext(Node next) {
	    this.next = next;
	}
    }

    private static Map<Integer, Integer> nodeMap = new LinkedHashMap<Integer, Integer>();

    private static int cont = 0;

    static boolean hasCycle(Node head) {
	if (head == null) {
	    return false;
	}
	Node slow = head;
	Node fast = head.next;
	while (slow != fast) {
	    System.out.println(cont++);
	    if (fast == null || fast.next == null) {
		return false;
	    }
	    slow = slow.next;
	    fast = fast.next.next;
	}
	return true;
    }

}
