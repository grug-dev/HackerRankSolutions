package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.LinkedHashMap;
import java.util.Map;

public class CanConstruct {

  public static boolean canConstruct(String target, String[] wordBank, Map<String, Boolean> memo) {
    if (memo.containsKey(target)) memo.get(target);
    if (target == null || target.isEmpty()) return true;
    boolean result = false;

    for (int i = 0; i < wordBank.length; i++) {
      String tmpTarget = wordBank[i];
      if (target.startsWith(tmpTarget)) {
        String tmp = target.replaceFirst(tmpTarget, "");
        result = canConstruct(tmp, wordBank, memo);
        if (result) {
          memo.put(tmpTarget, result);
        }
      }
    }
    memo.put(target, result);
    return result;
  }

  private static boolean canConstruct(String target, String[] wordBank) {
    return canConstruct(target, wordBank, new LinkedHashMap<>());
  }

  public static void main(String[] args) {
    System.out.println(canConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(canConstruct("", new String[]{"ab", "abc", "cd", "def", "abcd"}));
    System.out.println(canConstruct("skateboard", new String[]{"ab", "abc", "cd", "def", "abcd", "ska", "board"}));
    System.out.println(canConstruct("eeeeeeeeeeeeeeeeeeeeeeeeeeeef", new String[]{"ee", "e", "eee", "eeee", "eeeee", "eeeeeee"}));
  }

}
