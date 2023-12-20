package com.kkpa.hackerrank.algorithms.dynamicprogramming;

import org.springframework.stereotype.Component;

@Component
/**
 * example: 12384
 *
 * 1 => 1 = 1
 * 12 => 1 + (2 + 12) = 15
 * 123 => 1 + 2 + 12 + (3 + 23 + 123) = 164
 * 1238 => 1 + 2 + 12 + 3 + 23 + 123 + (8 + 38 + 238 + 1238) = 1.686
 * 12384 => 1 + 2 + 12 + 3 + 23 + 123 + 8 + 38 + 238 + 1238 + (4 + 84 + 384 + 2384 + 12384) = 16.926
 *
 * f(1) =>	1 = 1 = 1
 * f(2) =>	12 = f(1) + (2 + 12) = 15
 * f(3) =>	123 = f(2) + (3 + 23 + 123) = 164
 * f(4) =>	1238 = f(3) + (8 + 38 + 238 + 1238) = 1.686
 * f(5) =>	12384 = f(4) + (4 + 84 + 384 + 2384 + 12384) = 16.926
 *
 * Let's say:
 * df(2) = (2 + 12)
 * df(3) = (3 + 23 + 123)
 * and so on...
 *
 * So the formula would be:
 * f(2) = f(1) + df(2)
 * f(3) = f(2) + df(3)
 * and so on...
 *
 *
 * We know that a number (ex: 675) can be refactored into
 * 600 + 70 + 5 = 675
 * So in case of df(3): (3) + (23) + (123) can be refactored into
 * = (3) + (20 + 3) + (100 + 20 + 3)
 * = 1 * 100 + 2 * 20 + 3 * 3
 *
 * Now, we try to refactor all of these:
 * df(2) => (2 + 12) = 1 * 10 + 2 * 2
 * df(3) => (3 + 23 + 123) = 1 * 100 + 2 * 20	+ 3 * 3
 * df(4) => (8 + 38 + 238 + 1238) = 1 * 1000  + 2 * 200 + 3 * 30	+ 4 * 8
 * df(5) => (4 + 84 + 384 + 2384 + 12384) = 1 * 10000 + 2 * 2000	+ 3 * 300	+ 4 * 80 + 5 * 4
 *
 * Take a look at df(5) and df(4):
 * 1 * 10000 + 2 * 2000 + 3 * 300 + 4 * 80 + 5 * 4 = 10 * (1 * 1000 + 2 * 200 + 3 * 30	+ 4 * 8) + 5 * 4
 * df(5) = 10 * df(4) + 5 * 4
 *
 * There for we can generalize the formula:
 * df(n) = 10 * df(n-1) + n * digits[n]
 * f(n) = f(n-1) + df(n)
 */
public class SamAndSubstrings {

  public long sumOfSubstrings(String numAsString) {
    long result = 0;
    long multiplier = 1;
    long modulo = 1000000007L;

    for (int i = numAsString.length() - 1; i >= 0; i--) {
      // Calculate contribution of the current digit to all substrings
      int subNumber = (numAsString.charAt(i) - '0');
      result = (result + (subNumber) * multiplier * (i + 1)) % modulo;

      // Update multiplier for the next iteration
      multiplier = (multiplier * 10 + 1) % modulo;
    }

    return result;
  }

  public int substrings(String n) {
    long modulo = 1000000007L;
    return (int) (fn(n, modulo) % modulo);
  }

  private long fn(String value, long modulo) {
    int size = value.length();
    if (size == 0) return size;
    if (size == 1) return Long.parseLong(value) & modulo;
    long sum = 0;


    // sum = f(i) + df(i+1)
    String fiValue = value.substring(0, size - 1);
    String dfValue = value;
    sum = fn(fiValue, modulo) + df(dfValue, modulo);
    return sum % modulo;
  }

  private long df(String value, long modulo) {
    long sum = 0;
    long currentNumber = 0;
    int size = value.length();

    for (int x = 0; x < size; x++) {
      String subNumber = value.substring(x);
      sum += Long.parseLong(subNumber) % modulo;
    }


    return sum;
  }

}



