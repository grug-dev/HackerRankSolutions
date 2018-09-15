package com.kkpa.hackerrank.java.bignumber;

import java.math.BigInteger;

public class JavaPrimality {

  public static final String PRIME = "prime";
  public static final String NOT_PRIME = "not prime";

  public String isPrimeAsString(BigInteger n) {
    return n.isProbablePrime(1) ? PRIME : NOT_PRIME;
  }

}
