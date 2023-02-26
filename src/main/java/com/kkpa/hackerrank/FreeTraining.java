package com.kkpa.hackerrank;

import java.util.stream.IntStream;

public class FreeTraining {

  public static void main(String args[]) {

    IntStream.range(1, 101).forEach((num) -> {
      boolean delta3 = num % 3 == 0;
      boolean delta5 = num % 5 == 0;
      if (delta5 && delta3) {
        System.out.println("FizzBuzz");
        return;
      } else if (delta3) {
        System.out.println("Fizz");
      } else if (delta5) {
        System.out.println("Buzz");
      } else {
        System.out.println(num);
      }

    });
  }
}
