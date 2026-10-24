package com.kkpa.hackerrank.crackingcodinginterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
 */
@RunWith(Parameterized.class)
public class MakingAnagramsTest {

  @Parameterized.Parameter(0)
  public String a;

  @Parameterized.Parameter(1)
  public String b;

  @Parameterized.Parameter(2)
  public int expectedResult;

  @Parameterized.Parameters(name = "{index}: \"{0}\", \"{1}\" -> {2}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    // HackerRank samples
                    {"cde", "abc", 4},
                    {"fcrxzwscanmligyxyvym", "jxwtrhvujlmrpdoqbisbwhmgpmeoke", 30},
                    {"showman", "woman", 2},

                    // already anagrams
                    {"abc", "abc", 0},
                    {"listen", "silent", 0},
                    {"abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba", 0},

                    // no common letters
                    {"a", "b", 2},
                    {"abc", "xyz", 6},

                    // same letters, different counts
                    {"aaa", "a", 2},
                    {"a", "aa", 1},
                    {"aa", "aaaa", 2},
                    {"aabbcc", "abc", 3},

                    // maximum length (10^4)
                    {repeat("a", 10000), repeat("b", 10000), 20000},
                    {repeat("ab", 5000), repeat("ba", 5000), 0},
            }
    );
  }

  private static String repeat(String text, int times) {
    return String.join("", Collections.nCopies(times, text));
  }

  @Test
  public void countsDeletionsToMakeAnagrams() {
    assertEquals("INPUT " + a + ", " + b, expectedResult, MakingAnagrams.makeAnagram(a, b));
  }
}
