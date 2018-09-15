package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;

@Component
public class NewYearChaos {

  // Complete the minimumBribes function below.
  public String minimumBribes(int[] q) {
    final String TOO_CHAOTIC = "Too chaotic";
    Map<Integer, Integer> mapQueue = new HashMap<>();


    int expectedValue = 1;
    int bribes = 0;
    boolean isCorrect = false;

    for (int index = 1; index <= q.length; index++) {
      isCorrect = false;
      while (!isCorrect) {
        int sticker = mapQueue.getOrDefault(index, q[index - 1]);
        expectedValue = index;
        int tmpBribes = Math.abs(expectedValue - sticker);
        if (tmpBribes == 0) {
          isCorrect = true;
          continue;
        }
        if (tmpBribes > 2) {
          return TOO_CHAOTIC;
        }
        bribes += tmpBribes;
        int tmpIndex = index;
        while (tmpBribes > 0) {
          mapQueue.put(tmpIndex, mapQueue.getOrDefault(tmpIndex + 1, q[tmpIndex]));
          mapQueue.put(++tmpIndex, sticker);
          tmpBribes--;
        }
      }
    }
    return String.valueOf(bribes);
  }

}
