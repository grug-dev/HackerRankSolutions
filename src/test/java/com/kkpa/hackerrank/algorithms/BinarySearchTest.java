package com.kkpa.hackerrank.algorithms;

import org.junit.Test;

import static com.kkpa.hackerrank.algorithms.BinarySearch.binarySearch;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

  private static final int NOT_FOUND = -1;

  @Test
  public void findsMiddleElement() {
    assertEquals(3, binarySearch(new int[]{1, 3, 5, 7, 9, 11, 13}, 7));
  }

  @Test
  public void findsFirstElement() {
    assertEquals(0, binarySearch(new int[]{1, 3, 5, 7, 9}, 1));
  }

  @Test
  public void findsLastElement() {
    assertEquals(4, binarySearch(new int[]{1, 3, 5, 7, 9}, 9));
  }

  @Test
  public void findsElementInEvenLengthArray() {
    int[] arr = {2, 4, 6, 8};
    assertEquals(0, binarySearch(arr, 2));
    assertEquals(1, binarySearch(arr, 4));
    assertEquals(2, binarySearch(arr, 6));
    assertEquals(3, binarySearch(arr, 8));
  }

  @Test
  public void keySmallerThanAllElementsIsNotFound() {
    assertEquals(NOT_FOUND, binarySearch(new int[]{10, 20, 30}, 5));
  }

  @Test
  public void keyBiggerThanAllElementsIsNotFound() {
    assertEquals(NOT_FOUND, binarySearch(new int[]{10, 20, 30}, 35));
  }

  @Test
  public void keyBetweenTwoElementsIsNotFound() {
    assertEquals(NOT_FOUND, binarySearch(new int[]{10, 20, 30}, 25));
  }

  @Test
  public void emptyArrayReturnsNotFound() {
    assertEquals(NOT_FOUND, binarySearch(new int[]{}, 1));
  }

  @Test
  public void singleElementFound() {
    assertEquals(0, binarySearch(new int[]{42}, 42));
  }

  @Test
  public void singleElementNotFound() {
    assertEquals(NOT_FOUND, binarySearch(new int[]{42}, 7));
  }

  @Test
  public void worksWithNegativeNumbers() {
    int[] arr = {-50, -20, -3, 0, 4, 18};
    assertEquals(0, binarySearch(arr, -50));
    assertEquals(2, binarySearch(arr, -3));
    assertEquals(3, binarySearch(arr, 0));
    assertEquals(NOT_FOUND, binarySearch(arr, -4));
  }

  @Test
  public void worksWithIntegerLimits() {
    int[] arr = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
    assertEquals(0, binarySearch(arr, Integer.MIN_VALUE));
    assertEquals(4, binarySearch(arr, Integer.MAX_VALUE));
  }

  @Test
  public void withDuplicatesReturnsAnIndexThatHoldsTheKey() {
    // Binary search does not promise the first or the last duplicate. Only that arr[index] == key.
    int[] arr = {1, 2, 2, 2, 2, 3, 4};
    int index = binarySearch(arr, 2);
    assertEquals(2, arr[index]);
  }

  @Test
  public void doesNotChangeTheInputArray() {
    // The caller must sort the array. The method only reads it.
    int[] arr = {5, 1, 3};
    binarySearch(arr, 5);
    assertArrayEquals(new int[]{5, 1, 3}, arr);
  }

  @Test
  public void findsEveryElementAndRejectsEveryGapInLargeArray() {
    int size = 1000;
    int[] evens = new int[size];
    for (int i = 0; i < size; i++) {
      evens[i] = i * 2;
    }
    for (int i = 0; i < size; i++) {
      assertEquals("key " + (i * 2), i, binarySearch(evens, i * 2));
      assertEquals("key " + (i * 2 + 1), NOT_FOUND, binarySearch(evens, i * 2 + 1));
    }
  }
}
