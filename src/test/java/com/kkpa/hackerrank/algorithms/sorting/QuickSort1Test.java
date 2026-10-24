package com.kkpa.hackerrank.algorithms;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/quicksort1/problem
 */
@RunWith(Parameterized.class)
public class QuickSort1Test {


  /*
   * Complete the 'quickSort' function below.
   *
   * The function is expected to return an INTEGER_ARRAY.
   * The function accepts INTEGER_ARRAY arr as parameter.
   */

  public static List<Integer> quickSort(List<Integer> arr) {
    // Write your code here
    if (arr.size() == 1) {
      return arr;
    }

    List<Integer> leftArray = new ArrayList<>();
    List<Integer> rightArray = new ArrayList<>();
    int pivot = arr.get(0);
    for (int i = 0; i < arr.size(); i++) {
      int value = arr.get(i);
      if (value < pivot) {
        leftArray.add(value);
      } else {
        rightArray.add(value);
      }
    }
    List<Integer> result = new ArrayList();
    result.addAll(leftArray);
    result.addAll(rightArray);

    return result;
  }


}
