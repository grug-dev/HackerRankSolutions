package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import com.kkpa.hackerrank.interviewpreparationkit.sorting.SortingComparator.Checker;
import com.kkpa.hackerrank.interviewpreparationkit.sorting.SortingComparator.Player;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem
 * Sort players by score (high first). With the same score, sort by name (a to z).
 */
public class SortingComparatorTest {

  private final Checker checker = new Checker();

  @Test
  public void hackerRankSample() {
    List<Player> players = new ArrayList<>();
    players.add(new Player("amy", 100));
    players.add(new Player("david", 100));
    players.add(new Player("heraldo", 50));
    players.add(new Player("aakansha", 75));
    players.add(new Player("aleksa", 150));

    players.sort(checker);

    List<String> result = new ArrayList<>();
    for (Player player : players) {
      result.add(player.name + " " + player.score);
    }
    List<String> expected = new ArrayList<>();
    expected.add("aleksa 150");
    expected.add("amy 100");
    expected.add("david 100");
    expected.add("aakansha 75");
    expected.add("heraldo 50");
    assertEquals(expected, result);
  }

  @Test
  public void higherScoreComesFirst() {
    assertTrue(checker.compare(new Player("zed", 90), new Player("amy", 10)) < 0);
    assertTrue(checker.compare(new Player("amy", 10), new Player("zed", 90)) > 0);
  }

  @Test
  public void sameScoreSortsByName() {
    assertTrue(checker.compare(new Player("amy", 50), new Player("bob", 50)) < 0);
    assertTrue(checker.compare(new Player("bob", 50), new Player("amy", 50)) > 0);
  }

  @Test
  public void samePlayerIsEqual() {
    assertEquals(0, checker.compare(new Player("amy", 50), new Player("amy", 50)));
  }
}
