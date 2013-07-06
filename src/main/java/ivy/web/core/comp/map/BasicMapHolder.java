package ivy.web.core.comp.map;

import ivy.core.tool.Str;

import java.util.HashMap;
import java.util.Map;

/**
 * @author holaivy@gmail.com
 * 
 */
public class BasicMapHolder<T> {

	public final Map<String, T> map = new HashMap<String, T>();

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		for (Map.Entry<String, T> entry : map.entrySet()) {
			buf.append(entry.getKey() + "----" + entry.getValue() + "\n");
		}
		return buf.toString();
	}

	public void clear() {
		if (map != null)
			map.clear();
	}

	public void put(String key, T value) {
		map.put(key, value);
	}

	public T get(String key) {
		if (Str.isNotEmpty(key) && map.containsKey(key))
			return map.get(key);
		return null;
	}

}
