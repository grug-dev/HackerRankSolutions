package com.kkpa.hackerrank.datastructures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-stack/problem
 * A string is balanced when every bracket is closed by the same type, in the right order.
 */
@RunWith(Parameterized.class)
public class JavaStackTest {

  @Parameter(0)
  public String input;

  @Parameter(1)
  public boolean expected;

  @Parameters(name = "{index}: {0} -> {1}")
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
            {"{}()", true},
            {"({()})", true},
            {"{}(", false},
            {"[]", true},
            {"", true},
            {"(]", false},
            {"{[(])}", false},
            {"[({})(())]", true},
            {"(({()})))[[", false},
            {"({(){}()})()({(){}()})(){()}{}((()))", true},
            {"{}()))(()()({}}{}", false},
            {"}}}}", false},
            {"))))", false},
            {"{{{", false},
            {"(((", false},
            {"{}(){()}((())){{{}}}{()()}{{}{}}", true},
            {"{{{{{{{)))))))))))))))))))", false},
            {"{}{}(", false},
            {"{}}}{}", false},
            {"()()()())))", false},
            {"(((((()()()", false},
            {"(){}{{}}()(()){{()()}}", true},
            {"{}{{{}}}{{{((()))}}}", true},
            {"((()))[]", true},
            {"{{}}(()[])", true},
    });
  }

  @Test
  public void isBalanced() {
    assertEquals("INPUT " + input, expected, JavaStack.isBalanced(input));
  }
}
