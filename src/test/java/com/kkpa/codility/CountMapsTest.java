package com.kkpa.codility;

import com.kkpa.codility.CountMaps.UserStats;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Sums the visit counts per user id over many maps (one map per microservice).
 * Invalid entries must be ignored: empty or missing counts, null stats, empty ids.
 */
public class CountMapsTest {

  private static UserStats visits(long count) {
    return new UserStats(Optional.of(count));
  }

  @Test
  public void nullInputReturnsEmptyMap() {
    assertTrue(CountMaps.count((Map<String, UserStats>[]) null).isEmpty());
  }

  @Test
  public void noMapsReturnsEmptyMap() {
    assertTrue(CountMaps.count().isEmpty());
  }

  @Test
  public void sumsVisitsOfTheSameUserAcrossMaps() {
    Map<String, UserStats> first = new HashMap<>();
    first.put("1", visits(3));
    first.put("2", visits(5));
    first.put("4", new UserStats(Optional.empty()));
    Map<String, UserStats> second = new HashMap<>();
    second.put("1", visits(2));
    second.put("2", visits(4));
    second.put("3", visits(1));

    Map<Long, Long> expected = new HashMap<>();
    expected.put(1L, 5L);
    expected.put(2L, 9L);
    expected.put(3L, 1L);
    assertEquals(expected, CountMaps.count(first, second));
  }

  @Test
  public void ignoresEmptyIdsNullStatsAndCountsNotAboveZero() {
    Map<String, UserStats> map = new HashMap<>();
    map.put("", visits(7));
    map.put("1", null);
    map.put("2", new UserStats(Optional.empty()));
    map.put("3", visits(0));
    map.put("4", visits(-2));
    map.put("5", visits(6));

    Map<Long, Long> expected = new HashMap<>();
    expected.put(5L, 6L);
    assertEquals(expected, CountMaps.count(map));
  }

  @Ignore("BUG: an id that is not a number throws NumberFormatException instead of being ignored")
  @Test
  public void ignoresIdsThatAreNotNumbers() {
    Map<String, UserStats> map = new HashMap<>();
    map.put("user3", visits(4));
    map.put("1", visits(2));

    Map<Long, Long> expected = new HashMap<>();
    expected.put(1L, 2L);
    assertEquals(expected, CountMaps.count(map));
  }

  @Ignore("BUG: a null map inside the varargs throws NullPointerException instead of being ignored")
  @Test
  public void ignoresNullMaps() {
    Map<String, UserStats> map = new HashMap<>();
    map.put("1", visits(2));

    Map<Long, Long> expected = new HashMap<>();
    expected.put(1L, 2L);
    assertEquals(expected, CountMaps.count(map, null));
  }
}
