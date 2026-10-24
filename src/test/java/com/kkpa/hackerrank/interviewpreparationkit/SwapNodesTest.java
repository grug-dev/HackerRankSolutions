package com.kkpa.hackerrank.interviewpreparationkit;

import com.kkpa.hackerrank.interviewpreparationkit.search.SwapNodes;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class SwapNodesTest {

  private final SwapNodes swapNodes = new SwapNodes();

  @Parameterized.Parameter
  public List<List<Integer>> indexes;

  @Parameterized.Parameter(1)
  public List<Integer> queries;

  @Parameterized.Parameter(2)
  public List<List<Integer>> resultExpected;


  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(
            new Object[][]{
                    {
                            Arrays.asList(Arrays.asList(2, 3), Arrays.asList(-1, -1), Arrays.asList(-1, -1)),
                            Arrays.asList(1, 1),
                            Arrays.asList(Arrays.asList(3, 1, 2), Arrays.asList(2, 1, 3))
                    },
                    {
                            Arrays.asList(Arrays.asList(2, 3), Arrays.asList(-1, 4), Arrays.asList(-1, 5), Arrays.asList(-1, -1), Arrays.asList(-1, -1)),
                            Arrays.asList(2),
                            Arrays.asList(Arrays.asList(4, 2, 1, 5, 3))
                    },
                    {
                            Arrays.asList(Arrays.asList(2, 3), Arrays.asList(4, -1), Arrays.asList(5, -1), Arrays.asList(6, -1), Arrays.asList(7, 8), Arrays.asList(-1, 9), Arrays.asList(-1, -1),
                                    Arrays.asList(10, 11),
                                    Arrays.asList(-1, -1), Arrays.asList(-1, -1), Arrays.asList(-1, -1)),
                            Arrays.asList(2, 4),
                            Arrays.asList(Arrays.asList(2, 9, 6, 4, 1, 3, 7, 5, 11, 8, 10), Arrays.asList(2, 6, 9, 4, 1, 3, 7, 5, 10, 8, 11))
                    }
            }
    );
  }

  @Test
  public void testSwapNodes() {
    List<List<Integer>> result = swapNodes.swapNodes(indexes, queries);

    Assert.assertEquals(resultExpected, result);
  }

}
