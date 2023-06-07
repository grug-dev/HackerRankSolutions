package com.kkpa.hackerrank;

import com.kkpa.hackerrank.config.InterviewPreparationKitConfig;
import com.kkpa.hackerrank.dynamicprogramming.MaxArraySum;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.LeftRotation;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.MinimumSwapsTwo;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.NewYearChaos;
import com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps.CountTriplets;
import com.kkpa.hackerrank.interviewpreparationkit.dictionarieshasmaps.SherlockAnagrams;
import com.kkpa.hackerrank.interviewpreparationkit.search.SearchTriplets;
import com.kkpa.hackerrank.interviewpreparationkit.search.SwapNodes;
import com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation.AlternativeCharacteres;
import com.kkpa.hackerrank.interviewpreparationkit.stringmanipulation.SpecialStringAgain;
import com.kkpa.hackerrank.interviewpreparationkit.warmup.JumpingOnTheClouds;
import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(classes = {InterviewPreparationKitConfig.class})
public abstract class AbstractInterviewPreparationKitConfigTest extends AbstractJUnit4SpringContextTests {

  protected static LeftRotation leftRotation;
  protected static NewYearChaos newYearChaos;
  protected static MinimumSwapsTwo minimumSwapsTwo;
  protected static JumpingOnTheClouds jumpingOnTheClouds;
  protected static SherlockAnagrams sherlockAnagrams;
  protected static AlternativeCharacteres alternativeCharacteres;
  protected static SpecialStringAgain specialStringAgain;
  protected static CountTriplets countTriplets;
  private static TestContextManager testContextManager = null;

  protected static SwapNodes swapNodes;

  protected static SearchTriplets searchTriplets;

  protected static MaxArraySum maxArraySum;

  @Before
  public void initApplicationContext() throws Exception {
    if (testContextManager == null) {
      testContextManager = new TestContextManager(getClass());
      testContextManager.prepareTestInstance(this);
      leftRotation = applicationContext.getBean(LeftRotation.class);
      newYearChaos = applicationContext.getBean(NewYearChaos.class);
      minimumSwapsTwo = applicationContext.getBean(MinimumSwapsTwo.class);
      jumpingOnTheClouds = applicationContext.getBean(JumpingOnTheClouds.class);
      sherlockAnagrams = applicationContext.getBean(SherlockAnagrams.class);
      alternativeCharacteres = applicationContext.getBean(AlternativeCharacteres.class);
      countTriplets = applicationContext.getBean(CountTriplets.class);
      specialStringAgain = applicationContext.getBean(SpecialStringAgain.class);
      swapNodes = applicationContext.getBean(SwapNodes.class);
      searchTriplets = applicationContext.getBean(SearchTriplets.class);
      maxArraySum = applicationContext.getBean(MaxArraySum.class);
    }
  }


}
