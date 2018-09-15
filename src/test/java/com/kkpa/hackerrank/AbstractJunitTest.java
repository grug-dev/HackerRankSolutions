package com.kkpa.hackerrank;

import org.junit.Before;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import com.kkpa.hackerrank.config.InterviewPreparationKitConfig;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.LeftRotation;
import com.kkpa.hackerrank.interviewpreparationkit.arrays.NewYearChaos;

@ContextConfiguration(classes = { InterviewPreparationKitConfig.class })
public abstract class AbstractJunitTest extends AbstractJUnit4SpringContextTests {

	private static TestContextManager testContextManager = null;
	protected static LeftRotation leftRotation;
	protected static NewYearChaos newYearChaos;

	@Before
	public void initApplicationContext() throws Exception {
		if (testContextManager == null) {
			testContextManager = new TestContextManager(getClass());
			testContextManager.prepareTestInstance(this);
			leftRotation = applicationContext.getBean(LeftRotation.class);
			newYearChaos = applicationContext.getBean(NewYearChaos.class);
		}
	}

	protected LeftRotation getRotationBean() {
		return leftRotation;
	}
}
