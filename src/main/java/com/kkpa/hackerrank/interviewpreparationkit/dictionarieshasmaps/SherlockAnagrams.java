package com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 * <p>
 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string.
 * <p>
 * Given a string, find the number of pairs of substrings of the string that are anagrams of each other.
 */
@Component
public class SherlockAnagrams {

  /*
   * Complete the 'sherlockAndAnagrams' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts STRING s as parameter.
   */

  public int sherlockAndAnagrams(String s) {
    // Write your code here
    AtomicInteger count = new AtomicInteger();

    IntStream.rangeClosed(1, s.length() - 1).forEach(groupOf -> {
      for (int i = 0; groupOf + i <= s.length(); i++) {
        String current = s.substring(i, groupOf + i);
        for (int j = i + 1; j + groupOf <= s.length(); j++) {
          String next = s.substring(j, groupOf + j);
          if (isAnagram(current, next)) count.incrementAndGet();
        }
      }
    });
    return count.get();
  }

  private boolean isAnagram(String firstWord, String secondWord) {
    Map<Character, Integer> firstCharFrecuency = new HashMap<>();
    Map<Character, Integer> secondCharFrecuency = new HashMap<>();
    firstWord = firstWord.trim().toLowerCase();
    secondWord = secondWord.trim().toLowerCase();
    firstWord.chars().forEach(c -> firstCharFrecuency.merge((char) c, 1, Integer::sum));
    secondWord.chars().forEach(c -> secondCharFrecuency.merge((char) c, 1, Integer::sum));
    return firstCharFrecuency.equals(secondCharFrecuency);
  }
}
