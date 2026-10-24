package com.kkpa.hackerrank.datasctructures.arrayList;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 */
public class JavaArrayList {

  private static final String ERROR = "ERROR!";

  /**
   * Returns the y-th number of line x, or "ERROR!" if it does not exist.
   * Both x and y start at 1.
   */
  public static String findValue(List<List<Integer>> lines, int x, int y) {
    if (x < 1 || x > lines.size()) {
      return ERROR;
    }
    List<Integer> line = lines.get(x - 1);
    if (y < 1 || y > line.size()) {
      return ERROR;
    }
    return String.valueOf(line.get(y - 1));
  }
}
