package com.kkpa.hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/quicksort1/problem
 * <p>
 * One partition step: the first element is the pivot. Returns the smaller values, then the equal
 * values, then the bigger values. Each group keeps its original order.
 */
public class QuickSort1 {

  public static List<Integer> quickSort(List<Integer> arr) {
    if (arr.size() <= 1) {
      return arr;
    }

    int pivot = arr.get(0);
    List<Integer> left = new ArrayList<>();
    List<Integer> equal = new ArrayList<>();
    List<Integer> right = new ArrayList<>();
    for (int value : arr) {
      if (value < pivot) {
        left.add(value);
      } else if (value == pivot) {
        equal.add(value);
      } else {
        right.add(value);
      }
    }

    List<Integer> result = new ArrayList<>(left);
    result.addAll(equal);
    result.addAll(right);
    return result;
  }

}
