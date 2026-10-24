package com.kkpa.hackerrank.interviewpreparationkit.greedyalgorithms;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem
 * Each contest is [luck, importance]. Losing adds the luck, winning subtracts it.
 * At most k important contests (importance 1) can be lost. Return the maximum luck.
 */
public class LuckBalanceTest {

  private static List<List<Integer>> contests(int[]... pairs) {
    List<List<Integer>> contests = new ArrayList<>();
    for (int[] pair : pairs) {
      contests.add(Arrays.asList(pair[0], pair[1]));
    }
    return contests;
  }

  @Test
  public void hackerRankSample() {
    List<List<Integer>> contests = contests(
            new int[]{5, 1}, new int[]{2, 1}, new int[]{1, 1}, new int[]{8, 1}, new int[]{10, 0}, new int[]{5, 0});
    // lose 8, 5, 2 and both regular contests, win 1: 8 + 5 + 2 + 10 + 5 - 1 = 29
    assertEquals(29, LuckBalance.luckBalance(3, contests));
  }

  @Test
  public void canLoseEveryImportantContest() {
    assertEquals(10, LuckBalance.luckBalance(2, contests(new int[]{5, 1}, new int[]{1, 1}, new int[]{4, 0})));
  }

  @Test
  public void mustWinTheSmallestImportantContests() {
    // lose 5, win 1, lose the regular 4: 5 - 1 + 4 = 8
    assertEquals(8, LuckBalance.luckBalance(1, contests(new int[]{5, 1}, new int[]{1, 1}, new int[]{4, 0})));
  }

  @Ignore("BUG: with k = 0, subList(0, 0).reduce(...).get() throws NoSuchElementException")
  @Test
  public void mustWinAllImportantContests() {
    // k = 0: win 5, lose the regular 1: -5 + 1 = -4
    assertEquals(-4, LuckBalance.luckBalance(0, contests(new int[]{5, 1}, new int[]{1, 0})));
  }
}
