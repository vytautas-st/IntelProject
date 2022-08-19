package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lt.codeacademy.entities.Spotter;
import lt.codeacademy.services.SpotterService;

@Controller
@RequestMapping("/spotters")
public class SpotterController {
	
	@Autowired
	SpotterService spotterService;
	
	@GetMapping("")
	public String getAllReports(Model model){
		model.addAttribute("spotters", spotterService.getAll());
		model.addAttribute("hello", "Spotter Database");
		return "/spotters/spottersList";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Spotter spotter) {
		return "/spotters/addSpotter";
	}
	
	@PostMapping("/save")
	public String saveDish(Spotter  spotter) {
		spotterService.save(spotter );
		return "redirect:/spotters/all";
	}

}
