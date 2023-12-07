package com.kkpa.hackerrank.dynamicprogramming.tabulation;

public class FibonacciTabulation {

  private static long fib(int n) {
    int result = 0;

    long[] fibArray = new long[n + 2];
    fibArray[0] = 0;
    fibArray[1] = 1;

    for (int i = 0; i < n; i++) {
      fibArray[i + 1] += fibArray[i];
      fibArray[i + 2] += fibArray[i];
    }

    return fibArray[n];
  }

  public static void main(String[] args) {
    System.out.println(fib(50));
  }

}
