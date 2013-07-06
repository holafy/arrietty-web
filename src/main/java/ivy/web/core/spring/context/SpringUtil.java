package ivy.web.core.spring.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author holaivy@gmail.com
 * 
 */
public class SpringUtil {
	
	public static ApplicationContext springAppContext;

	public static String spring_dir = "spring/";

	public static String file_name = ".xml";

	public static ApplicationContext fetchSpringContext(String name) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext(spring_dir
				+ name + file_name);
		return ctx;
	}
}
