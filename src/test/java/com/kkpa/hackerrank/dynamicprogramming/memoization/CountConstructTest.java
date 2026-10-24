package com.kkpa.hackerrank.dynamicprogramming.memoization;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Count the ways to build the target by joining words from the word bank.
 */
public class CountConstructTest {

  private static int countConstruct(String target, String... wordBank) {
    return CountConstruct.countConstruct(target, wordBank, new HashMap<>());
  }

  @Test
  public void severalWays() {
    assertEquals(2, countConstruct("purple", "purp", "p", "ur", "le", "purpl"));
    assertEquals(4, countConstruct("enterapotentpot", "a", "p", "ent", "enter", "ot", "o", "t"));
  }

  @Test
  public void oneWay() {
    assertEquals(1, countConstruct("abcdef", "ab", "abc", "cd", "def", "abcd"));
  }

  @Test
  public void noWay() {
    assertEquals(0, countConstruct("skateboard", "bo", "rd", "ate", "t", "ska", "sk", "boar"));
  }

  @Test
  public void emptyTargetHasOneWay() {
    assertEquals(1, countConstruct("", "a"));
  }

  @Test(timeout = 2000)
  public void longImpossibleTargetNeedsMemoization() {
    assertEquals(0, countConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", "e", "ee", "eee", "eeee", "eeeee", "eeeeee"));
  }
}
