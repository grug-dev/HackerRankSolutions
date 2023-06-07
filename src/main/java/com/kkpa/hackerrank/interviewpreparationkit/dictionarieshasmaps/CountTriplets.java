package com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://www.hackerrank.com/challenges/count-triplets-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
 */
@Component
public class CountTriplets {

  public long countTriplets(List<Long> arr, long commonRatio) {
    long numTriplets = 0;
    Queue<Integer> stack = new LinkedList<>();

    for (int i = 0; i < arr.size(); i++) {
      Long initial = -1L;
      stack.add(i);
      while (!stack.isEmpty()) {
        int nextIndex = stack.poll();
        initial = arr.get(i);
        int idxFound = findNextIdx(nextIndex, (commonRatio * initial), arr);
        if (idxFound != -1) {
          stack.add(idxFound);
          //idxFound = arr.indexOf(commonRatio * initial * commonRatio);
          idxFound = findNextIdx(idxFound, commonRatio * initial * commonRatio, arr);
          if (idxFound != -1) {
            stack.add(idxFound);
            numTriplets++;
          }
        } else {
          stack.poll();
        }
      }
    }
    return numTriplets;
  }

  private int findNextIdx(int startIdx, long tripletValue, List<Long> arr) {
    List<Long> subList = arr.subList(startIdx + 1, arr.size());
    int idxFound = subList.indexOf(tripletValue);
    if (idxFound != -1) {
      idxFound = startIdx + idxFound + 1;
    }
    return idxFound;
  }
}
