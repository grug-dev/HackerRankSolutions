package com.kkpa.hackerrank.datastructures.arraylist;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-arraylist/problem
 * Query "x y" returns the y-th number of line x, or "ERROR!" if it does not exist.
 */
public class JavaArrayListTest {

  private static final List<List<Integer>> SAMPLE_LINES = Arrays.asList(
          Arrays.asList(41, 77, 74, 22, 44),
          Collections.singletonList(12),
          Arrays.asList(37, 34, 36, 52),
          Collections.emptyList(),
          Arrays.asList(20, 22, 33));

  @Test
  public void hackerRankSample() {
    assertEquals("74", JavaArrayList.findValue(SAMPLE_LINES, 1, 3));
    assertEquals("52", JavaArrayList.findValue(SAMPLE_LINES, 3, 4));
    assertEquals("37", JavaArrayList.findValue(SAMPLE_LINES, 3, 1));
    assertEquals("ERROR!", JavaArrayList.findValue(SAMPLE_LINES, 4, 3));
    assertEquals("ERROR!", JavaArrayList.findValue(SAMPLE_LINES, 5, 5));
  }

  @Test
  public void lineDoesNotExist() {
    assertEquals("ERROR!", JavaArrayList.findValue(SAMPLE_LINES, 0, 1));
    assertEquals("ERROR!", JavaArrayList.findValue(SAMPLE_LINES, 6, 1));
  }

  @Test
  public void positionZeroDoesNotExist() {
    assertEquals("ERROR!", JavaArrayList.findValue(SAMPLE_LINES, 1, 0));
  }
}
