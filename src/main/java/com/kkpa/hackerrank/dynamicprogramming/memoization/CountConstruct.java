package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.LinkedHashMap;
import java.util.Map;

public class CountConstruct {


  public static int countConstruct(String target, String[] wordBank, Map<String, Integer> memo) {
    if (memo.containsKey(target)) return memo.get(target);
    if (target == null || target.isEmpty()) return 1;
    int total = 0;

    for (String word : wordBank) {
      int tmp = 0;
      if (target.startsWith(word)) {
        tmp = countConstruct(target.replaceFirst(word, ""), wordBank, memo);
        total += tmp;
      }
    }
    memo.put(target, total);
    return total;
  }

  private static int countConstruct(String target, String[] wordBank) {
    return countConstruct(target, wordBank, new LinkedHashMap<>());
  }

  public static void main(String[] args) {
    System.out.println(countConstruct("purple", new String[]{"purp", "p", "ur", "le", "purpl"}));
    System.out.println(countConstruct("abcdef", new String[]{"ab", "abc", "cd", "def", "abcd"}));
  }
}
