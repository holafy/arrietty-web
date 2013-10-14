package ivy.web.security.control;

import holaivy.comm.log.slf.util.SLU;
import ivy.basic.ViException;
import ivy.core.tool.Str;
import ivy.web.entry.context.IStartLoginService;
import ivy.web.entry.context.UserContextManager;
import ivy.web.entry.context.data.IUserContextData;
import ivy.web.entry.context.data.SessionUser;
import ivy.web.filter.SecurityBean;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * 
 * 
 * Servlet Filter implementation class IvySecuritySessionFilter
 */
//@WebFilter("*.do")
public class IvySecuritySessionFilter implements Filter {
	public static final Logger logger = LoggerFactory
			.getLogger(IvySecuritySessionFilter.class);

	protected SecurityBean sbean;
	protected String umKey;
	protected UserContextManager umanager;

	/**
	 * Default constructor.
	 */
	public IvySecuritySessionFilter() {

	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (sbean != null && sbean.isOn()) {
			if (request instanceof HttpServletRequest) {
				HttpServletRequest httpRequest = (HttpServletRequest) request;
				HttpSession session = httpRequest.getSession();
				Object obj = session.getAttribute(SessionUser.SESSIONUSER);
				if (obj instanceof SessionUser
						&& Str.isNotEmpty(((SessionUser) obj).getUid())) {
					if (logger.isDebugEnabled()) {
						// logger.debug("用户[{}]访问了URL:[{}]",
						// ((SessionUser) obj).getUid(),
						// httpRequest.getRequestURI());
					}
				} else {
					IUserContextData data = null;
					try {
						data = umanager.getService().start(
								request.getParameter(umanager.getUnKey()),
								request.getParameter(umanager.getUpKey()),
								IStartLoginService.NORMAL_USER);
					} catch (ViException e) {
						SLU.e(e, IvySecuritySessionFilter.class);
					}
					if (data != null && data.userActive()) {
						SessionUser sessionuser = umanager.getFactory()
								.factory(data);
						session.setAttribute(SessionUser.SESSIONUSER,
								sessionuser);
					} else {
						logger.info("权限认证失败,URL:{}",
								httpRequest.getRequestURI());
						SecurityUtil.securityFault(httpRequest, response);
						return;
					}
				}
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		WebApplicationContext appcontext = WebApplicationContextUtils
				.getWebApplicationContext(fConfig.getServletContext());
		if (appcontext != null) {
			sbean = appcontext.getBean(SecurityBean.class);
			if (Str.isNotEmpty(umKey))
				umanager = appcontext.getBean(umKey, UserContextManager.class);
			else {
				logger.info("umKey is empty ,system load default UserContextManager object.");
				umanager = appcontext.getBean(UserContextManager.class);
			}
		}
	}

}
