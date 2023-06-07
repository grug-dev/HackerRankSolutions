package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/swap-nodes-algo/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
public class SwapNodes {

  /*
   * Complete the 'swapNodes' function below.
   *
   * The function is expected to return a 2D_INTEGER_ARRAY.
   * The function accepts following parameters:
   *  1. 2D_INTEGER_ARRAY indexes
   *  2. INTEGER_ARRAY queries
   */

  class Node {
    int key;

    int depth;
    Node left;
    Node right;
    Node parent;
    boolean visited;

    public Node(int pKey) {
      this.key = pKey;
    }

    public Node(int pKey, int depth) {
      this.key = pKey;
      this.depth = depth;
    }

    public Node(int pKey, int depth, Node parent) {
      this.key = pKey;
      this.depth = depth;
      this.parent = parent;
    }
  }

  public List<List<Integer>> swapNodes(List<List<Integer>> indexes, List<Integer> queries) {
    List<List<Integer>> result = new ArrayList<>();

    // Populate tree
    Node root = new Node(1, 1);
    List<List<Node>> levels = new ArrayList<>();
    levels.add(new ArrayList<>());
    levels.get(0).add(root);
    int level = 0;
    int node = 0;

    int lastDepth = 1;
    for (int i = 0; i < indexes.size(); i++) {
      List<Integer> index = indexes.get(i);
      Node newRoot = null;

      if (i == 0) {
        fillUp(root, index);
        continue;
      }
      newRoot = root;
      Node tmp = newRoot;
      if (newRoot.left != null && newRoot.left.depth == lastDepth + 1) {
        newRoot = newRoot.left;
      } else if (newRoot.right != null && newRoot.right.depth == lastDepth + 1) {
        newRoot = newRoot.right;
      } else
        fillUp(newRoot, index);
      Node parent = newRoot.parent;
      if (parent.left != null && parent.visited && parent.right != null && parent.right.visited) {
        lastDepth++;
      }
    }


    //Queries
    for (int k : queries) {
      List<Integer> traverseInOrder = new ArrayList<>();
      swap(root, k);
      traverseInOrder(root, traverseInOrder);
      result.add(traverseInOrder);
    }
    return result;
  }

  private void fillUp(Node node, List<Integer> idxLst) {
    if (node == null) {
      return;
    }

    int childLeft = idxLst.get(0);
    int childRight = idxLst.get(1);
    node.visited = true;
    if (childLeft != -1) {
      node.left = new Node(childLeft, node.depth + 1, node);
    }
    if (childRight != -1) {
      node.right = new Node(childRight, node.depth + 1, node);
    }
  }

  private void traverseInOrder(Node root, List<Integer> traverseInOrder) {
    if (root == null) {
      return;
    }
    traverseInOrder(root.left, traverseInOrder);
    int nodeVal = root.key;
    traverseInOrder.add(nodeVal);
    traverseInOrder(root.right, traverseInOrder);
  }

  public void swap(Node node, int k) {
    if (node == null) {
      return;
    }
    if (k % node.depth == 0) {
      Node tmp = node.left;
      node.left = node.right;
      node.right = tmp;
    }
    swap(node.left, k);
    swap(node.right, k);
  }

}
