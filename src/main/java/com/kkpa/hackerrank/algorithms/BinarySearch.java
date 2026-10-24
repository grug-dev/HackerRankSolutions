package com.kkpa.hackerrank.algorithms;

/**
 * Binary search over a sorted int array.
 * The array must be sorted in ascending order.
 * Access to any element of the array takes constant time.
 */
public class BinarySearch {

  /**
   * Finds the position of {@code key} in {@code arr}.
   *
   * @param arr sorted array (ascending). It can be empty. If it is not sorted, the result is undefined.
   *            The method does not change the array.
   * @param key the value to find
   * @return an index {@code i} where {@code arr[i] == key}, or {@code -1} if the key is not in the array.
   * With duplicates, any matching index is valid.
   */
  public static int binarySearch(int[] arr, int key) {
    if (arr.length == 0) return -1;

    if (arr.length == 1) {
      return (arr[0] == key) ? 0 : -1;
    }

   int low = 0;
   int high = arr.length - 1;

   while (low <= high) {
     int mid = low + (high - low) / 2 ;

     int midValue = arr[mid];
     if (midValue == key) {
       return mid;
     }else if (midValue < key) {
       low = mid + 1;
     }else {
       high = mid - 1;
     }
   }

   return -1;

  }
}
