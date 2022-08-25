package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lt.codeacademy.controllers.ReportController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	ReportController reportController;
	
	
	@Test
	void contextLoads() {
		Assertions.assertThat(reportController).isNotNull();
	}

}
