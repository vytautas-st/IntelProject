package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("")
	public String getAllReports(Model model){
		model.addAttribute("reports", reportService.getAll());
		
		return "/reports/reportsList";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Report report) {
		return "/reports/addReport";
	}
	
	@PostMapping("/save")
	public String saveDish(Report report) {
		reportService.save(report);
		return "redirect:/reports";
	}
	 @GetMapping("/edit/{id}")
	    public String showUpdateReport(@PathVariable("id") int id, Model model) {
		 	Report report = reportService.getById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        model.addAttribute("report", report);
	        return "/reports/updateReport";
	    }
	 @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") int id,  Report report, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            report.setId(id);
	            return "/reports/updateReport";
	        }           
	        reportService.save(report); 
	        model.addAttribute("reports", reportService.getAll());
	      
	        return "/reports/reportsList";
	    }
	 
	 @GetMapping("/delete/{id}")
	    public String deleteAuthor(@PathVariable("id") int id, Model model) {
		 Report report = reportService.getById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
	        reportService.deleteReport(report);
	        model.addAttribute("reports", reportService.getAll());
	        return "/reports/reportsList";
	    }
	
}
