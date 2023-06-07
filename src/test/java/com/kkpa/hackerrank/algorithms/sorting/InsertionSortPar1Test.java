package com.kkpa.hackerrank.algorithms.sorting;

import com.kkpa.hackerrank.algorithms.AlgorithmsSortingConfigJunitTest;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/insertionsort1/problem
 */
@RunWith(Parameterized.class)
public class InsertionSortPar1Test extends AlgorithmsSortingConfigJunitTest {

  @Parameterized.Parameter(0)
  public int n;


  @Parameterized.Parameter(1)
  public int[] data;

  @Parameterized.Parameter(2)
  public String lastRowResult;

  @Parameterized.Parameters
  public static List<Object> data() {
    return Arrays.asList(
            new Object[][]{
                    {5, new int[]{2, 4, 6, 8, 3}, "2 3 4 6 8"//last one of result
                    },
                    {
                            14,
                            new int[]{1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23},
                            "1 3 5 9 13 22 23 27 35 46 51 55 83 87"
                    }
                    /*
                    * 1 3 5 9 13 22 27 35 46 51 55 83 87 87
                      1 3 5 9 13 22 27 35 46 51 55 83 83 87
                      1 3 5 9 13 22 27 35 46 51 55 55 83 87
                      1 3 5 9 13 22 27 35 46 51 51 55 83 87
                      1 3 5 9 13 22 27 35 46 46 51 55 83 87
                      1 3 5 9 13 22 27 35 35 46 51 55 83 87
                      1 3 5 9 13 22 27 27 35 46 51 55 83 87
                      1 3 5 9 13 22 23 27 35 46 51 55 83 87
                    * */
            }
    );
  }

  @Test
  public void testInsertions() {
    String result = insertionSortPart1.insertionSort1(n, data);
    assertEquals(lastRowResult, result);
  }
}
