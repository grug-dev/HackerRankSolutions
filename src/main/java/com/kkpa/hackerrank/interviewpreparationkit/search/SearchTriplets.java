package com.kkpa.hackerrank.interviewpreparationkit.search;

import java.util.*;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
 */
public class SearchTriplets {

  /*
   * Complete the 'triplets' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY a
   *  2. INTEGER_ARRAY b
   *  3. INTEGER_ARRAY c
   */

  public long triplets(List<Integer> al, List<Integer> bl, List<Integer> cl) {
    Set<Integer> a = new HashSet<>(al);
    Set<Integer> b = new HashSet<>(bl);
    Set<Integer> c = new HashSet<>(cl);
    int sizeA = a.size();
    int sizeB = b.size();
    long totalTriplets = 0;


    for (int valA : a) {
      for (int valB : b) {
        if (valA > valB) {
          continue;
        }
        totalTriplets += c.parallelStream().filter(valC -> valB - valC >= 0).count();
      }
    }
    return totalTriplets;
  }
}
