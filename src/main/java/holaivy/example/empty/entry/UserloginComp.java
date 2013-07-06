package holaivy.example.empty.entry;

import java.util.Map;

import ivy.web.entry.context.IStartLoginService;
import ivy.web.entry.context.data.SessionUser;

public class UserloginComp implements IStartLoginService<ExampleSessionUser> {

	@Override
	public ExampleSessionUser start(Map<String, String> arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExampleSessionUser start(String arg0, String arg1, int arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SessionUser toSessionUser(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
