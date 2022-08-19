package lt.codeacademy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		//model.addAttribute("hello", "Spotter Database");
		return "/spotters/spottersList";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Spotter spotter) {
		return "/spotters/addSpotter";
	}
	
	@PostMapping("/save")
	public String saveDish(Spotter  spotter) {
		spotterService.save(spotter );
		return "redirect:/spotters";
	}
	 @GetMapping("/edit/{id}")
	    public String showUpdateSpotter(@PathVariable("id") int id, Model model) {
		 	Spotter spotter = spotterService.getById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
	        model.addAttribute("spotter", spotter);
	        return "/spotters/updateSpotter";
	    }
	 @PostMapping("/update/{id}")
	    public String updateUser(@PathVariable("id") int id,  Spotter spotter, 
	      BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            spotter.setId(id);
	            return "/spotters/updateSpotter";
	        }           
	        spotterService.save(spotter); 
	        model.addAttribute("spotters", spotterService.getAll());
	       // model.addAttribute("hello", "Spotter Database");
	        return "/spotters/spottersList";
	    }
	 
	 @GetMapping("/delete/{id}")
	    public String deleteAuthor(@PathVariable("id") int id, Model model) {
		 Spotter spotter = spotterService.getById(id)
	          .orElseThrow(() -> new IllegalArgumentException("Invalid author Id:" + id));
	        spotterService.deleteSpotter(spotter);
	        model.addAttribute("spotters", spotterService.getAll());
	        return "/spotters/spottersList";
	    }

}
