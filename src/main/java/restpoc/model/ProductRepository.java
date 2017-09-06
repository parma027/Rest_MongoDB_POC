package restpoc.model;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {

	/**
	 * This method will find an Product instance in the database by its product
	 * price. This method is not implemented and its working code will be
	 * automatically generated from its signature by Spring Data JPA.
	 */

}
