package com.kkpa.hackerrank.interviewpreparationkit.sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingComparator {

  public static void main(String[] args) {
    List<Player> allPlayers = new ArrayList<>();
    allPlayers.add(new Player("amy", 100));
    allPlayers.add(new Player("david", 100));
    allPlayers.add(new Player("heraldo", 50));
    allPlayers.add(new Player("aakansha", 75));
    allPlayers.add(new Player("aleksa", 150));

    Checker checker = new Checker();
    allPlayers.sort(checker);

    allPlayers.forEach(player -> System.out.println(player.name + " " + player.score));
  }

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
