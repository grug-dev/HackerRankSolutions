package com.kkpa.codility;

import com.kkpa.TestSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Codility BinaryGap: the longest run of zeros closed by ones on both sides in the binary form of n.
 */
public class BinaryGapTest {

  private static int longestGap(int n) {
    return TestSupport.invokeStatic(BinaryGap.class, "findLengthLongestBinaryGap", new Class<?>[]{int.class}, n);
  }

  @Test
  public void gapBetweenTwoOnes() {
    assertEquals(2, longestGap(9)); // 1001
  }

  @Test
  public void returnsTheLongestOfSeveralGaps() {
    assertEquals(4, longestGap(529)); // 1000010001
    assertEquals(5, longestGap(1041)); // 10000010001
  }

  @Test
  public void trailingZerosAreNotAGap() {
    assertEquals(1, longestGap(20)); // 10100
    assertEquals(0, longestGap(32)); // 100000
  }

  @Test
  public void noZerosMeansNoGap() {
    assertEquals(0, longestGap(1));
    assertEquals(0, longestGap(15)); // 1111
    assertEquals(0, longestGap(Integer.MAX_VALUE));
  }

  @Test
  public void longGap() {
    assertEquals(28, longestGap(1610612737)); // 1100000000000000000000000000001
  }
}
