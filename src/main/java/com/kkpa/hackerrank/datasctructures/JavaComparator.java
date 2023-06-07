package com.kkpa.hackerrank.datasctructures;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

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

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    Player[] player = new Player[n];
    Checker checker = new Checker();

    for (int i = 0; i < n; i++) {
      player[i] = new Player(scan.next(), scan.nextInt());
    }
    scan.close();

    Arrays.sort(player, checker);
    for (int i = 0; i < player.length; i++) {
      System.out.printf("%s %s\n", player[i].name, player[i].score);
    }
  }
}
