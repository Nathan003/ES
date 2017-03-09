import org.elasticsearch.ResourceAlreadyExistsException;
import org.elasticsearch.client.transport.TransportClient;


public class add_index {
	public static void add_index(String index) {
		
		TransportClient client=util.init();
		try {
			client.admin().indices().prepareCreate(index).execute().actionGet();
		} catch (ResourceAlreadyExistsException e) {
			// TODO: handle exception
			System.err.println("index已存在，无法插入");
		}finally{
			System.err.println("index插入成功！");
		}
		
		
	}
}
