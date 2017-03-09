import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class util {
	public static TransportClient init() {
		// 设置集群名称
		Settings settings = Settings.builder()
				.put("cluster.name", "elasticsearch").build();
		// 创建client
		TransportClient client=null;
		try {
			client= new PreBuiltTransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(
							InetAddress.getByName("127.0.0.1"), 9300));
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return client;
	}
	
	
}
