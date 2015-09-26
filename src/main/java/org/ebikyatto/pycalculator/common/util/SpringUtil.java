package org.ebikyatto.pycalculator.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringUtil {

	private static final ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-*.xml");
	
	public static Object getBean(String beanName) {
		return SpringUtil.context.getBean(beanName);
	}
}
