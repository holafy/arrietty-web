package ivy.web.filter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ivy.core.tool.Str;
import ivy.web.entry.context.data.SessionUser;

import javax.servlet.http.HttpSession;

import com.ly.util.LogU;

/**
 * 用户上下文帮助类
 * 
 * @author holaivy@gmail.com
 * 
 */
public class UserContextHelper {

	public static final String SessionUserName = "username";
	public static final String SessionUserId = "userid";

	public static Map<String, HttpSession> sessions = new ConcurrentHashMap<String, HttpSession>();

	public static String removeSession(HttpSession session) {
		if (session != null) {
			Object obj = session.getAttribute(SessionUser.SESSIONUSER);
			if (obj instanceof SessionUser) {
				SessionUser suser = (SessionUser) obj;
				if (sessions.containsKey(suser.getUid())) {
					sessions.remove(suser.getUid());
					return suser.getUid();
				}
			}
		}
		return "";
	}

	public static void removeSessionByUid(String uid) {
		if (Str.isNotEmpty(uid)) {
			if (sessions.containsKey(uid)) {
				HttpSession hs = sessions.get(uid);
				if (hs != null) {
					try {
						hs.invalidate();
					} catch (Exception e) {
					}
				}
				sessions.remove(uid);
			}
		}
	}

	public static void addUserSession(HttpSession session, String username,
			String userid) {
		session.setAttribute(SessionUserName, username);
		session.setAttribute(SessionUserId, userid);
	}

	public static void addUserSession(HttpSession session, SessionUser user) {
		if (user != null && (!Str.isEmpty(user.getUn()))) {
			Object obj = session.getAttribute(SessionUser.SESSIONUSER);
			boolean updateFlag = false;
			if (obj instanceof SessionUser) {
				SessionUser sessionuser = (SessionUser) obj;
				updateFlag = sessionuser == user;
			}
			if (!updateFlag)
				session.setAttribute(SessionUser.SESSIONUSER, user);
			else if (sessions.containsKey(user.getUid())) {
				removeSessionByUid(user.getUid());
			}
			sessions.put(user.getUid(), session);
		}
	}

	public static SessionUser getUserSession(HttpSession session) {
		if (session != null) {
			return (SessionUser) session.getAttribute(SessionUser.SESSIONUSER);
		}
		return null;
	}

	public static String getUserNameFromSession(HttpSession session) {
		if (session != null) {
			return (String) session.getAttribute(SessionUserName);
		}
		LogU.e("Session is null!");
		return null;
	}

	public static String getUserIdFromSession(HttpSession session) {
		if (session != null) {
			return (String) session.getAttribute(SessionUserId);
		}
		LogU.e("Session is null!");
		return null;
	}

}
