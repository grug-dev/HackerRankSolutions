package com.kkpa.codility;

public class BinaryGap {

  static int findLengthLongestBinaryGap(int n) {
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
