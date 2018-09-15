package com.kkpa.hackerrank.java.bignumber;

import static org.junit.Assert.assertEquals;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaPrimalityTests {


  @Test
  public void givenANumberReturnIfItisPrime() {
    BigInteger n = new BigInteger("24");

    JavaPrimality primality = new JavaPrimality();
    String result = primality.isPrimeAsString(n);

    assertEquals(JavaPrimality.NOT_PRIME, result);

  }

  @Test
  public void givenAPrimeNumberShouldReturnPrimeText() {
    BigInteger n = new BigInteger("13");

    JavaPrimality primality = new JavaPrimality();
    String result = primality.isPrimeAsString(n);

    assertEquals(JavaPrimality.PRIME, result);

  }


}
