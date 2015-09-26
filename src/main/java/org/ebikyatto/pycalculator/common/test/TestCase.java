package org.ebikyatto.pycalculator.common.test;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
public abstract class TestCase {
	private final Logger logger;
	
	public TestCase() {
		this.logger = LoggerFactory.getLogger(getClass());
	}
	
	protected Logger getLogger() {
		return this.logger;
	}
}
