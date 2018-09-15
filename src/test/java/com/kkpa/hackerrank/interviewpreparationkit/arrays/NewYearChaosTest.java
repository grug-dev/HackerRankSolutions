package com.kkpa.hackerrank.interviewpreparationkit.arrays;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;
import com.kkpa.hackerrank.AbstractJunitTest;

@RunWith(Parameterized.class)
public class NewYearChaosTest extends AbstractJunitTest {

  @Parameter(0)
  public int numPeopleOnQueue;

  @Parameter(1)
  public int[] finalStateOnQueue;

  @Parameter(2)
  public String expected;

  @Before
  public void setUp() throws Exception {}

  @Parameters
  public static List<Object> data() {
    return Arrays.asList(new Object[][] {{5, new int[] {2, 1, 5, 3, 4}, new String("3")},
        {5, new int[] {2, 5, 1, 3, 4}, new String("Too chaotic")},
        {5, new int[] {2, 1, 5, 4, 3}, new String("4")},
        {8, new int[] {1, 2, 5, 3, 4, 7, 8, 6}, new String("6")}});
  }

  @Test
  public void testMinimumBribes() {
    String result = newYearChaos.minimumBribes(finalStateOnQueue);

    assertEquals(expected, result);

  }

}
