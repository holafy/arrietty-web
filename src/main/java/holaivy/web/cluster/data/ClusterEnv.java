package holaivy.web.cluster.data;

import org.springframework.beans.factory.InitializingBean;

/**
 * 集群部署的环境变量,用于判断集群信息
 * 
 * @author holaivy@gmail.com
 * 
 */
public class ClusterEnv implements InitializingBean {

	private ClusterType type;

	public boolean isMaster() {
		return type == ClusterType.Master;
	}

	public boolean isSlave() {
		return type == ClusterType.Slave;
	}

	public boolean isCluster() {
		return type == ClusterType.None;
	}

	public ClusterType getType() {
		return type;
	}

	public void setType(ClusterType type) {
		this.type = type;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Clusters.instance = this;
	}

}
