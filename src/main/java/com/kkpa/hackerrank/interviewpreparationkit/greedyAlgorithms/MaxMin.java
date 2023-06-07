package com.kkpa.hackerrank.interviewpreparationkit.greedyAlgorithms;

import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/greedy-florist/problem?h_l=interview&isFullScreen=true&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=greedy-algorithms
 * <p>
 * <p>
 * A group of friends want to buy a bouquet of flowers. The florist wants to maximize his number of new customers and the money he makes. To do this, he decides he'll multiply the price of each flower by the number of that customer's previously purchased flowers plus . The first flower will be original price, , the next will be  and so on.
 * <p>
 * Given the size of the group of friends, the number of flowers they want to purchase and the original prices of the flowers, determine the minimum cost to purchase all of the flowers. The number of flowers they want equals the length of the  array.
 */
public class MaxMin {

  /*
   * Complete the 'maxMin' function below.
   *
   * The function is expected to return an INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER k
   *  2. INTEGER_ARRAY arr
   */

  public static int maxMin(int k, List<Integer> arr) {
    // Write your code here
    arr.sort(Integer::compare);
    int maxmin = Integer.MAX_VALUE;
    int size = arr.size();
    for (int i = 0; i < size; i++) {
      if (i + k > size) {
        break;
      }
      List<Integer> pairK = arr.subList(i, i + k);
      if (pairK.size() > 1) {
        int tmp = pairK.parallelStream().max(Integer::compare).get() - pairK.parallelStream().min(Integer::compare).get();
        if (tmp < maxmin) {
          maxmin = tmp;
        }
      }
    }
    return maxmin;
  }

  public static void main(String[] args) {
    int k = 3;
    List<Integer> arr = Arrays.asList(1,
            2,
            1,
            2,
            1

    );
    System.out.println(maxMin(k, arr));
  }

}
