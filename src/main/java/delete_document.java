import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.client.transport.TransportClient;


public class delete_document {
	public static void delete_document(String index,String type,String id) {
		TransportClient client = util.init();
		
		DeleteResponse response = client.prepareDelete(index,type, id)
		        .get();
		
		//System.err.println(response.status());
		
		if (response.status().toString().equals("OK")) {
			System.err.println("删除成功");
		} else if (response.status().toString().equals("NOT_FOUND")) {
			System.err.println("要删除的文档不存在，删除失败");
		}

		
	}
}
