package com.kkpa.hackerrank.dynamicprogramming.tabulation;

import com.kkpa.TestSupport;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * fib(n) with a bottom-up table: fib(0) = 0, fib(1) = 1, fib(n) = fib(n-1) + fib(n-2).
 */
public class FibonacciTabulationTest {

  private static long fib(int n) {
    return TestSupport.invokeStatic(FibonacciTabulation.class, "fib", new Class<?>[]{int.class}, n);
  }

  @Test
  public void firstValues() {
    assertEquals(0L, fib(0));
    assertEquals(1L, fib(1));
    assertEquals(1L, fib(2));
    assertEquals(2L, fib(3));
    assertEquals(8L, fib(6));
  }

  @Test
  public void largeValue() {
    assertEquals(12586269025L, fib(50));
  }

  @Test
  public void largestValueThatFitsInALong() {
    assertEquals(7540113804746346429L, fib(92));
  }
}
