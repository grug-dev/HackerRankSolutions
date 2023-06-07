package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class MaxArraySumTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public List<Integer> indexes;


  @Parameterized.Parameter(1)
  public int resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    List<Integer> data = new ArrayList<>();
    return Arrays.asList(
            new Object[][]{
                    {
                            Arrays.asList(3, 7, 4, 6, 5), 13
                    },
                    {
                            Arrays.asList(2, 1, 5, 8, 4), 11
                    },
                    {
                            Arrays.asList(3, 5, -7, 8, 10), 15
                    }
            }
    );
  }

  @Test
  public void testMaxSubsetSum() {
    int result = maxArraySum.maxSubsetSum(indexes);

    Assert.assertEquals(resultExpected, result);
  }

}
