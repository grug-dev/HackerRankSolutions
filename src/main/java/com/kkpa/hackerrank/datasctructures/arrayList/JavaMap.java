package com.kkpa.hackerrank.datasctructures.arrayList;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/phone-book/problem?isFullScreen=true
 */
@Component
public class JavaMap {

  public static void main(String[] argh) {
    Map<String, Integer> phonesMap = new HashMap<>();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for (int i = 0; i < n; i++) {
      String name = in.nextLine();
      int phone = in.nextInt();
      phonesMap.put(name, phone);
      in.nextLine();
    }
    while (in.hasNext()) {
      String result = "Not found";
      String s = in.nextLine();
      if (phonesMap.get(s) != null) {
        result = String.format("%s=%d", s, phonesMap.get(s));
        System.out.println(result);
      } else {
        System.out.println(result);
      }
    }
  }
}
