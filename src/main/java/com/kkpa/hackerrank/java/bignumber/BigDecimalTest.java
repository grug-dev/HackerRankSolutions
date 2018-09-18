package com.kkpa.hackerrank.java.bignumber;

import java.math.BigDecimal;
import java.util.Arrays;

public class BigDecimalTest {

  public String[] sortDescendent(String[] numbers) {

    numbers = java.util.stream.Stream.of(numbers).filter(s -> s != null).map(s -> s.trim())
        .toArray(String[]::new);

    Arrays.sort(numbers, (a, b) -> {
      BigDecimal firstNumber = new BigDecimal(a);
      BigDecimal secondNumber = new BigDecimal(b);
      return secondNumber.compareTo(firstNumber);
    });

    return numbers;
  }

}

