package com.kkpa.hackerrank.crackingcodinginterview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/ctci-fibonacci-numbers/problem
 */
public class FibonacciNumbersTest {

  @Test
  public void firstValues() {
    assertEquals(0, FibonacciNumbers.fibonacci(0));
    assertEquals(1, FibonacciNumbers.fibonacci(1));
    assertEquals(1, FibonacciNumbers.fibonacci(2));
    assertEquals(2, FibonacciNumbers.fibonacci(3));
    assertEquals(5, FibonacciNumbers.fibonacci(5));
    assertEquals(55, FibonacciNumbers.fibonacci(10));
  }

  @Test
  public void largestValueThatFitsInAnInt() {
    assertEquals(1836311903, FibonacciNumbers.fibonacci(46));
  }

  @Test
  public void linkedVersionGivesTheSameValues() {
    assertEquals(5, FibonacciNumbers.fibonacciLinked(5));
    assertEquals(55, FibonacciNumbers.fibonacciLinked(10));
    assertEquals(832040, FibonacciNumbers.fibonacciLinked(30));
  }
}
