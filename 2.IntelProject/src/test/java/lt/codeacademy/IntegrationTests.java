package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import lt.codeacademy.controllers.ReportController;



@ExtendWith(SpringExtension.class)
@SpringBootTest
public class IntegrationTests {
	@Autowired
	ReportController reportController;
	
	 
	 
	 @Test
	  public void testErrorHandlingReturnsBadRequest() {
	 
	    RestTemplate restTemplate = new RestTemplate();
	 
	    String url = "http://localhost:8080/wrong";
	 
	    try {
	      restTemplate.getForEntity(url, String.class);
	    } catch (HttpClientErrorException e) {
	      Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
	    }
	  }
}
