import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class test {
	//@Test
	public void test_add_index() {
		add_index.add_index("pages");
	}
	
	//@Test
	public void test_add_document(){
		
		String json = "{" +
		        "\"user\":\"kimchy\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"trying out Elasticsearch\"" +
		    "}";
		
		add_document.add_document("pages", "one", "1",json );
	}
	
	
	@Test
	public void test_add_document_iter(){
		
		List<String> list = new ArrayList<String>();
		String json1 = "{" +
		        "\"user\":\"tom\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"hello world\"" +
		    "}";
		String json2 = "{" +
		        "\"user\":\"jerry\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"java\"" +
		    "}";
		String json3 = "{" +
		        "\"user\":\"nathan\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"electric\"" +
		    "}";
		String json4 = "{" +
		        "\"user\":\"james\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"hello search\"" +
		    "}";
		String json5 = "{" +
		        "\"user\":\"newtown\"," +
		        "\"postDate\":\"2013-01-30\"," +
		        "\"message\":\"hello kinaba\"" +
		    "}";
		
		list.add(json1);
		list.add(json2);
		list.add(json3);
		list.add(json4);
		list.add(json5);
	
		for (String json : list) {
			int index = list.indexOf(json);
			add_document.add_document("pages", "one", json);
			//add_document.add_document("pages", "one", (index+12)+"",json );
			
		}
		add_document.print();
	}
	
	//@Test
	public void test_delete_document(){
		delete_document.delete_document("pages", "one", "2");
	}
	
	
	//@Test
	public void test_delete_document_by_query(){
		
		
		delete_document_by_query.delete_document_by_query("pages", "postDate", "2013-01-30");
		
		//delete_document_by_query.delete_document_by_query("pages", "message", "hello");
	}
	
	
	//@Test
	public void search(){
		
		//search.search();
		search.search("pages", "one", "postDate", "2013-01-30");
	}
}
