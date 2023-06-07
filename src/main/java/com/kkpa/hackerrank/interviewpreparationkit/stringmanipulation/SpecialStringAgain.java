package com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/special-palindrome-again/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
@Component
public class SpecialStringAgain {
  public int substrCount(int length, String data) {
    int specialStringCount = length;

    for (int groupBy = 2; groupBy < length; groupBy++) {
      for (int i = 0; i + groupBy <= length; i++) {
        String current = data.substring(i, groupBy + i);
        if (isSpecial(current.length(), current)) {
          specialStringCount++;
        }
      }
    }
    if (isSpecial(length, data)) {
      specialStringCount++;
    }
    return specialStringCount;
  }

  /**
   * All of the characters are the same, e.g. aaa.
   * All characters except the middle one are the same, e.g. aadaa.
   *
   * @param word
   * @return
   */
  private boolean isSpecial(int lenght, String word) {
    boolean areSame = areAllTheSame(word);
    boolean exceptMiddle = false;

    if (!areSame) {
      if ((lenght % 2) == 1) {
        int middleIndx = lenght / 2;
        String first = word.substring(0, middleIndx);
        if (areAllTheSame(first)) {
          String second = word.substring(lenght - middleIndx, lenght);
          exceptMiddle = first.equalsIgnoreCase(second);
        }
      }
    }
    return areSame || exceptMiddle;
  }

  private boolean areAllTheSame(String word) {
    Map<Character, Long> map = word.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    return map.size() == 1;
  }
}
