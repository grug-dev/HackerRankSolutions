package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import com.kkpa.TestSupport;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/ctci-bubble-sort/problem
 * Sort with bubble sort, then print the swap count, the first element and the last element.
 */
public class BubbleSortTest {

  private static String countSwaps(Integer... values) {
    return TestSupport.captureOutput(() -> BubbleSort.countSwaps(new ArrayList<>(Arrays.asList(values))));
  }

  private static String expected(int swaps, int first, int last) {
    return "Array is sorted in " + swaps + " swaps\nFirst Element: " + first + "\nLast Element: " + last + "\n";
  }

  @Test
  public void alreadySorted() {
    assertEquals(expected(0, 1, 3), countSwaps(1, 2, 3));
  }

  @Test
  public void reverseOrder() {
    assertEquals(expected(3, 1, 3), countSwaps(3, 2, 1));
  }

  @Test
  public void hackerRankSample() {
    assertEquals(expected(3, 1, 6), countSwaps(6, 4, 1));
  }

  @Test
  public void swapsEqualTheNumberOfInversions() {
    // inversions of 4 1 3 2: (4,1) (4,3) (4,2) (3,2) = 4
    assertEquals(expected(4, 1, 4), countSwaps(4, 1, 3, 2));
  }
}
