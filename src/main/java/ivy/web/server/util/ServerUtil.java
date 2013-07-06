package ivy.web.server.util;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

/**
 * J2EE Server 工具类
 * 
 * @author holaivy@gmail.com
 * 
 */
public class ServerUtil {
	public static Logger logger = Logger.getLogger(ServerUtil.class);

	public static final String REQUEST_URI = "REQUEST URI: ";
	public static final String REQUEST_PARAMS = "\nREQUEST PARAMS : ";
	public static final String REQUEST_PARAM_NAME = "\nPARAM NAME : ";
	public static final String REQUEST_PARAM_VALUE = "\tVALEU: ";
	public static final String HLINE = "----------------------\n";
	public static final String H_SHORT_LINE = "#############\n";
	public static final String REQUEST_HEADER_NAME = "\nREQUEST HEADER NAME: ";
	public static final String REQUEST_HEADER_VALUE = "\tREQUEST HEADER VALUE: ";

	/**
	 * 日志输出Http Request
	 * 
	 * @param request
	 */
	public static void outputReqeust(HttpServletRequest request) {
		String str_n = "\n";
		StringBuilder buf = new StringBuilder(str_n);
		buf.append(HLINE);
		buf.append(REQUEST_URI).append(request.getRequestURI());
		buf.append(REQUEST_PARAMS);
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String n = paramNames.nextElement();
			String v = request.getParameter(n);
			buf.append(REQUEST_PARAM_NAME).append(n)
					.append(REQUEST_PARAM_VALUE).append(v);
		}
		buf.append(str_n).append(H_SHORT_LINE);
		Enumeration<String> er = request.getHeaderNames();
		while (er.hasMoreElements()) {
			String name = er.nextElement();
			String value = request.getHeader(name);
			buf.append(REQUEST_HEADER_NAME).append(name)
					.append(REQUEST_HEADER_VALUE).append(value);
		}
		buf.append(str_n).append(HLINE);
		logger.info(buf.toString());
	}
}
