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

/**
 * https://www.hackerrank.com/challenges/minimum-swaps-2/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
@RunWith(Parameterized.class)
public class MinimumSwapsTwoTest extends AbstractJunitTest {

  @Parameter(0)
  public int n;

  @Parameter(1)
  public int[] customARray;

  @Parameter(2)
  public int expected;

  @Before
  public void setUp() throws Exception {
  }

  @Parameters
  public static List<Object> data() {
    return Arrays.asList(new Object[][]{
            {4, new int[]{4, 3, 1, 2}, 3},
            {5, new int[]{2, 3, 4, 1, 5}, 3},
            {7, new int[]{1, 3, 5, 2, 4, 6, 7}, 3},
    });
  }

  @Test
  public void testMinimumBribes() {
    int result = minimumSwapsTwo.minimumSwaps(customARray);

    assertEquals(expected, result);

  }

}
