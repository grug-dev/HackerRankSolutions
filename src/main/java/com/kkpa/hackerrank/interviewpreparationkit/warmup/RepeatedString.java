package com.kkpa.hackerrank.interviewpreparationkit.warmup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Result {

  /*
   * Complete the 'repeatedString' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. STRING s
   *  2. LONG_INTEGER n
   */

  public static long repeatedString(String s, long n) {
    // Write your code here
    // Write your code here
    long count = 0;
    List<Character> arr = new ArrayList<>();
    for (char el : s.toCharArray()) {
      arr.add(el);
      if (el == 'a') {
        count++;
      }
    }
    long minOccurance = n / s.length();
    count *= minOccurance;
    long lastOccurance = n % s.length();
    count += arr.subList(0, (int) lastOccurance).stream().filter(x -> x == 'a').count();
    return count;
  }

}

public class RepeatedString {

  public static void main(String[] args) throws IOException {
    String s = "aba";
    long n = 10;

    long result = Result.repeatedString(s, n);

    System.out.println(result);
  }
}
