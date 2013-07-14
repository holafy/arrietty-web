package ivy.web.security.control;

import ivy.json.Json;
import ivy.web.entry.context.data.SessionUser;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
