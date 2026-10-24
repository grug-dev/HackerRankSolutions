package com.kkpa.hackerrank.datastructures.arraylist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/java-list/problem
 */
public class JavaList {

  private static Logger log = LoggerFactory.getLogger(JavaList.class);

  /**
   * Applies each query to a copy of the numbers and returns the result.
   * A query is "Insert index value" or "Delete index".
   */
  public static List<Integer> applyQueries(List<Integer> numbers, List<String> queries) {
    LinkedList<Integer> result = new LinkedList<>(numbers);
    for (String query : queries) {
      String[] parts = query.split(" ");
      int index = Integer.parseInt(parts[1]);
      if (parts[0].equalsIgnoreCase("Insert")) {
        result.add(index, Integer.parseInt(parts[2]));
      } else {
        result.remove(index);
      }
    }
    return result;
  }
}
