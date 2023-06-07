package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AlternativeCharacteresTest extends AbstractInterviewPreparationKitConfigTest {

  @Parameterized.Parameter
  public String data;


  @Parameterized.Parameter(1)
  public int resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {"AAAA", 3},
                    {"BBBBB", 4},
                    {"ABABABAB", 0},
                    {"BABABA", 0},
                    {"AAABBB", 4},
            }
    );
  }


  @Test
  public void test() {
    int result = alternativeCharacteres.alternatingCharacters(data);
    assertEquals(resultExpected, result);

  }
}
