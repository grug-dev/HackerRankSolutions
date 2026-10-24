package com.kkpa.hackerrank.datastructures;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * https://www.hackerrank.com/challenges/java-comparator/problem
 * Sort players by score (high first). With the same score, sort by name (a to z).
 * Checker and Player are package-private classes in JavaComparator.java.
 */
public class JavaComparatorTest {

  private final Checker checker = new Checker();

  @Test
  public void sortsTheHackerRankSample() {
    Player[] players = {
            new Player("amy", 100), new Player("david", 100), new Player("heraldo", 50),
            new Player("aakansha", 75), new Player("aleksa", 150)};
    Arrays.sort(players, checker);
    List<String> sorted = new ArrayList<>();
    for (Player player : players) {
      sorted.add(player.name + " " + player.score);
    }
    assertEquals(Arrays.asList("aleksa 150", "amy 100", "david 100", "aakansha 75", "heraldo 50"), sorted);
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
    assertEquals(0, checker.compare(new Player("amy", 50), new Player("amy", 50)));
  }
}
