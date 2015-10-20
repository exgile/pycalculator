package ebikyatto.pycalculator.common.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringUtil {

	private static ApplicationContext context;
	
	static {
		SpringUtil.context = new ClassPathXmlApplicationContext("spring/spring-*.xml");
	}
	
	private SpringUtil() {
	}
	
	public static Object getBean(String beanName) {
		return context.getBean(beanName);
	}
}
