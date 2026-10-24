package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarkAndToys {

  /**
   * Returns the maximum number of toys that fit in the budget.
   * Buying the cheapest toys first always gives the most toys, so one pass after the sort is enough.
   * The prices list is not changed.
   */
  public static int maximumToys(List<Integer> prices, int budget) {
    List<Integer> sorted = new ArrayList<>(prices);
    Collections.sort(sorted);

    int toys = 0;
    long total = 0;
    for (int price : sorted) {
      total += price;
      if (total > budget) {
        break;
      }
      toys++;
    }
    return toys;
  }

}
