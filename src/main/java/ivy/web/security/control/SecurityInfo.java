package ivy.web.security.control;

import org.springframework.beans.factory.InitializingBean;

public class SecurityInfo implements InitializingBean {

	protected static SecurityInfo instance;

	private String login;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		instance = this;
	}

	public static SecurityInfo getInstance() {
		return instance;
	}
}
