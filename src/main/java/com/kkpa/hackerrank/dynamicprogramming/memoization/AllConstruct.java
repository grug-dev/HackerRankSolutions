package com.kkpa.hackerrank.dynamicprogramming.memoization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class AllConstruct {

  static List<List<String>> allConstruct(String target, String[] wordBank) {
    return allConstruct(target, wordBank, new LinkedHashMap<>());
  }

  private static List<List<String>> allConstruct(String target,
                                                 String[] wordBank,
                                                 LinkedHashMap<String, List<String>> memo) {
    if (target == null || target.isEmpty()) return new ArrayList<>();
    List<List<String>> result = new ArrayList<>();

    for (String work : wordBank) {
      if (target.startsWith(work)) {
        String suffix = target.replaceFirst(work, "");
        List<List<String>> targetWays = allConstruct(suffix, wordBank, memo);
        if (targetWays != null) {
          targetWays.add(Arrays.asList(work));
          result.addAll(targetWays);
        }
      }
    }
    return result;
  }

}
