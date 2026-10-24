package com.kkpa.hackerrank.datastructures.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Arrays2DS {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
	int length = arr.length;
	AtomicInteger y0 = new AtomicInteger(-1), x0 = new AtomicInteger(-1), sumHourglass = new AtomicInteger(0);
	List<Integer> sumHourGlasses = new ArrayList<>();

	IntStream.range(0, length).forEach(y -> {
	    if (y + 3 > length) {
		return;
	    }
	    IntStream.range(0, length).forEach(x -> {
		if (x + 3 > length) {
		    return;
		}

		IntStream.range(y, y + 3).forEach(i -> {
		    x0.incrementAndGet();
		    y0.set(-1);
		    IntStream.range(x, x + 3).forEach(j -> {
			y0.incrementAndGet();
			if (x0.get() == 1 && y0.get() != 1) {
			    return;
			}
			sumHourglass.addAndGet(arr[i][j]);
		    });
		});
		sumHourGlasses.add(sumHourglass.get());
		sumHourglass.set(0);
		x0.set(-1);
		y0.set(-1);
	    });
	});

	return sumHourGlasses.stream().max(Integer::compareTo).get();
    }

}
