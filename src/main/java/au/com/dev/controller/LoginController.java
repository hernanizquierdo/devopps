package au.com.dev.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import au.com.dev.dto.User;

@Controller
public class LoginController implements WebMvcConfigurer {

	private final UserRepository userRepository;
	
	public LoginController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/subjects").setViewName("subjects");
	}

//	@GetMapping("/")
//	public String showForm(UserForm personForm) {
//		return "form";
//	}
	@RequestMapping(value = "/", method = RequestMethod.GET) 
	public String showForm(@ModelAttribute("personForm") User user, BindingResult result, Model model) {
		model.addAttribute("user",  new User());
		return "form";
	}
	

	@PostMapping("/")
	public String checkPersonInfo(@Valid User user, BindingResult bindingResult, Model model) {
		String error = "";
		String page = "form";
		if (user.getUsername() != null && !user.getUsername().trim().isEmpty() &&
				user.getPassword() != null && !user.getPassword().trim().isEmpty()){
			User u = userRepository.validateLogin(user.getUsername(), user.getPassword());
			if (u != null){
				page =  "redirect:/web/subjects?auth=12345";
			}else{
				error = "Username/Password incorrect";
			}
		}else{
			error = "Username/Password incorrect";
		}
		if (bindingResult.hasErrors()) {
			
		}
		page =  "redirect:/web/subjects?auth=12345";
		
		model.addAttribute("error",  error);
		return page;
	}
	
	

}
