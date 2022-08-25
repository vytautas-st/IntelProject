package lt.codeacademy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import lt.codeacademy.controllers.ReportController;
import lt.codeacademy.entities.Report;
import lt.codeacademy.services.ReportService;



@ExtendWith(SpringExtension.class)
//@SpringBootTest
@WebMvcTest(ReportController.class)
@Rollback(true)
public class ReportControllerTests {
	
	@MockBean
	ReportService reportService;
	
	@Autowired
	  MockMvc mockMvc;
	
	@Test
	void failsifReportServiceNotAutowired() {
		Assertions.assertThat(reportService).isNotNull();
	}
	
	@Test
	void failsifNoReportsprovidedByService() throws Exception {
		Report report = new Report("Dummy");
		List<Report> reports = Arrays.asList(report);

		Mockito.when(reportService.getAll()).thenReturn(reports);
		
		mockMvc.perform(get("/reports"))
        .andExpect(status().isOk())
        .andExpect(view().name("/reports/reportsList"));		
	}
	
	@Test
	void shouldReturnPathToReportTemplate() throws Exception {	
		mockMvc.perform(get("/reports/create"))
        .andExpect(status().isOk())
        .andExpect(view().name("/reports/addReport"));		
	}
	
	@Test
	void shouldCreateNewReport() throws Exception {
	  this.mockMvc
	    .perform(post("/reports/save")
	      .param("description", "some test report"))
	    .andExpect(status().is3xxRedirection())
	    .andExpect(header().string("Location", "/reports"));
	  
	 //.andExpect(redirectedUrl("/reports")))
	}
	
	@Test
	void whenSavingMethodSaveShouldBeCalled() {
		Report report = new Report("dummy");
		
		reportService.save(report);
		
		verify(reportService, times(1)).save(report);
      	
	}
}


