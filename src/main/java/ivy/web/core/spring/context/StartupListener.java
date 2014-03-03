package ivy.web.core.spring.context;

import ivy.web.filter.UserContextHelper;
import holaivy.web.context.session.SessionCounter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.ContextLoaderListener;

/**
 * 自定义启动监听
 * 
 * @author holaivy@gmail.com
 * 
 */
public class StartupListener extends ContextLoaderListener implements
		HttpSessionListener, ServletContextListener, ApplicationContextAware {

	public static final Logger logger = LoggerFactory
			.getLogger(StartupListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
	}

	ApplicationContext context;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.context = applicationContext;
		if (context != null)
			SpringContextHolder.getInstance().setContext(context);
	}

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		logger.info("Session Create , Counter : {}", SessionCounter.increment());

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		logger.info("Session Destory , Counter : {}",
				SessionCounter.decrement());
		UserContextHelper.removeSession(event.getSession());
	}

}
