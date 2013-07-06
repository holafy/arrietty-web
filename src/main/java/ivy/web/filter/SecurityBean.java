package ivy.web.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * Session拦截属性
 * 
 * @author holaivy
 * 
 */
public class SecurityBean {

	private String uripattern = "*.do";
	private boolean on = false;
	private List<String> excepuri = new ArrayList<String>();

	/**
	 * 匹配的URI 如"*.do" 默认值 为 "*.do"
	 * 
	 * @return
	 */
	public String getUripattern() {
		return uripattern;
	}

	public void setUripattern(String uripattern) {
		this.uripattern = uripattern;
	}

	/**
	 * 是否启用Session拦截器
	 * 
	 * @return
	 */
	public boolean isOn() {
		return on;
	}

	public void setOn(boolean on) {
		this.on = on;
	}

	/**
	 * 获取意外URI集合,List中的URI将不会被Session拦截.
	 * 
	 * @return
	 */
	public List<String> getExcepuri() {
		return excepuri;
	}

	public void setExcepuri(List<String> excepuri) {
		this.excepuri = excepuri;
	}


}
