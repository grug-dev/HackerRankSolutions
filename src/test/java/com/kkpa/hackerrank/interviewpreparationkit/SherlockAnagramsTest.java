package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.interviewpreparationkit.dictionariesandhashmaps.SherlockAnagrams;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class SherlockAnagramsTest {

  private final SherlockAnagrams sherlockAnagrams = new SherlockAnagrams();

  @Parameterized.Parameter public String data;

  @Parameterized.Parameter(1)
  public int resultExpected;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {"mom", 2},
          {"abba", 4},
          {"abcd", 0},
          {"ifailuhkqq", 3},
          {"kkkk", 10},
        });
  }

  @Test
  public void test() {

    int result = sherlockAnagrams.sherlockAndAnagrams(data);
    assertEquals(resultExpected, result);

    result = sherlockAnagrams.sherlockAndAnagrams2(data);
    assertEquals(resultExpected, result);
  }
}
