package ivy.web.entry.context;

import ivy.web.entry.context.data.IUserContextData;

/**
 * @author holaivy@gmail.com
 * 
 */
public class UserContextManager {

	private String unKey = "username";
	private String upKey = "password";
	private IStartLoginService<?> service;
	private ISessionUserFactory<IUserContextData> factory;

	public ISessionUserFactory<IUserContextData> getFactory() {
		return factory;
	}

	public void setFactory(ISessionUserFactory<IUserContextData> factory) {
		this.factory = factory;
	}

	public String getUnKey() {
		return unKey;
	}

	public void setUnKey(String unKey) {
		this.unKey = unKey;
	}

	public String getUpKey() {
		return upKey;
	}

	public void setUpKey(String upKey) {
		this.upKey = upKey;
	}

	public IStartLoginService<?> getService() {
		return service;
	}

	public void setService(IStartLoginService<?> service) {
		this.service = service;
	}

}
