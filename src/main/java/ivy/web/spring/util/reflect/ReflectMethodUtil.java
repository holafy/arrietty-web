package ivy.web.spring.util.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

/**
 * @author holaivy@gmail.com
 * 
 */
public class ReflectMethodUtil {

	/**
	 * 获取方法参数名字
	 * 
	 * @param m
	 * @return
	 */
	public static String[] fetchMethodParamName(Method m) {
		String[] params = null;
		ParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
		params = discoverer.getParameterNames(m);
		return params;
	}

	public static MethodParamInfo[] fetchMethodParamInfo(Method m) {
		String[] pNames = fetchMethodParamName(m);
		if (pNames != null) {
			MethodParamInfo[] info = new MethodParamInfo[pNames.length];
			Class<?>[] paramClasses = m.getParameterTypes();
			Type[] types = m.getGenericParameterTypes();
			for (int i = 0; i < pNames.length; i++) {
				MethodParamInfo inf = new MethodParamInfo();
				info[i] = inf;
				inf.setName(pNames[i]);
				inf.setType(paramClasses.toString());
				Type type = types[i];
				if (type instanceof ParameterizedType) {
					inf.setGeneric(true);
				}
			}
			return info;
		}
		return new MethodParamInfo[0];
	}
}
