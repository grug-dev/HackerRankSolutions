package com.kkpa.hackerrank.datastructures.arrays;

/**
 * https://www.hackerrank.com/challenges/java-1d-array/problem
 */
public class Java1dArray {

  /**
   * Depth-first search from index 0. Moves are i - 1, i + 1 and i + leap, only onto cells with 0.
   * Any move past the last cell wins. Each cell is visited once, so a loop cannot happen.
   */
  public boolean canWin(int leap, int[] game) {
    return canWin(leap, game, 0, new boolean[game.length]);
  }

  private boolean canWin(int leap, int[] game, int i, boolean[] visited) {
    if (i >= game.length) {
      return true;
    }
    if (i < 0 || game[i] == 1 || visited[i]) {
      return false;
    }
    visited[i] = true;
    return canWin(leap, game, i + leap, visited)
            || canWin(leap, game, i + 1, visited)
            || canWin(leap, game, i - 1, visited);
  }

}
