package restpoc.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import restpoc.model.Product;
import restpoc.model.ProductRepository;

@Service
public class RetailProductManager {
	@Autowired
	ProductRepository productRepository;

	public Product readProduct(String productId) {
		Product product = productRepository.findOne(productId);

		String productName = null;
		productName = RedSkyProductRestClient.getProductName("52404575");
		if (product != null)
			product.setProductName(productName);
		return product;
	}

	public Product updateProductPrice(String productId, Product product) {

		Product updateProduct = productRepository.findOne(productId);
		updateProduct.setProductPrice(product.getProductPrice());
		return productRepository.save(updateProduct);
	}

	public List<Product> readAllProducts() {
		List<Product> products = productRepository.findAll();

		String productName = null;
		productName = RedSkyProductRestClient.getProductName("52404575");

		for (Product product : products) {
			product.setProductName(productName);
		}
		return products;
	}
}
