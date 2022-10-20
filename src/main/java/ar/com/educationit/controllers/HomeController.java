package ar.com.educationit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

	// GET > http://localhost:8080
	@GetMapping(value = {"/","/home"})
	public String home(Model model) {
		
		//quiero ir a la pagina home.html
		return "home";
	}
	
	
}
