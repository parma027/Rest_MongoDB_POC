package restpoc.business;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RedSkyProductRestClient {
	public static String getProductName(String productId) {
		String productname = null;
		String uri = "http://redsky.target.com/v1/pdp/tcin/" + productId;
		RestTemplate restTemplate = new RestTemplate();
		String jsonStr = restTemplate.getForObject(uri, String.class);

		JSONParser jsonParser = new JSONParser();
		Object object = null;
		try {
			object = jsonParser.parse(jsonStr);
			JSONObject jsonObject = (JSONObject) object;
			JSONObject productObj = (JSONObject) jsonObject.get("product");
			JSONObject itemObj = (JSONObject) productObj.get("item");
			JSONObject productNameObj = (JSONObject) itemObj.get("product_classification");
			JSONObject itemType = (JSONObject) productNameObj.get("item_type");
			productname = (String) itemType.get("name");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productname;
	}
}
