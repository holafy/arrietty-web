package ivy.web.security.control;

import holaivy.comm.log.slf.util.SLU;
import ivy.core.tool.Str;
import ivy.json.Json;
import ivy.web.entry.context.data.SessionUser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ly.http.JInfo;

/**
 * @author holaivy@gmail.com
 * 
 */
public class SecurityUtil {

	/**
	 * @param response
	 */
	public static void securityFault(ServletRequest request,
			ServletResponse response) {
		if (CONTENTTYPE_JSON.equals(request.getContentType())) {
			handleJsonRequest(request, response);
			return;
		}
		if (request instanceof HttpServletRequest) {
			HttpServletRequest http = (HttpServletRequest) request;
			String value = http.getHeader("http.expect");
			if (Str.isNotEmpty(value)) {
				if (CONTENTTYPE_JSON.equals(value)) {
					handleJsonRequest(request, response);
					return;
				}
			}
		}
		handleHtmlRequest(request, response);
	}

	public static final String CONTENTTYPE_JSON = "application/json";

	public static void handleHtmlRequest(ServletRequest request,
			ServletResponse response) {
		SecurityInfo info = SecurityInfo.getInstance();
		if (info == null || Str.isEmpty(info.getLogin())) {
			handleJsonRequest(request, response);
		} else {
			HttpServletResponse httpResponse = (HttpServletResponse) response;

			if (info != null) {
				try {
					httpResponse.sendRedirect(info.getLogin());
				} catch (IOException e) {
					SLU.e(e);
				}
			}
		}
	}

	public static void handleJsonRequest(ServletRequest request,
			ServletResponse response) {
		PrintWriter pw = null;
		try {
			HttpServletResponse hrs = (HttpServletResponse) response;
			hrs.setContentType("text/html;charset=utf-8");
			hrs.setStatus(HttpServletResponse.SC_FORBIDDEN);
			pw = hrs.getWriter();
			JInfo<Object> info = new JInfo<Object>();
			info.fault("用户登陆已过期,请退出重新登陆.", JInfo.SESSIONOUT);
			pw.print(Json.encode(info));
			pw.flush();
		} catch (Exception e) {
			IvySecuritySessionFilter.logger.error(e.getMessage());
		} finally {
			if (pw != null)
				pw.close();
		}
	}

	public static void buildSessionUser(HttpSession session, SessionUser user) {

	}

}
