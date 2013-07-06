package holaivy.web.json.gen;

import ivy.json.Json;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.springframework.beans.factory.FactoryBean;

public class ObjectMapperFactory implements FactoryBean<ObjectMapper> {

	@Override
	public ObjectMapper getObject() throws Exception {
//		ObjectMapper om = new ObjectMapper();
//		om.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,
//				false);
//		om.setSerializationInclusion(Inclusion.NON_NULL);
		return Json.om;
	}

	@Override
	public Class<?> getObjectType() {
		return ObjectMapper.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
