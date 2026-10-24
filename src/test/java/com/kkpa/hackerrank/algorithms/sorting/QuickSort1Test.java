package com.kkpa.hackerrank.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/quicksort1/problem
 */
public class QuickSort1Test {

  @Test
  public void partitionsTheSampleAroundTheFirstElement() {
    assertEquals(Arrays.asList(3, 2, 4, 5, 7), QuickSort1.quickSort(Arrays.asList(4, 5, 3, 7, 2)));
  }

  @Test
  public void keepsValuesEqualToThePivotInTheMiddle() {
    assertEquals(Arrays.asList(1, 5, 5, 5, 9), QuickSort1.quickSort(Arrays.asList(5, 5, 1, 9, 5)));
  }

  @Test
  public void returnsASingleElementAsIs() {
    assertEquals(Collections.singletonList(42), QuickSort1.quickSort(Collections.singletonList(42)));
  }
}
