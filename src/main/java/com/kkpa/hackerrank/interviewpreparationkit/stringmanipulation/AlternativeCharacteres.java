package com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation;

import org.springframework.stereotype.Component;

/**
 * https://www.hackerrank.com/challenges/alternating-characters/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
@Component
public class AlternativeCharacteres {

  /*
   * Complete the 'alternatingCharacters' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public int alternatingCharacters(String s) {
    // Write your code here
    int removed = 0;
    Character lastOne = null;
    for (Character c : s.toCharArray()) {
      if (lastOne != c) {
        lastOne = c;
      } else {
        removed++;
      }
    }
    return removed;
  }

}
