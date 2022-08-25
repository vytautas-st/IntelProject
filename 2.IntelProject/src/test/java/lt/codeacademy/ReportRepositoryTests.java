package lt.codeacademy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lt.codeacademy.entities.Report;
import lt.codeacademy.repositories.ReportRepository;




@ExtendWith(SpringExtension.class)
@DataJpaTest
@Rollback(true)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ReportRepositoryTests {

	@Autowired
	ReportRepository reportRepository;
	
	@Test
	void testCRUD() throws Exception {
		Report report = new Report("Test");
		
		reportRepository.save(report);
		
		Iterable<Report> reportes = reportRepository.findAll();
		
		Assertions.assertThat(reportes).extracting(Report::getDescription).containsAnyOf("Test");
		
		reportRepository.delete(report);
		
		Assertions.assertThat(reportes).extracting(Report::getDescription).doesNotContain("Test");
	}
	
}
