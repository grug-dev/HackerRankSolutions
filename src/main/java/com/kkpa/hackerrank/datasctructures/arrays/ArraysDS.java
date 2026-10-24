package com.kkpa.hackerrank.datasctructures.arrays;

import java.util.stream.IntStream;

public class ArraysDS {

    // Complete the reverseArray function below.
    static int[] reverseArray(int[] a) {
	int lengthArray = a.length;
	int[] reverseArray = new int[lengthArray];

	IntStream.range(0, lengthArray).forEach(i -> {
	    reverseArray[i] = a[(lengthArray - i) - 1];
	});

	return reverseArray;
    }

}
