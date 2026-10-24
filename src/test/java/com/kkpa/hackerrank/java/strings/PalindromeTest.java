package com.kkpa.hackerrank.java.strings;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-string-reverse/problem
 * The string must read the same backward and forward. Case and every character count.
 */
@RunWith(Parameterized.class)
public class PalindromeTest {

  @Parameter(0)
  public String input;

  @Parameter(1)
  public boolean expected;

  @Parameters(name = "{index}: \"{0}\" -> {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
            {"madam", true},
            {"java", false},
            {"", true},
            {"a", true},
            {"aa", true},
            {"ab", false},
            {"abba", true},
            {"abca", false},
            {"racecar", true},
            {"racecars", false},
            {"Madam", false},
            {"Aa", false},
            {"12321", true},
            {"12312", false},
            {"a b a", true},
            {"ab a", false},
            {"!@#@!", true},
            {"aaaaaaaaaaaaaaaaaaab", false},
            {"abcdefghijjihgfedcba", true},
    });
  }

  @Test
  public void isPalindrome() {
    assertEquals("INPUT " + input, expected, Palindrome.isPalindrome(input));
  }
}
