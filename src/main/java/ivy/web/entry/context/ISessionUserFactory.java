package ivy.web.entry.context;

import ivy.web.entry.context.data.IUserContextData;
import ivy.web.entry.context.data.SessionUser;

public interface ISessionUserFactory<T extends IUserContextData> {
	public SessionUser factory(T user);

	public SessionUser factory(SessionUser suser, T user);
}