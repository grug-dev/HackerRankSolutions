package com.kkpa.hackerrank.datasctructures.stacks;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 */
@RunWith(Parameterized.class)
public class BalancedBracketsTest {

  private static final String YES = "YES";
  private static final String NO = "NO";

  @Parameterized.Parameter(0)
  public String s;

  @Parameterized.Parameter(1)
  public String expectedResult;

  @Parameterized.Parameters(name = "{index}: \"{0}\" -> {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    // HackerRank sample
                    {"{[()]}", YES},
                    {"{[(])}", NO},
                    {"{{[[(())]]}}", YES},

                    // one pair of each type
                    {"()", YES},
                    {"[]", YES},
                    {"{}", YES},

                    // one bracket alone
                    {"(", NO},
                    {")", NO},

                    // wrong type or wrong order
                    {"(]", NO},
                    {")(", NO},
                    {"}][{", NO},

                    // one bracket too many
                    {"())", NO},
                    {"(()", NO},
                    {"{}{}(", NO},
                    {"{}}}{}", NO},

                    // pairs side by side and nested
                    {"()[]{}", YES},
                    {"[({})](())", YES},
                    {"[({})(())]", YES},
                    {"((()))[]", YES},
                    {"{{}}(()[])", YES},

                    // longer strings
                    {"(({()})))[[", NO},
                    {"({(){}()})()({(){}()})(){()}{}((()))", YES},
                    {"{}()))(()()({}}{}", NO},
                    {"}}}}", NO},
                    {"))))", NO},
                    {"{{{", NO},
                    {"(((", NO},
                    {"{}(){()}((())){{{}}}{()()}{{}{}}", YES},
                    {"{{{{{{{)))))))))))))))))))", NO},
                    {"()()()())))", NO},
                    {"(((((()()()", NO},
                    {"(){}{{}}()(()){{()()}}", YES},
                    {"{}{{{}}}{{{((()))}}}", YES},

                    // maximum length (10^3)
                    {repeat("(", 500) + repeat(")", 500), YES},
                    {repeat("[", 1000), NO},
                    {repeat("{}", 500), YES},
            }
    );
  }

  private static String repeat(String text, int times) {
    return String.join("", Collections.nCopies(times, text));
  }

  @Test
  public void isBalanced() {
    assertEquals("INPUT " + s, expectedResult, BalancedBrackets.isBalanced(s) );
  }
}
