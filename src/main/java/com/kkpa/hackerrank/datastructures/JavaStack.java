package com.kkpa.hackerrank.datastructures;

import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/java-stack/problem?isFullScreen=true
 */
public class JavaStack {

  /*

  [({})(())]
(({()})))[[
({(){}()})()({(){}()})(){()}{}((()))
{}()))(()()({}}{}
}}}}
))))
{{{
(((
{}(){()}((())){{{}}}{()()}{{}{}}
{{{{{{{)))))))))))))))))))
{}{}(
{}}}{}
()()()())))
(((((()()()
(){}{{}}()(()){{()()}}
{}{{{}}}{{{((()))}}}
((()))[]
{{}}(()[])
   */

  /*
true
false
true
false
false
false
false
false
true
false
false
false
false
false
true
true
true
true

   */

  /**
   * Returns true when every bracket is closed by the same type, in the right order.
   */
  public static boolean isBalanced(String input) {
    Stack<Character> stack = new Stack<>();
    for (char c : input.toCharArray()) {
      switch (c) {
        case '{':
          stack.push('}');
          break;
        case '(':
          stack.push(')');
          break;
        case '[':
          stack.push(']');
          break;
        default:
          if (stack.isEmpty() || stack.pop() != c) {
            return false;
          }
      }
    }
    return stack.isEmpty();
  }

}
