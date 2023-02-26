package com.kkpa.hackerrank.java.arrays;

import com.kkpa.hackerrank.java.AbstractDataStructuresJUnitTest;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

/**
 * https://www.hackerrank.com/challenges/java-hashset/problem?isFullScreen=true
 */
@RunWith(Parameterized.class)
public class JavaHashSetTest extends AbstractDataStructuresJUnitTest {


  @Parameterized.Parameter(0)
  public String[] pairLeft;

  @Parameterized.Parameter(1)
  public String[] pairRight;


  @Before
  public void setup() throws Exception {
  }

  @Parameterized.Parameters
  public static List<Object> data() {
    return Arrays.asList(
            new Object[][]{
                    {new String[]{"john", "john", "john", "mary", "mary"}, new String[]{"tom", "mary", "tom", "anna", "anna"}},
            }
    );
  }

  @Test
  public void testUniquePairs() {
    javaHashSet.uniquePairs(pairLeft, pairRight);
  }
}
