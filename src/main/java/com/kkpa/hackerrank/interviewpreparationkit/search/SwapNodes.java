package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
public class SwapNodes {

  private static class Node {
    final int key;
    Node left;
    Node right;

    Node(int key) {
      this.key = key;
    }
  }

  public List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    Node root = buildTree(indexes);

    List<List<Integer>> result = new ArrayList<>();
    for (int k : queries) {
      swap(root, 1, k);
      List<Integer> inOrder = new ArrayList<>();
      traverseInOrder(root, inOrder);
      result.add(inOrder);
    }
    return result;
  }

  /**
   * indexes[i] holds the left and right child keys of node i + 1. -1 means no child.
   */
  private Node buildTree(List<List<Integer>> indexes) {
    Node[] nodes = new Node[indexes.size() + 1];
    for (int key = 1; key <= indexes.size(); key++) {
      nodes[key] = new Node(key);
    }
    for (int i = 0; i < indexes.size(); i++) {
      int childLeft = indexes.get(i).get(0);
      int childRight = indexes.get(i).get(1);
      nodes[i + 1].left = childLeft == -1 ? null : nodes[childLeft];
      nodes[i + 1].right = childRight == -1 ? null : nodes[childRight];
    }
    return nodes[1];
  }

  /**
   * Swaps the children of every node whose depth is a multiple of k. The root has depth 1.
   */
  private void swap(Node node, int depth, int k) {
    if (node == null) {
      return;
    }
    if (depth % k == 0) {
      Node tmp = node.left;
      node.left = node.right;
      node.right = tmp;
    }
    swap(node.left, depth + 1, k);
    swap(node.right, depth + 1, k);
  }

  private void traverseInOrder(Node node, List<Integer> inOrder) {
    if (node == null) {
      return;
    }
    traverseInOrder(node.left, inOrder);
    inOrder.add(node.key);
    traverseInOrder(node.right, inOrder);
  }

}
