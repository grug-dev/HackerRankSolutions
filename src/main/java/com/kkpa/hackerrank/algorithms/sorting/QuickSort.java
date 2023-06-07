package com.kkpa.hackerrank.algorithms.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class QuickSort {


  public static void main(String[] args) {
    int[] initialNumbers2 = new int[]{5, 7, 8, 3, 4, 1,};
    List<Integer> initialNumbers = Arrays.stream(initialNumbers2).boxed().collect(Collectors.toList());

    //start
    List<Integer> result = quickSortWithCollections(initialNumbers);
    System.out.println("Result " + result);

    quickSort(initialNumbers2, 0, initialNumbers2.length - 1);
    System.out.println("ARrays  " + Arrays.stream(initialNumbers2).boxed().collect(Collectors.toList()));
  }

  public static List<Integer> quickSortWithCollections(List<Integer> initialNumbers) {
    if (initialNumbers.size() <= 1) {
      return initialNumbers;
    }

    int pivot = initialNumbers.get(initialNumbers.size() - 1);

    List<Integer> leftArray = new ArrayList<>();
    List<Integer> rightArray = new ArrayList<>();

    for (int i = 0; i < initialNumbers.size() - 1; i++) {
      int value = initialNumbers.get(i);
      if (value < pivot) {
        leftArray.add(value);
      } else {
        rightArray.add(value);
      }
    }
    List<Integer> leftResult = quickSortWithCollections(leftArray);
    leftResult.add(pivot);
    List<Integer> rightResult = quickSortWithCollections(rightArray);
    leftResult.addAll(rightResult);
    return leftResult;
  }


  public static void quickSort(int[] array, int low, int high) {
    if (low >= high) {
      return;
    }
    int pivotIndex = partition(array, low, high);
    quickSort(array, low, pivotIndex - 1);
    quickSort(array, pivotIndex + 1, high);
  }

  /**
   * For simplicity, this function takes the last element as the pivot. Then, checks each element and swaps it before the pivot if its value is smaller.
   * <p>
   * By the end of the partitioning, all elements less then the pivot are on the left of it and all elements greater then the pivot are on the right of it. The pivot is at its final sorted position and the function returns this position:
   *
   * @param array
   * @param begin
   * @param end
   * @return
   */
  public static int partition(int[] array, int begin, int end) {
    int pivotValue = array[end];
    int i = begin - 1;
    for (int j = begin; j < end; j++) {
      if (array[j] < pivotValue) {
        i++;
        swap(array, i, j);
      }
    }
    swap(array, i + 1, end);
    return i + 1;
  }

  public static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

}
