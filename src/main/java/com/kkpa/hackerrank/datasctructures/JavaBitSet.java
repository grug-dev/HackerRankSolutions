package com.kkpa.hackerrank.datasctructures;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/java-bitset/problem?isFullScreen=true
 * <p>
 * <p>
 * Java's BitSet class implements a vector of bit values (i.e.:  () or  ()) that grows as needed, allowing us to easily manipulate bits while optimizing space (when compared to other collections). Any element having a bit value of  is called a set bit.
 * <p>
 * Given  BitSets,  and , of size  where all bits in both BitSets are initialized to , perform a series of  operations. After each operation, print the number of set bits in the respective BitSets as two space-separated integers on a new line.
 */
public class JavaBitSet {

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int numOperations = scan.nextInt();

    int cont = 1;
    List<String> operations = new ArrayList<>();
    while (cont <= numOperations) {
      String s = scan.nextLine();
      if (s != null && !s.isEmpty()) {
        cont++;
        operations.add(s);
      }
    }
    if (operations.size() != numOperations) {
      throw new IllegalArgumentException("No total operations");
    }
    BitSet b1 = new BitSet(n);
    BitSet b2 = new BitSet(n);
    for (String operation : operations) {
      String[] ops = operation.split(" ");
      String instruction = ops[0];
      int numSet = Integer.parseInt(ops[1]);
      int index = Integer.parseInt(ops[2]);
      BitSet tmp = null;
      tmp = numSet == 1 ? b1 : b2;
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
      // printe set bits b1, b2
      long setBitCountB1 = b1.stream().count();
      long setBitCountB2 = b2.stream().count();
      System.out.println(String.format("%d %d", b1.cardinality(), setBitCountB2));
    }
  }
}
