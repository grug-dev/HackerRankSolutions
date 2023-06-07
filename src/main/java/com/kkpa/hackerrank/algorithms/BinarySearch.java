package com.kkpa.hackerrank.algorithms;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * The data structure must be sorted.
 * Access to any element of the data structure takes constant time
 */
public class BinarySearch {


  public static void main(String[] args) {
    int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    int n = arr.length;
    int x = 18;
    Arrays.sort(arr);
    int result = binarySearch(arr, 0, n - 1, x);
    if (result == -1)
      System.out.println(
              "Element is not present in array");
    else
      System.out.println("Element is present at "
              + "index " + result + LocalDateTime.now());

    System.out.println("Binary Search " + Arrays.binarySearch(arr, x) + " " + LocalDateTime.now());
  }

  private static int binarySearch(int[] arr, int first, int last, int key) {
    if (last >= first) {
      int mid = first + (last - first) / 2;
      int midVal = arr[mid];
      if (midVal == key) {
        return mid;
      }
      if (midVal > key) {
        return binarySearch(arr, first, mid - 1, key);//search in left subarray
      } else {
        return binarySearch(arr, mid + 1, last, key);//search in right subarray
      }
    }
    return -1;
  }
}
