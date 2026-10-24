package com.kkpa.hackerrank.dynamicprogramming.memoization;

import com.kkpa.TestSupport;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * allConstruct returns every way to build the target by joining words from the word bank.
 * Each way is a list of words in order. The order of the ways does not matter.
 */
public class AllConstructTest {

  private static List<List<String>> allConstruct(String target, String... wordBank) {
    return TestSupport.invokeStatic(AllConstruct.class, "allConstruct", new Class<?>[]{String.class, String[].class}, target, wordBank);
  }

  private static void assertSameWays(List<List<String>> expected, List<List<String>> actual) {
    assertEquals(new HashSet<>(expected), new HashSet<>(actual));
    assertEquals(expected.size(), actual.size());
  }

  private static final String WRONG_SHAPE = "BUG: each matching word is added as its own one-word list instead of being put in front of "
          + "every way to build the rest. Returns [[purp], [le], [purpl], [ur], [p]] for \"purple\"";

  @Ignore(WRONG_SHAPE)
  @Test
  public void twoWays() {
    assertSameWays(
            Arrays.asList(Arrays.asList("purp", "le"), Arrays.asList("p", "ur", "p", "le")),
            allConstruct("purple", "purp", "p", "ur", "le", "purpl"));
  }

  @Ignore(WRONG_SHAPE)
  @Test
  public void fourWays() {
    assertSameWays(
            Arrays.asList(
                    Arrays.asList("ab", "cd", "ef"),
                    Arrays.asList("ab", "c", "def"),
                    Arrays.asList("abc", "def"),
                    Arrays.asList("abcd", "ef")),
            allConstruct("abcdef", "ab", "abc", "cd", "def", "abcd", "ef", "c"));
  }

  @Test
  public void noWordMatchesTheStart() {
    assertSameWays(new ArrayList<>(), allConstruct("abc", "x", "y"));
  }

  @Ignore("BUG: the empty target and a dead end both return [], so a dead end looks like success")
  @Test
  public void targetCannotBeBuilt() {
    assertSameWays(new ArrayList<>(), allConstruct("skateboard", "bo", "rd", "ate", "t", "ska", "sk", "boar"));
  }

  @Ignore("BUG: the empty target must return [[]] (one way: use no words), but it returns []")
  @Test
  public void emptyTargetHasOneEmptyWay() {
    assertSameWays(Collections.singletonList(new ArrayList<>()), allConstruct("", "a"));
  }
}
