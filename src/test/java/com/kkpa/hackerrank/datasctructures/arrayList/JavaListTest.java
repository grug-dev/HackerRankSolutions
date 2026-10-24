package com.kkpa.hackerrank.datasctructures.arrayList;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-list/problem
 * "Insert x y" puts y at index x. "Delete x" removes the value at index x.
 */
public class JavaListTest {

  @Test
  public void hackerRankSample() {
    List<Integer> numbers = Arrays.asList(12, 0, 1, 78, 12);
    assertEquals(Arrays.asList(0, 1, 78, 12, 23),
            JavaList.applyQueries(numbers, Arrays.asList("Insert 5 23", "Delete 0")));
  }

  @Test
  public void insertAtTheStart() {
    assertEquals(Arrays.asList(9, 1, 2), JavaList.applyQueries(Arrays.asList(1, 2), Collections.singletonList("Insert 0 9")));
  }

  @Test
  public void deleteTheLastValue() {
    assertEquals(Collections.emptyList(), JavaList.applyQueries(Collections.singletonList(7), Collections.singletonList("Delete 0")));
  }

  @Test
  public void noQueriesKeepsTheList() {
    assertEquals(Arrays.asList(3, 4), JavaList.applyQueries(Arrays.asList(3, 4), Collections.emptyList()));
  }

  @Test
  public void doesNotChangeTheInputList() {
    List<Integer> numbers = Arrays.asList(1, 2);
    JavaList.applyQueries(numbers, Collections.singletonList("Delete 0"));
    assertEquals(Arrays.asList(1, 2), numbers);
  }
}
