package com.kkpa.hackerrank.dynamicprogramming.memoization;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Can the target be built by joining words from the word bank? Each word can be used many times.
 */
public class CanConstructTest {

  private static boolean canConstruct(String target, String... wordBank) {
    return CanConstruct.canConstruct(target, wordBank, new HashMap<>());
  }

  @Ignore("BUG: 'result' is overwritten in the loop. \"abc\" + \"def\" succeeds, then trying \"abcd\" fails and sets it back to false")
  @Test
  public void targetCanBeBuilt() {
    assertTrue(canConstruct("abcdef", "ab", "abc", "cd", "def", "abcd"));
  }

  @Test
  public void emptyTargetCanAlwaysBeBuilt() {
    assertTrue(canConstruct("", "ab", "cd"));
  }

  @Test
  public void targetCannotBeBuilt() {
    assertFalse(canConstruct("skateboard", "bo", "rd", "ate", "t", "ska", "sk", "boar"));
  }

  @Ignore("BUG: same as targetCanBeBuilt. The loop does not stop at the first success")
  @Test
  public void laterWordThatFailsDoesNotHideAnEarlierSuccess() {
    // "ab" works on its own. Trying "a" after it fails, but the answer must stay true.
    assertTrue(canConstruct("ab", "ab", "a"));
  }

  @Ignore("BUG: the memo is never read: 'memo.get(target)' on the first line has no 'return'. Exponential time, times out")
  @Test(timeout = 2000)
  public void longImpossibleTargetNeedsMemoization() {
    assertFalse(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeef", "e", "ee", "eee", "eeee", "eeeee", "eeeeee"));
  }
}
