package com.kkpa.hackerrank.java.strings;

/**
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 *
 * <p>A palindrome is a word that reads the same backward and forward. The check is exact:
 * case-sensitive, and every character counts.
 */
public class Palindrome {

  /**
   * Returns true when {@code s} reads the same backward and forward. An empty string and a single
   * character are palindromes.
   */
  public static boolean isPalindrome(String word) {

    int fwdIdx = 0;
    int backIdx = word.length() - 1;

    while (fwdIdx < backIdx) {
      char fwdCh = word.charAt(fwdIdx);
      char backCh = word.charAt(backIdx);

      if (fwdCh != backCh) return false;

      fwdIdx++;
      backIdx--;
    }

    return true;
  }
}
