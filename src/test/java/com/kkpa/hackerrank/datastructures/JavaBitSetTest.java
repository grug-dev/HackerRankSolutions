package com.kkpa.hackerrank.datastructures;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-bitset/problem
 * After each operation, return the number of set bits in B1 and B2.
 */
public class JavaBitSetTest {

  @Test
  public void hackerRankSample() {
    assertEquals(Arrays.asList("0 0", "1 0", "1 1", "1 2"),
            JavaBitSet.applyOperations(5, Arrays.asList("AND 1 2", "SET 1 4", "FLIP 2 2", "OR 2 1")));
  }

  @Test
  public void xorAndFlipBack() {
    // B1 = {0, 1}, B2 = {1}. XOR 1 2 -> B1 = {0}. FLIP 2 1 -> B2 = {}.
    assertEquals(Arrays.asList("1 0", "2 0", "2 1", "1 1", "1 0"),
            JavaBitSet.applyOperations(3, Arrays.asList("SET 1 0", "SET 1 1", "SET 2 1", "XOR 1 2", "FLIP 2 1")));
  }

  @Test
  public void andIntoSecondSet() {
    // B1 = {0}, B2 = {0, 2}. AND 2 1 -> B2 = {0}.
    assertEquals(Arrays.asList("1 0", "1 1", "1 2", "1 1"),
            JavaBitSet.applyOperations(3, Arrays.asList("SET 1 0", "SET 2 0", "SET 2 2", "AND 2 1")));
  }
}
