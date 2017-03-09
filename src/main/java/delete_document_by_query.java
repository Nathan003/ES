import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.reindex.BulkIndexByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryAction;

public class delete_document_by_query {
	public static void delete_document_by_query(String index,String key,String value) {
		TransportClient client = util.init();

		BulkIndexByScrollResponse response = DeleteByQueryAction.INSTANCE
				.newRequestBuilder(client)
				.filter(QueryBuilders.matchQuery(key, value))
				.source(index).get();

		long deleted = response.getDeleted();
		
		System.err.println("已删除"+deleted+"个文档");
	}
}
