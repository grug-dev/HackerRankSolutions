package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FrequencyQueriesTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public String data;


  @Parameterized.Parameter(1)
  public int resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {"mom", 2},
                    {"abba", 4},
                    {"abcd", 0},
                    {"ifailuhkqq", 3},
                    {"kkkk", 10},
            }
    );
  }


  @Test
  public void test() {

    int result = sherlockAnagrams.sherlockAndAnagrams(data);
    assertEquals(resultExpected, result);

  }
}
