package com.kkpa.hackerrank.algorithms;

import com.kkpa.hackerrank.algorithms.dynamicprogramming.SamAndSubstrings;
import com.kkpa.hackerrank.algorithms.sorting.Insertion_Sort_Part1;
import com.kkpa.hackerrank.config.AlgorithmsConfig;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = {AlgorithmsConfig.class})
public class AlgorithmsSortingConfigJunitTest extends AbstractJUnit4SpringContextTests {

  private static TestContextManager testContextManager = null;

  protected static Insertion_Sort_Part1 insertionSortPart1;
  protected static SamAndSubstrings samAndSubstrings;

  @Before
  public void initApplicationContext() throws Exception {
    if (testContextManager == null) {
      testContextManager = new TestContextManager(getClass());
      testContextManager.prepareTestInstance(this);
      insertionSortPart1 = applicationContext.getBean(Insertion_Sort_Part1.class);
      samAndSubstrings = applicationContext.getBean(SamAndSubstrings.class);
    }
  }


}
