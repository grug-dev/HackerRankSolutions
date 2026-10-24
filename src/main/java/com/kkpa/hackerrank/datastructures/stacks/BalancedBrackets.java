package com.kkpa.hackerrank.datastructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://www.hackerrank.com/challenges/balanced-brackets/problem
 * <p>
 * A bracket is one of: ( ) { } [ ]
 * A string is balanced if every opening bracket is closed by the same type, in the correct order.
 * Constraints: 1 <= |s| <= 10^3, and s contains only bracket characters.
 */
public class BalancedBrackets {

  /**
   * @param brackets a string of brackets
   * @return "YES" if the brackets are balanced, otherwise "NO"
   */
  public static String isBalanced(String brackets) {
    final String NO = "NO";
    final String YES = "YES";
    if (brackets == null || brackets.length() <= 1) return  NO;

    Deque<Character> stack = new ArrayDeque<>();

    for (char ch : brackets.toCharArray()) {
      if (isOpeningBracket(ch)) {
          stack.push(ch);
      }else  {
        if (stack.isEmpty()) return NO;

        char lastOpeningBracket = stack.pop();

        if (lastOpeningBracket == '(' && ch != ')') return NO;
        if (lastOpeningBracket == '{' && ch != '}') return NO;
        if (lastOpeningBracket == '[' && ch != ']') return NO;

      }
    }

    if (!stack.isEmpty()) {
      return NO;
    }

    return YES;
  }

  private static boolean isOpeningBracket(char ch) {
    return ch == '(' || ch == '{' ||ch == '[' ;
  }
}
