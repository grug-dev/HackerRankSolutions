package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import com.kkpa.hackerrank.AbstractJunitTest;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class NewYearChaosTest extends AbstractJunitTest {

  @Parameter(0)
  public int numPeopleOnQueue;

  @Parameter(1)
  public int[] finalStateOnQueue;

  @Parameter(2)
  public String expected;

  @Before
  public void setUp() throws Exception {
  }

  @Parameters
  public static List<Object> data() {
    return Arrays.asList(new Object[][]{{5, new int[]{2, 1, 5, 3, 4}, "3"},
            {5, new int[]{2, 5, 1, 3, 4}, "Too chaotic"},
            {5, new int[]{2, 1, 5, 4, 3}, "4"},
            {8, new int[]{1, 2, 5, 3, 4, 7, 8, 6}, "6"}});
  }

  @Test
  public void testMinimumBribes() {
    String result = newYearChaos.minimumBribes(finalStateOnQueue);

    assertEquals(expected, result);

  }

}
