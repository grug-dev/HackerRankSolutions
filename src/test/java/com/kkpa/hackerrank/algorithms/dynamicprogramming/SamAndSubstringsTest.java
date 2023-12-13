package com.kkpa.hackerrank.algorithms.dynamicprogramming;

import com.kkpa.hackerrank.algorithms.AlgorithmsSortingConfigJunitTest;
import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static junit.framework.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SamAndSubstringsTest extends AlgorithmsSortingConfigJunitTest {


  @Parameterized.Parameter(0)
  public String n;


  @Parameterized.Parameter(1)
  public int expectedResult;

  @Parameterized.Parameters
  public static List<Object> data() {
    return Arrays.asList(
            new Object[][]{
                    {"1", 1},
                    {"12", 15},
                    {"123", 164},
                    {"1238", 1686},
                    {"12384", 16926},
                    {"972698438521", 445677619},
                    {"960880276897", 335573181},
            }
    );
  }

  @Test
  public void testSamSubstrings() {
    assertEquals(expectedResult, samAndSubstrings.substrings(n));
  }

  @Test
  public void sumOfSubstrings() {
    assertEquals(expectedResult, samAndSubstrings.sumOfSubstrings(n));
  }

}
