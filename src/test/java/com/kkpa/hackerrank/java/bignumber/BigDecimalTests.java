package com.kkpa.hackerrank.java.bignumber;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BigDecimalTests {


  @Test
  public void givenNumbersSortedThemDescendentAsTheyWereReceived() {
    String[] numbers = new String[] {null, "9", "-100", "50", "0", " 56.6", "   90", " 0.12",
        " .12", "  02.34", "  000.000"};

    BigDecimalTest bigDecimal = new BigDecimalTest();

    numbers = bigDecimal.sortDescendent(numbers);

    assertEquals(numbers[0], "90");
    assertEquals(numbers[numbers.length - 1], "-100");
  }


}
