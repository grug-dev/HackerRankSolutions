package com.kkpa.hackerrank;

import com.kkpa.hackerrank.VisitorPattern.Color;
import com.kkpa.hackerrank.VisitorPattern.TreeLeaf;
import com.kkpa.hackerrank.VisitorPattern.TreeNode;
import com.kkpa.hackerrank.VisitorPattern.TreeVis;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-vistor-pattern/problem
 * VisitorPattern has no solve() method, so the tests build the trees by hand.
 * The tree classes are inner (non-static) classes, so they need an outer instance.
 */
public class VisitorPatternTest {

  private final VisitorPattern outer = new VisitorPattern();

  /*
   * HackerRank sample:
   *          1 (4, RED, depth 0)
   *        /    \
   *   2 (7, GREEN)  3 (2, RED, depth 1)
   *                /    \
   *          4 (5, RED)  5 (12, GREEN)
   */
  private TreeNode sampleTree() {
    TreeNode root = outer.new TreeNode(4, Color.RED, 0);
    TreeNode node3 = outer.new TreeNode(2, Color.RED, 1);
    root.addChild(outer.new TreeLeaf(7, Color.GREEN, 1));
    root.addChild(node3);
    node3.addChild(outer.new TreeLeaf(5, Color.RED, 2));
    node3.addChild(outer.new TreeLeaf(12, Color.GREEN, 2));
    return root;
  }

  private static int visit(TreeNode root, TreeVis visitor) {
    root.accept(visitor);
    return visitor.getResult();
  }

  @Test
  public void sumInLeavesOnSample() {
    assertEquals(24, visit(sampleTree(), outer.new SumInLeavesVisitor()));
  }

  @Test
  public void productOfRedNodesOnSample() {
    assertEquals(40, visit(sampleTree(), outer.new ProductOfRedNodesVisitor()));
  }

  @Test
  public void fancyVisitorOnSample() {
    // |non-leaf nodes at even depth (4)  -  green leaves (7 + 12)| = 15
    assertEquals(15, visit(sampleTree(), outer.new FancyVisitor()));
  }

  @Test
  public void productOfRedNodesIsTakenModulo() {
    TreeNode root = outer.new TreeNode(1000, Color.RED, 0);
    TreeNode current = root;
    for (int depth = 1; depth <= 3; depth++) {
      TreeNode child = outer.new TreeNode(1000, Color.RED, depth);
      current.addChild(child);
      current = child;
    }
    current.addChild(outer.new TreeLeaf(1000, Color.RED, 4));
    // 1000^5 = 10^15, and 10^15 mod (10^9 + 7) = 993000007
    assertEquals(993000007, visit(root, outer.new ProductOfRedNodesVisitor()));
  }

  @Test
  public void productWithoutRedNodesIsOne() {
    TreeNode root = outer.new TreeNode(3, Color.GREEN, 0);
    root.addChild(outer.new TreeLeaf(5, Color.GREEN, 1));
    assertEquals(1, visit(root, outer.new ProductOfRedNodesVisitor()));
  }

  @Test
  public void fancyVisitorIgnoresNodesAtOddDepthAndRedLeaves() {
    TreeNode root = outer.new TreeNode(10, Color.GREEN, 0);
    TreeNode odd = outer.new TreeNode(100, Color.GREEN, 1);
    root.addChild(odd);
    odd.addChild(outer.new TreeLeaf(3, Color.RED, 2));
    odd.addChild(outer.new TreeLeaf(4, Color.GREEN, 2));
    // |10 - 4| = 6
    assertEquals(6, visit(root, outer.new FancyVisitor()));
  }
}
