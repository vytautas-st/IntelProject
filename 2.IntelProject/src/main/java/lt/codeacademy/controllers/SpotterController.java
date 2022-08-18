package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.services.SpotterService;

@Controller
@RequestMapping("/spotters")
public class SpotterController {
	
	@Autowired
	SpotterService spotterService;
	
	@GetMapping("/all")
	public String getAllReports(Model model){
		model.addAttribute("spotters", spotterService.getAll());
		model.addAttribute("hello", "Spotter Database");
		return "/spotters/list";
	}

}
