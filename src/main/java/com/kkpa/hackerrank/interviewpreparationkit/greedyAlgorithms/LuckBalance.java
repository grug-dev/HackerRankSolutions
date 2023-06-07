package com.kkpa.hackerrank.interviewpreparationkit.greedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/luck-balance/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=greedy-algorithms
 */
public class LuckBalance {

  public static int luckBalance(int allowToLoseImportant, List<List<Integer>> contests) {
    int luckBalance = 0;  //wins decrease. lose increase
    // k find maximum amount luck

    List<Integer> importantContest = contests.stream().filter(l -> l.get(1) == 1).map(l -> l.get(0))
            .sorted(new Comparator<Integer>() {
              @Override public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
              }
            })
            .collect(Collectors.toList());

    if (importantContest.size() <= allowToLoseImportant) {
      // Allows to lose everything
      luckBalance = contests.stream().map(c -> c.get(0)).reduce((a, b) -> a + b).get();
    } else {
      List<Integer> regularContest = contests.stream().filter(l -> l.get(1) == 0).map(l -> l.get(0)).collect(Collectors.toList());
      int maxAmountToLose = importantContest.subList(0, allowToLoseImportant).stream().reduce((a, b) -> a + b).get();
      int maxAmountToWin = -1 * importantContest.subList(allowToLoseImportant, importantContest.size()).stream().reduce((a, b) -> a + b).get();
      int maxRegularContest = regularContest.stream().collect(Collectors.summingInt(Integer::intValue)).intValue();

      luckBalance = maxAmountToLose + maxAmountToWin + maxRegularContest;
    }


    return luckBalance;
  }

  public static void main(String[] args) {
    List<List<Integer>> all = new ArrayList<>();
    all.add(Arrays.asList(2, 1));
    all.add(Arrays.asList(1, 1));
    all.add(Arrays.asList(5, 1));
    all.add(Arrays.asList(8, 1));
    all.add(Arrays.asList(10, 0));
    all.add(Arrays.asList(5, 0));

    int k = 3;
    System.out.printf("Luck Balance: " + luckBalance(k, all));
  }
}
