package com.kkpa.hackerrank.java.arrays;

import com.kkpa.hackerrank.java.AbstractDataStructuresJUnitTest;
import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

/**
 * Let's play a game on an array! You're standing at index  of an -element array named . From some index  (where ), you can perform one of the following moves:
 * <p>
 * Move Backward: If cell  exists and contains a , you can walk back to cell .
 * Move Forward:
 * If cell  contains a zero, you can walk to cell .
 * If cell  contains a zero, you can jump to cell .
 * If you're standing in cell  or the value of , you can walk or jump off the end of the array and win the game.
 * In other words, you can move from index  to index , , or  as long as the destination index is a cell containing a . If the destination index is greater than , you win the game.
 * <p>
 * Function Description
 * <p>
 * Complete the canWin function in the editor below.
 * <p>
 * canWin has the following parameters:
 * <p>
 * int leap: the size of the leap
 * int game[n]: the array to traverse
 * Returns
 * <p>
 * boolean: true if the game can be won, otherwise false
 * Input Format
 * <p>
 * The first line contains an integer, , denoting the number of queries (i.e., function calls).
 * The  subsequent lines describe each query over two lines:
 * <p>
 * The first line contains two space-separated integers describing the respective values of  and .
 * The second line contains  space-separated binary integers (i.e., zeroes and ones) describing the respective values of .
 */
@RunWith(Parameterized.class)
public class Java1dArrayTest extends AbstractDataStructuresJUnitTest {


  @Parameterized.Parameter(0)
  public int lengthGame;

  @Parameterized.Parameter(1)
  public int leap;

  @Parameterized.Parameter(2)
  public int[] game;

  @Parameterized.Parameter(3)
  public boolean expectedResult;

  @Parameterized.Parameters
  public static List<Object> data() {
    return Arrays.asList(
            new Object[][]{
                    {5, 3, new int[]{0, 0, 0, 0, 0}, true},
                    {6, 5, new int[]{0, 0, 0, 1, 1, 1}, true},
                    {6, 3, new int[]{0, 0, 1, 1, 1, 0}, false},
                    {3, 1, new int[]{0, 1, 0}, false},
            }
    );
  }

  @Before
  public void setup() throws Exception {
  }

}
