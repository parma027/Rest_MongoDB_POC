package restpoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;

import restpoc.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RetailProductControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetProduct() throws Exception {
		String expectedStr = "productId\"" + ":" + "\"123";
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/read/123", String.class)
				.contains(expectedStr));
	}

	@Test
	public void testUpdateProduct() throws Exception {
		HttpEntity<Product> request = new HttpEntity<>(new Product("123", "99"));
		assertThat(this.restTemplate.exchange("http://localhost:" + port + "/product/update/123", HttpMethod.PUT,
				request, Void.class));
	}

	@Test
	public void testReadAllProducts() throws Exception {
		String expectedStr = "productId\"" + ":" + "\"123";
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/product/read-all", String.class)
				.contains(expectedStr));
	}
}
