package com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=strings
 */

/**
 * Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
 */
public class SherlockValidString {
  /*
   * Complete the 'isValid' function below.
   *
   * The function is expected to return a STRING.
   * The function accepts STRING s as parameter.
   */

  public static String isValid(String s) {
    String result = "YES";

    if (s == null || s.length() == 0 | s.length() == 1) {
      return result;
    }

    Map<String, Long> chainCounts = Arrays.stream(s.split("")).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
    List<Long> countsStream = chainCounts.values().stream().collect(Collectors.toList());
    Long pivot = countsStream.stream().findFirst().get();
    List<Long> invalidLst = countsStream.stream().map(v -> v.longValue() - pivot.longValue()).filter(v -> v.longValue() != 0L).collect(Collectors.toList());
    if (invalidLst.isEmpty()) {
      return result;
    }
    if (invalidLst.size() > 1) {
      result = "NO";
    }

    if (invalidLst.get(0).longValue() > 1) {
      result = "NO";
    }

    return result;
  }

  public static void main(String[] args) {
    String test = "abcc";
    System.out.println(test + " YES -->" + isValid(test));

    test = "abccc";
    System.out.println(test + " NO -->" + isValid(test));

    test = "aabbcd";
    System.out.println("aabbcd  NO -->" + isValid(test));

    test = "aabbccddeefghi";
    System.out.println(test + " NO --> " + isValid(test));


    test = "abcdefghhgfedecba";
    System.out.println(test + " YES -->" + isValid(test));

  }

}
