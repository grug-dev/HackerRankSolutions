package com.kkpa.hackerrank.datasctructures.arrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/java-list/problem
 */
@Component
public class JavaList {

  private static Logger log = LoggerFactory.getLogger(JavaList.class);

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int size;

    size = scan.nextInt();

    LinkedList<Integer> numbers = new LinkedList<>();
    for (int i = 0; i < size; i++) {
      numbers.add(scan.nextInt());
    }
    int totalQueries = scan.nextInt();

    for (int i = 0; i < totalQueries; i++) {
      String query = scan.next();
      if (query.equalsIgnoreCase("Insert")) {
        int index = scan.nextInt();
        int value = scan.nextInt();
        numbers.add(index, value);
      } else {
        int index = scan.nextInt();
        numbers.remove(index);
      }
    }

    System.out.println(String.join(" ", numbers.stream().map(n -> n.toString()).collect(Collectors.toList())));

  }
}
