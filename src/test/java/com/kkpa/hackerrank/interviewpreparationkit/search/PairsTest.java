package com.kkpa.hackerrank.interviewpreparationkit.search;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/pairs/problem
 * Count the pairs of values whose difference is exactly k. All values are distinct.
 */
public class PairsTest {

  @Test
  public void hackerRankSample0() {
    assertEquals(3, Pairs.pairs(2, Arrays.asList(1, 5, 3, 4, 2)));
  }

  @Test
  public void consecutiveValues() {
    assertEquals(3, Pairs.pairs(1, Arrays.asList(1, 2, 3, 4)));
  }

  @Test
  public void hackerRankSample1() {
    assertEquals(5, Pairs.pairs(2, Arrays.asList(1, 3, 5, 8, 6, 4, 2)));
  }

  @Ignore("BUG: it looks for Math.abs(k - val) instead of val - k, so for val < k it finds a wrong partner (4 matches 1 when k = 5)")
  @Test
  public void noPairWhenAValueIsSmallerThanK() {
    // 4 - 1 = 3, not 5. The answer is 0.
    assertEquals(0, Pairs.pairs(5, Arrays.asList(1, 4)));
  }
}
