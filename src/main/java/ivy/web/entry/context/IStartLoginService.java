package ivy.web.entry.context;

import ivy.basic.ViException;
import ivy.web.entry.context.data.IUserContextData;
import ivy.web.entry.context.data.SessionUser;

import java.util.Map;

import org.apache.log4j.Logger;

/**
 * @author holaivy@gmail.com
 * 
 */
public interface IStartLoginService<T extends IUserContextData> {

	public static Logger logger = Logger.getLogger(IStartLoginService.class);

	public static final int CONSOLE_ADMIN = 101;
	public static final int NORMAL_USER = 100;
	public static final int CONSOLE_USER = 102;
	public static final int REMOTE_WS_INVOKE = 110;
	public static final int REMOTE_HTTP_INVOKE = 111;

	public T start(String username, String password, int type) throws ViException;

	public T start(Map<String, String> map, int type) throws ViException;

	public SessionUser toSessionUser(String username) throws ViException;
}
