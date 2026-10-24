package com.kkpa.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FreeTraining {

  public static void main(String[] args) {
    String s = "zkacedfa";

    char[] schar = s.toCharArray();
    Arrays.sort(schar);

    String key = new String(schar);
    System.out.println(key);

    characterFrequency(s);

    occurencyOfChar(s);

    partitioningNumbers();
  }

  private static void partitioningNumbers() {

    List<Integer> nums = IntStream.rangeClosed(0, 10).boxed().collect(Collectors.toList());
    Map<Boolean, List<Integer>> evenOdd =
        nums.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));

    System.out.println(evenOdd);

    List<Integer> unmodifiable =
        nums.stream()
            .collect(
                Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    // unmodifiable.add(3);
  }

  private static void occurencyOfChar(String s) {
    long result = s.chars().filter(a -> a == 'a').count();

    System.out.println("Counting A: " + result);

    // All chars are unique?

    long distinctTotal = s.chars().distinct().count();
    boolean unique = distinctTotal == s.length();
    System.out.println("All are unique: " + unique);
  }

  private static void characterFrequency(String s) {
    Map<Character, Long> chFrequencyMap =
        s.chars()
            .mapToObj(obj -> (char) obj)
            .collect(Collectors.groupingBy(ch -> ch, Collectors.counting()));

    System.out.println(chFrequencyMap);
  }
}
