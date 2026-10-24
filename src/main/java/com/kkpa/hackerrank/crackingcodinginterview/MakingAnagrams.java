package com.kkpa.hackerrank.crackingcodinginterview;


/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 * <p>
 * Find the minimum number of character deletions needed to make two strings anagrams.
 * Constraints: 1 <= |a|, |b| <= 10^4, and both strings contain only lowercase letters a-z.
 */
public class MakingAnagrams {

  private static final int ALPHABET_SIZE = 26;

  /**
   * @param a first string, lowercase letters only
   * @param b second string, lowercase letters only
   * @return how many characters must be deleted from a and b so both have the same letter counts
   */
  public static int makeAnagram(String a, String b) {
    // count[i] > 0: letter i appears more in a. count[i] < 0: it appears more in b.
    int[] count = new int[ALPHABET_SIZE];
    for (char c : a.toCharArray()) {
      count[c - 'a']++;
    }
    for (char c : b.toCharArray()) {
      count[c - 'a']--;
    }

    int deletions = 0;
    for (int difference : count) {
      deletions += Math.abs(difference);
    }
    return deletions;
  }
}
