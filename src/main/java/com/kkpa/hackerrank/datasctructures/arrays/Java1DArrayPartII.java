package com.kkpa.hackerrank.datasctructures.arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/java-1d-array/problem?isFullScreen=true
 */
@Component
public class Java1DArrayPartII {

  private static Logger log = LoggerFactory.getLogger(Java1DArrayPartII.class);

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int query = scan.nextInt();

    while (query-- > 0) {
      int n = scan.nextInt();
      int leap = scan.nextInt();

      int[] game = new int[n];
      for (int i = 0; i < n; i++) {
        game[i] = scan.nextInt();
      }

      System.out.println((canWin(leap, game)) ? "YES" : "NO");
    }
  }

  public static boolean canWin(int leap, int[] game) {
    boolean result = false;

    for (int i = 0; i < game.length; i++) {
      result = game[i] == 0;

      if (i + leap <= game.length) {
        if (i + leap == game.length) {
          result = true;
          break;
        } else {
          if (game[i + leap] == 0) {
            i = leap + i;
            result = true;
          }
        }
      }
    }

    log.info("Game {} : {}", Arrays.stream(game).boxed().map(d -> d.toString()).collect(Collectors.joining(",")), result);
    return result;
  }

}
