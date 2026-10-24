package com.kkpa.hackerrank.datasctructures.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SparseArrays {

    // Complete the matchingStrings function below.
    static int[] matchingStrings(String[] strings, String[] queries) {
	int[] result = new int[queries.length];

	IntStream.range(0, queries.length).forEach(q -> {
	    Arrays.asList(strings).stream().forEach(input -> {
		if (input.contentEquals(queries[q])) {
		    result[q]++;
		}
	    });
	});

	return result;
    }

}
