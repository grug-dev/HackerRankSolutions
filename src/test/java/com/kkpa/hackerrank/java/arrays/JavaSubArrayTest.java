package com.kkpa.hackerrank.java.arrays;

import com.kkpa.hackerrank.java.AbstractDataStructuresJUnitTest;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * https://www.hackerrank.com/challenges/java-negative-subarray/problem?isFullScreen=true
 * <p>
 * We define the following:
 * <p>
 * A subarray of an -element array is an array composed from a contiguous block of the original array's elements.
 * For example, if , then the subarrays are , , , , , and . Something like  would not be a subarray as it's not a contiguous subsection of the original array.
 * The sum of an array is the total sum of its elements.
 * An array's sum is negative if the total sum of its elements is negative.
 * An array's sum is positive if the total sum of its elements is positive.
 * Given an array of  integers, find and print its number of negative subarrays on a new line.
 * <p>
 * Input Format
 * <p>
 * The first line contains a single integer, , denoting the length of array .
 * The second line contains  space-separated integers describing each respective element, , in array .
 * <p>
 * Constraints
 * <p>
 * Output Format
 * <p>
 * Print the number of subarrays of  having negative sums.
 * <p>
 * Sample Input
 * <p>
 * 5
 * 1 -2 4 -5 1
 * Sample Output
 * <p>
 * 9
 */
@RunWith(Parameterized.class)
public class JavaSubArrayTest extends AbstractDataStructuresJUnitTest {


  @Parameter(0)
  public int lengthArray;

  @Parameter(1)
  public int[] numberArray;

  @Parameter(2)
  public int expectedResult;


  @Before
  public void setup() throws Exception {
  }

  @Parameters
  public static List<Object> data() {
    return Arrays.asList(
            new Object[][]{
                    {5, new int[]{1, -2, 4, -5, 1}, 9}
            }
    );
  }

  @Test
  public void testHaveNegativeSums() {
    int result = javaSubbArray.negativesFrom(numberArray);
    assertEquals(expectedResult, result);
  }
}
