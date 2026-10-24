package com.kkpa.hackerrank.algorithms.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Two quick sort versions: one with lists, one in place on an array (Lomuto partition).
 */
public class QuickSortTest {

  private static int[] sortInPlace(int... values) {
    int[] array = values.clone();
    QuickSort.quickSort(array, 0, array.length - 1);
    return array;
  }

  private static List<Integer> sortWithCollections(Integer... values) {
    return QuickSort.quickSortWithCollections(new ArrayList<>(Arrays.asList(values)));
  }

  @Test
  public void arrayVersionSortsTheSample() {
    assertArrayEquals(new int[]{1, 3, 4, 5, 7, 8}, sortInPlace(5, 7, 8, 3, 4, 1));
  }

  @Test
  public void arrayVersionHandlesDuplicatesAndNegatives() {
    assertArrayEquals(new int[]{-5, -1, 0, 2, 2, 2, 9}, sortInPlace(2, -1, 9, 2, 0, -5, 2));
  }

  @Test
  public void arrayVersionHandlesEmptySingleAndSorted() {
    assertArrayEquals(new int[]{}, sortInPlace());
    assertArrayEquals(new int[]{42}, sortInPlace(42));
    assertArrayEquals(new int[]{1, 2, 3, 4}, sortInPlace(1, 2, 3, 4));
    assertArrayEquals(new int[]{1, 2, 3, 4}, sortInPlace(4, 3, 2, 1));
  }

  @Test
  public void partitionPutsThePivotInItsFinalPlace() {
    int[] array = {5, 7, 8, 3, 4, 1, 6};
    int pivotIndex = QuickSort.partition(array, 0, array.length - 1);

    assertEquals(4, pivotIndex); // 5, 3, 4 and 1 are smaller than 6
    assertEquals(6, array[pivotIndex]);
    for (int i = 0; i < pivotIndex; i++) {
      assertTrue(array[i] < 6);
    }
    for (int i = pivotIndex + 1; i < array.length; i++) {
      assertTrue(array[i] >= 6);
    }
  }

  @Test
  public void collectionsVersionSortsTheSample() {
    assertEquals(Arrays.asList(1, 3, 4, 5, 7, 8), sortWithCollections(5, 7, 8, 3, 4, 1));
  }

  @Test
  public void collectionsVersionHandlesDuplicatesAndNegatives() {
    assertEquals(Arrays.asList(-5, -1, 0, 2, 2, 2, 9), sortWithCollections(2, -1, 9, 2, 0, -5, 2));
  }

  @Test
  public void collectionsVersionHandlesEmptyAndSingle() {
    assertEquals(Collections.emptyList(), sortWithCollections());
    assertEquals(Collections.singletonList(42), sortWithCollections(42));
  }

  @Test
  public void bothVersionsMatchArraysSortOnRandomInput() {
    Random random = new Random(7);
    for (int round = 0; round < 50; round++) {
      int[] values = new int[random.nextInt(40)];
      for (int i = 0; i < values.length; i++) {
        values[i] = random.nextInt(21) - 10;
      }
      int[] expected = values.clone();
      Arrays.sort(expected);

      assertArrayEquals(expected, sortInPlace(values));

      List<Integer> list = new ArrayList<>();
      for (int value : values) {
        list.add(value);
      }
      List<Integer> expectedList = new ArrayList<>();
      for (int value : expected) {
        expectedList.add(value);
      }
      assertEquals(expectedList, QuickSort.quickSortWithCollections(list));
    }
  }
}
