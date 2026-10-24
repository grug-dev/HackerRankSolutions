package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/mark-and-toys/problem
 * Return the maximum number of toys Mark can buy with the budget.
 */
public class MarkAndToysTest {

  private static List<Integer> list(Integer... values) {
    return new ArrayList<>(Arrays.asList(values));
  }

  @Test
  public void hackerRankSample() {
    assertEquals(4, MarkAndToys.maximumToys(list(1, 12, 5, 111, 200, 1000, 10), 50));
  }

  @Test
  public void buysTheCheapestFirst() {
    assertEquals(3, MarkAndToys.maximumToys(list(1, 2, 3, 4), 7));
    assertEquals(3, MarkAndToys.maximumToys(list(3, 7, 2, 9, 4), 15));
  }

  @Test
  public void budgetTooSmallForAnyToy() {
    assertEquals(0, MarkAndToys.maximumToys(list(5, 10), 4));
  }

  @Test
  public void budgetBuysEverything() {
    assertEquals(3, MarkAndToys.maximumToys(list(5, 10, 15), 30));
  }
}
