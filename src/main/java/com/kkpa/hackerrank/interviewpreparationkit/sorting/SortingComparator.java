package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import java.util.Comparator;

public class SortingComparator {

  static class Player {
    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }
  }

  static class Checker implements Comparator<Player> {
    // complete this method
    public int compare(Player a, Player b) {
      int result = Integer.compare(a.score, b.score) * -1;
      if (result == 0) {
        result = (a.name.compareTo(b.name));
      }
      return result;
    }
  }

}
