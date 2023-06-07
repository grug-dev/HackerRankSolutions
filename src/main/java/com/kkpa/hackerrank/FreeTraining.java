package com.kkpa.hackerrank;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class FreeTraining {

  public static void main(String args[]) {
    LocalDate today = LocalDate.now();
    today = today.minusMonths(11);
    LocalDateTime localDateTime = today.atStartOfDay();
    long millis = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    System.out.println("Today " + today + " seconds " + millis);
  }

}
