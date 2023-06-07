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
public class JumpingOnTheCloudsTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public List<Integer> data;


  @Parameterized.Parameter(1)
  public int resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {Arrays.asList(0, 0, 1, 0, 0, 1, 0), 4},
                    {Arrays.asList(0, 0, 0, 0, 1, 0), 3},
                    {Arrays.asList(0, 1, 0, 0, 0, 1, 0), 3},
            }
    );
  }


  @Test
  public void test() {

    int result = jumpingOnTheClouds.jumpingOnClouds(data);
    assertEquals(resultExpected, result);

  }
}
