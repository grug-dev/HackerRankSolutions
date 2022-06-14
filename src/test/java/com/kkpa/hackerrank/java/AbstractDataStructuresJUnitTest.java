package com.kkpa.hackerrank.java;

import com.kkpa.hackerrank.config.DataStructuresConfig;
import com.kkpa.hackerrank.datasctructures.arrayList.JavaList;
import com.kkpa.hackerrank.datasctructures.arrays.Java1DArrayPartII;
import com.kkpa.hackerrank.datasctructures.arrays.JavaSubArray;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = {DataStructuresConfig.class})
public abstract class AbstractDataStructuresJUnitTest extends AbstractJUnit4SpringContextTests {

  private static TestContextManager testContextManager = null;
  protected static JavaSubArray javaSubbArray;
  protected static JavaList javaList;
  protected static Java1DArrayPartII java1DArrayPartII;

  @Before
  public void initApplicationContext() throws Exception {
    if (testContextManager == null) {
      testContextManager = new TestContextManager(getClass());
      testContextManager.prepareTestInstance(this);
      javaSubbArray = applicationContext.getBean(JavaSubArray.class);
      javaList = applicationContext.getBean(JavaList.class);
      java1DArrayPartII = applicationContext.getBean(Java1DArrayPartII.class);

    }
  }
}
