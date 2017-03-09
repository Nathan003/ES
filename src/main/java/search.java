import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;


public class search {
	public static void search(String index,String type,String key,String value) {
		
		TransportClient client = util.init();
		
		SearchResponse response = client.prepareSearch(index)
				.setTypes(type)
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(QueryBuilders.termQuery(key, value))
				//.setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
		        .setFrom(0).setSize(60).setExplain(true)
		        .get();
		
		
		List<String> docs = new ArrayList<String>();
		
		SearchHits searchHits = response.getHits();
		for (SearchHit searchHit : searchHits) {
			docs.add(searchHit.getSourceAsString());
		}
		System.err.println(docs);
	}
	
	public static void search() {
		TransportClient client = util.init();
		
		// MatchAll on the whole cluster with all default options
		SearchResponse response = client.prepareSearch().get();
		//SearchResponse response = client.prepareSearch().execute().actionGet();
		System.err.println(response);
	}
}
