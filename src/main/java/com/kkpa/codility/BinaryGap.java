package com.kkpa.codility;

public class BinaryGap {

  public static void main(String[] args) {
    System.out.println(findLengthLongestBinaryGap(32));
    System.out.println(findLengthLongestBinaryGap(1041));
  }

  private static int findLengthLongestBinaryGap(int n) {
    String binaryStr = Integer.toBinaryString(n);
    int max = 0;
    int currentGap = 0;

    for (char digit : binaryStr.toCharArray()) {
      if (digit == '0') {
        currentGap++;
      } else {
        max = Math.max(max, currentGap);
        currentGap = 0;
      }
    }
    return max;
  }

}
