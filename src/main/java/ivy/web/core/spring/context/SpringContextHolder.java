package ivy.web.core.spring.context;

import org.springframework.context.ApplicationContext;

/**
 * 存放SpringContext
 * 
 * @author holaivy@gmail.com
 * 
 */
public class SpringContextHolder {

	protected static SpringContextHolder instance = new SpringContextHolder();

	public static SpringContextHolder getInstance() {
		return instance;
	}

	public static ApplicationContext fetchContext() {
		return instance.getContext();
	}

	ApplicationContext context;

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
