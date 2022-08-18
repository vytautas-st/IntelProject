package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import lt.codeacademy.entities.Report;
import lt.codeacademy.services.ReportService;

@Controller
@RequestMapping("/reports")
public class ReportController {
	
	@Autowired
	ReportService reportService;
	
	@GetMapping("getDummy")
	public @ResponseBody Report getDummy( ) {
		return new Report(0, "Dummy report", 54 , 25);
	}
	
	@GetMapping("/all")
	public String getAllReports(Model model){
		model.addAttribute("reports", reportService.getAll());
		model.addAttribute("hello", "Report Database");
		return "/reports/list";
	}
	
	@PostMapping("/save")
	public String saveDish(Report report) {
		reportService.save(report);
		return "redirect:/reports/create";
	}
	
}
