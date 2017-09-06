package restpoc;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RedSkyProductRestClientTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testGetProductName() throws Exception {
		String expectedStr = "productName\"" + ":" + "\"Maxi dresses";
		assertThat(this.restTemplate.getForObject("http://redsky.target.com/v1/pdp/tcin/52404575", String.class)
				.contains(expectedStr));
	}
}
