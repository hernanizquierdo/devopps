package au.com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	private final SubjectRepository subjectRepository;

	public WebController(SubjectRepository subjectRepository) {
		this.subjectRepository = subjectRepository;
	}

	@GetMapping("/web/subjects")
	public String greeting(
			@RequestParam(name = "name", required = false, defaultValue = "DevOpps - Subjects List ") String name,
			@RequestParam(name = "auth", required = true) String auth,
			Model model) {
		if (auth != null && !auth.trim().isEmpty()){
			model.addAttribute("name", name);
			model.addAttribute("subjects", subjectRepository.findAll());
			return "subjects";
		}
		return "form";
		
	}

}
