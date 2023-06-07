package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class SpecialStringAgainTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public String data;


  @Parameterized.Parameter(1)
  public int resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {"abcbaba", 10},
                    {"asasd", 7},
                    {"aaaa", 10},
            }
    );
  }


  @Test
  public void test() {
    int result = specialStringAgain.substrCount(data.length(), data);
    assertEquals(resultExpected, result);

  }
}
