package com.kkpa.hackerrank.interviewpreparationkit.search;

import com.kkpa.TestSupport;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem
 * Print the 1-based indexes of the two flavors that cost exactly the money, smaller index first.
 */
public class IceCreamParlorTest {

  private static String whatFlavors(int money, Integer... cost) {
    return TestSupport.captureOutput(() -> IceCreamParlor.whatFlavors(Arrays.asList(cost), money));
  }

  @Test
  public void hackerRankSample0() {
    assertEquals("1 4\n", whatFlavors(4, 1, 4, 5, 3, 2));
  }

  @Test
  public void hackerRankSample1() {
    assertEquals("1 2\n", whatFlavors(4, 2, 2, 4, 3));
  }

  @Test
  public void pairInTheMiddle() {
    assertEquals("2 4\n", whatFlavors(8, 4, 3, 2, 5, 7));
  }

  @Test
  public void pairAtTheEnds() {
    assertEquals("1 5\n", whatFlavors(10, 1, 20, 30, 40, 9));
  }
}
