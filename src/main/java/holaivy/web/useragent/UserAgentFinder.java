package holaivy.web.useragent;

import java.util.Map;

import ivy.core.tool.Str;

public class UserAgentFinder {

	private Map<String, Integer> rules;

	public int ident(String ua) {
		if (Str.isNotEmpty(ua) && rules != null) {
			
		}
		return UserAgentConstant.Failed;
	}

}
