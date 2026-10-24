package com.kkpa.hackerrank.datasctructures;

import java.util.Comparator;

/**
 * https://www.hackerrank.com/challenges/java-comparator/problem?isFullScreen=true
 */
class Checker implements Comparator<Player> {

  @Override public int compare(Player o1, Player o2) {
    int scoreComparison = Integer.compare(o1.score, o2.score);
    if (scoreComparison != 0) {
      return scoreComparison * -1; // Default sorting is asc
    } else {
      return o1.name.compareToIgnoreCase(o2.name);
    }
  }
}

class Player {
  String name;
  int score;

  Player(String name, int score) {
    this.name = name;
    this.score = score;
  }
}

class JavaComparator {

}
