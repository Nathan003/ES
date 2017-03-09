import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;

public class add_document {
	static int i = 0, j = 0;
	static IndexResponse response = null;

	public static void add_document(String index, String type, String id,
			String json) {
		Client client = util.init();

		response = client.prepareIndex(index, type, id).setSource(json).get();

		if ((response.status()).toString().equals("CREATED")) {
			i++;
			// System.err.println("");

		} else {
			j++;
			if (j == 0) {
				System.err.println("插入成功!" + i + "条数据");
			} else {

			}
			// System.err.println("插入失败");
		}
	}

	public static void add_document(String index, String type, String json) {
		Client client = util.init();

		response = client.prepareIndex(index, type).setSource(json).get();

		if ((response.status()).toString().equals("CREATED")) {
			i++;
			// System.err.println("");

		} else {
			j++;
			if (j == 0) {
				System.err.println("插入成功!" + i + "条数据");
			} else {

			}
			// System.err.println("插入失败");
		}
	}

	public static void print() {
		System.err.println("插入成功!" + i + "条数据");
		System.err.println("插入失败" + j + "条数据");

	}
}
