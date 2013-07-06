package ivy.web.msg.holder;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author holaivy@gmail.com
 * 
 */
public interface IMsgHolder extends InitializingBean {

	public void afterPropertiesSet() throws Exception;

	public void preLoad() throws Exception;

	public String fetch(String key, String lang);

	public String fetch(String key);

}
