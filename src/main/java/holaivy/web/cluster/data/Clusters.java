package holaivy.web.cluster.data;

import org.springframework.beans.factory.InitializingBean;

public class Clusters {

	static ClusterEnv instance;

	public static ClusterEnv getInstance() {
		return instance;
	}

}
