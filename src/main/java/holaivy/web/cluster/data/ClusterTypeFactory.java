package holaivy.web.cluster.data;

import ivy.core.tool.Str;

import org.springframework.beans.factory.FactoryBean;

public class ClusterTypeFactory implements FactoryBean<ClusterType> {

	private String type;

	@Override
	public Class<?> getObjectType() {
		return ClusterType.class;
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	@Override
	public ClusterType getObject() throws Exception {
		if (Str.isNotEmpty(type)) {
			if (type.equalsIgnoreCase(ClusterType.Master.name())) {
				return ClusterType.Master;
			} else if (type.equalsIgnoreCase(ClusterType.Slave.name())) {
				return ClusterType.Slave;
			}
		}
		return ClusterType.None;
	}

}
