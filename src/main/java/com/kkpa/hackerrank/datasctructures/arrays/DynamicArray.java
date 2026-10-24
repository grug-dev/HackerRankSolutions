package com.kkpa.hackerrank.datasctructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class DynamicArray {

    private static List<List<Optional<Integer>>> seqList = new ArrayList<>();

    private final static int QUERY = 1;

    private final static int UPDATED = 2;

    private static void fillSeqList(int n) {
	seqList.clear();
	IntStream.rangeClosed(0, n).forEach(l -> {
	    seqList.add(new ArrayList<Optional<Integer>>());
	});
    }

    static int[] dynamicArray(int n, int[][] queries) {
	int lastAnswer = 0;
	int[] result = null;

	fillSeqList(n);

	for (int i = 0; i < queries.length; i++) {
	    int operation = queries[i][0];
	    int x = queries[i][1];
	    int y = queries[i][2];

	    int index = (x ^ lastAnswer) % n;
	    if (operation == QUERY) {
		seqList.get(index).add(Optional.of(y));
	    } else if (operation == UPDATED) {
		y = y % seqList.get(index).size();
		lastAnswer = seqList.get(index).get(y).orElse(0);
		seqList.get(n).add(Optional.of(lastAnswer));
	    }
	}

	result = seqList.get(n).stream().mapToInt(r -> r.get()).toArray();

	return result;
    }

}
