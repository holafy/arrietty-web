package ivy.web.msg.holder;

import ivy.web.core.comp.map.BasicMapHolder;

import org.springframework.scheduling.annotation.Async;

/**
 * @author holaivy@gmail.com
 * 
 */
public class ResMessage extends BasicMapHolder<String> implements IMsgHolder {

	public static ResMessage instance;

	public static ResMessage ins() {
		return instance;
	}

	public static String m(String key) {
		return ins().fetch(key);
	}

	public static String m(String key, String lang) {
		return ins().fetch(key, lang);
	}

	protected IMessageLoader mLoader;

	@Override
	public void afterPropertiesSet() throws Exception {
		preLoad();
	}

	@Async
	@Override
	public void preLoad() throws Exception {
		mLoader.fill(map);
		instance = this;
	}

	@Override
	public String fetch(String key, String lang) {
		String k = key + lang;
		return get(k);
	}

	@Override
	public String fetch(String key) {
		String k = key + MessageLang.ZH_CN;
		return get(k);
	}

	public IMessageLoader getmLoader() {
		return mLoader;
	}

	public void setmLoader(IMessageLoader mLoader) {
		this.mLoader = mLoader;
	}

}
