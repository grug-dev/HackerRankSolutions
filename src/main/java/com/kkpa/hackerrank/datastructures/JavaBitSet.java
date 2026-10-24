package com.kkpa.hackerrank.datastructures;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true
 * <p>
 * <p>
 * Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.
 * <p>
 * Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.
 */
public class JavaBitSet {

  /**
   * Applies each operation to two BitSets of size n.
   * Returns, for each operation, the set bit counts of B1 and B2 as "b1 b2".
   */
  public static List<String> applyOperations(int n, List<String> operations) {
    List<String> results = new ArrayList<>();
    BitSet b1 = new BitSet(n);
    BitSet b2 = new BitSet(n);
    for (String operation : operations) {
      String[] ops = operation.split(" ");
      String instruction = ops[0];
      int numSet = Integer.parseInt(ops[1]);
      int index = Integer.parseInt(ops[2]);
      BitSet tmp = numSet == 1 ? b1 : b2;
      switch (instruction) {
        case "AND":
          if (numSet == 1) {
            b1.and(b2);
          } else {
            b2.and(b1);
          }
          break;
        case "OR":
          if (numSet == 1) {
            b1.or(b2);
          } else {
            b2.or(b1);
          }
          break;
        case "XOR":
          if (numSet == 1) {
            b1.xor(b2);
          } else {
            b2.xor(b1);
          }
          break;
        case "FLIP":
          tmp.flip(index);
          break;
        case "SET":
          tmp.set(index);
          break;
      }
      results.add(String.format("%d %d", b1.cardinality(), b2.cardinality()));
    }
    return results;
  }
}
