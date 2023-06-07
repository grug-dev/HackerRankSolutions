package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CountTripletsTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public List<Long> data;

  @Parameterized.Parameter(1)
  public long commonRatio;

  @Parameterized.Parameter(2)
  public long resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {Arrays.asList(1L, 3L, 9L, 9L, 27L, 81L), 3, 6},
            }
    );
  }


  @Test
  public void test() {
    long result = countTriplets.countTriplets(data, commonRatio);
    assertEquals(resultExpected, result);

  }
}
