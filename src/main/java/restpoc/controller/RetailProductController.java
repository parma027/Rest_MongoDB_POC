package restpoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import restpoc.business.RetailProductManager;
import restpoc.model.Product;

@RestController
@RequestMapping("/product")
public class RetailProductController {

	@Autowired
	RetailProductManager retailProductManager;

	/**
	 * GET /read --> Read a product by product id from MongoDB. URL: GET
	 * @return product details
	 */
	@RequestMapping(value = "/read/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Product getProduct(@PathVariable("productId") String productId) {
		return retailProductManager.readProduct(productId);
	}

	/**
	 * PUT /update --> Update a product record and save it in the database.
	 * @return updated product details and other info in a map
	 */
	@RequestMapping(value = "/update/{productId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public @ResponseBody Product updateProduct(@PathVariable String productId, @RequestBody Product updateProduct) {
		return retailProductManager.updateProductPrice(productId, updateProduct);
	}

	/**
	 * GET /read --> Read all products from MongoDB.
	 * @return all products details
	 */
	@RequestMapping(value = "/read-all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody List<Product> readAllProducts() {
		return retailProductManager.readAllProducts();
	}
}
