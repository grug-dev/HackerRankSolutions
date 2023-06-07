package com.kkpa.hackerrank.datasctructures;

import java.util.Scanner;
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

  public static void main(String[] argh) {
    Scanner sc = new Scanner(System.in);

    while (sc.hasNext()) {
      String input = sc.next();
      Stack<Character> stack = new Stack<>();
      boolean result = true;

      if (input != null && input.length() >= 0) {
        char[] charArray = input.toCharArray();
        for (Character c : charArray) {

          if (c == '{' || c == '(' || c == '[') {
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
            }
          } else if (stack.isEmpty() || (!stack.isEmpty() && stack.pop() != c)) {
            result = false;
            break;
          }
        }
      }

      if (stack.isEmpty() && result) {
        System.out.println("true");
      } else {
        System.out.println("false");
      }
      ;
    }
  }

}
