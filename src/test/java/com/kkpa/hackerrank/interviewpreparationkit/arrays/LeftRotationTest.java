package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertArrayEquals;


@RunWith(Parameterized.class)
public class LeftRotationTest extends AbstractInterviewPreparationKitConfigTest {


  @Parameter
  public int[] data;

  @Parameter(1)
  public int numberOfRotations;

  @Parameter(2)
  public int[] resultExpected;


  @Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {new int[]{1, 2, 3, 4, 5}, 4, new int[]{5, 1, 2, 3, 4}},
                    {new int[]{1, 2, 3, 4, 5}, 11, new int[]{2, 3, 4, 5, 1}},
                    {new int[]{1, 2, 3, 4, 5}, 5, new int[]{1, 2, 3, 4, 5}}
            }
    );
  }


  @Test
  public void testLeftRotateShouldBeSuccess() {

    int[] result = leftRotation.rotLeft(data, numberOfRotations);

    assertArrayEquals(resultExpected, result);

  }

}
