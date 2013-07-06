package ivy.web.entry.context;

import ivy.web.entry.context.data.IUserContextData;
import ivy.web.entry.context.data.SessionUser;

import org.springframework.stereotype.Component;

/**
 * @author holaivy@gmail.com
 * 
 */
@Component(SessionUserFactory.SESSIONUSERFACTORY)
public class SessionUserFactory implements
		ISessionUserFactory<IUserContextData> {
	public static final String SESSIONUSERFACTORY = "SessionUserFactory_Comp";

	@Override
	public SessionUser factory(IUserContextData user) {
		return factory(null, user);
	}

	@Override
	public SessionUser factory(SessionUser suser, IUserContextData user) {
		suser = suser == null ? new SessionUser() : suser;
		suser.setUn(user.getUn());
		suser.setAdm(user.isAdm());
		suser.setCid(user.getCid());
		suser.setNam(user.getName());
		suser.setIdno(user.getIdno());
		suser.setSid(user.getSino());
		suser.setUid(user.getUid());
		return suser;
	}
}
