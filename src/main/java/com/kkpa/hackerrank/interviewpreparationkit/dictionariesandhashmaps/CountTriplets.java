package com.kkpa.hackerrank.interviewpreparationkit.dictionariesandhashmaps;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
public class CountTriplets {

  /**
   * One pass, left to right. Each value can close a triplet, extend a pair, or start a pair.
   * The order of the three steps matters, so a value never pairs with itself.
   */
  public long countTriplets(List<Long> arr, long commonRatio) {
    // value -> how many (a) seen so far need this value as the second element
    Map<Long, Long> waitingForSecond = new HashMap<>();
    // value -> how many (a, a*r) pairs seen so far need this value as the third element
    Map<Long, Long> waitingForThird = new HashMap<>();
    long numTriplets = 0;

    for (long value : arr) {
      numTriplets += waitingForThird.getOrDefault(value, 0L);
      waitingForThird.merge(value * commonRatio, waitingForSecond.getOrDefault(value, 0L), Long::sum);
      waitingForSecond.merge(value * commonRatio, 1L, Long::sum);
    }
    return numTriplets;
  }
}
