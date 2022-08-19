package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lt.codeacademy.services.ReportService;

@Controller
@RequestMapping("")
public class BaseContoller {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("")
	public String getAllReports(Model model){
		model.addAttribute("reports", reportService.getAll());
		model.addAttribute("hello", "Report Database Controls");
		return "/base/baseList";
	}

}
