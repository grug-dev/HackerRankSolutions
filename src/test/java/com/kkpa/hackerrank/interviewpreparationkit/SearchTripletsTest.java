package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.AbstractInterviewPreparationKitConfigTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SearchTripletsTest extends AbstractInterviewPreparationKitConfigTest {


  @Parameterized.Parameter
  public List<Integer> a;

  @Parameterized.Parameter(1)
  public List<Integer> b;

  @Parameterized.Parameter(2)
  public List<Integer> c;

  @Parameterized.Parameter(3)
  public long resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    List<Integer> data = new ArrayList<>();
    return Arrays.asList(
            new Object[][]{
                    {
                            Arrays.asList(1, 3, 5),
                            Arrays.asList(2, 3),
                            Arrays.asList(1, 2, 3),
                            8
                    },
                    {
                            Arrays.asList(1, 4, 5),
                            Arrays.asList(2, 3, 3),
                            Arrays.asList(1, 2, 3),
                            5
                    },
                    {
                            Arrays.asList(1, 3, 5, 7),
                            Arrays.asList(5, 7, 9),
                            Arrays.asList(7, 9, 11, 13),
                            12
                    },
            }
    );
  }

  @Test
  public void test() {
    long result = searchTriplets.triplets(a, b, c);

    Assert.assertEquals(result, resultExpected);
  }


}
