package com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/frequency-queries/problem
 * Query [1, x] adds x, [2, x] removes one x if present, [3, f] returns 1 if any value appears exactly f times.
 */
public class FrequencyQueriesTest {

  private static List<List<Integer>> queries(int[]... pairs) {
    List<List<Integer>> queries = new ArrayList<>();
    for (int[] pair : pairs) {
      queries.add(Arrays.asList(pair[0], pair[1]));
    }
    return queries;
  }

  @Test
  public void hackerRankSample0() {
    List<List<Integer>> queries = queries(
            new int[]{1, 5}, new int[]{1, 6}, new int[]{3, 2}, new int[]{1, 10},
            new int[]{1, 10}, new int[]{1, 6}, new int[]{2, 5}, new int[]{3, 2});
    assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(queries));
  }

  @Test
  public void hackerRankSample1() {
    List<List<Integer>> queries = queries(new int[]{3, 4}, new int[]{2, 1003}, new int[]{1, 16}, new int[]{3, 1});
    assertEquals(Arrays.asList(0, 1), FrequencyQueries.freqQuery(queries));
  }

  @Test
  public void hackerRankSample2() {
    List<List<Integer>> queries = queries(
            new int[]{1, 3}, new int[]{2, 3}, new int[]{3, 2}, new int[]{1, 4}, new int[]{1, 5},
            new int[]{1, 5}, new int[]{1, 4}, new int[]{3, 2}, new int[]{2, 4}, new int[]{3, 2});
    assertEquals(Arrays.asList(0, 1, 1), FrequencyQueries.freqQuery(queries));
  }

  @Ignore("BUG: query [2, x] for a value that is not present inserts x with frequency 1 (merge puts the default value)")
  @Test
  public void removingAValueThatIsNotPresentChangesNothing() {
    List<List<Integer>> queries = queries(new int[]{2, 5}, new int[]{3, 1});
    assertEquals(Arrays.asList(0), FrequencyQueries.freqQuery(queries));
  }
}
