package ivy.web.msg.holder;

import java.util.Map;

/**
 * Message加载器接口
 * 
 * @author holaivy@gmail.com
 * 
 */
public interface IMessageLoader {

	public abstract void fill(Map<String, String> map);

	public abstract int getMode();

	public abstract void setMode(int mode);
}