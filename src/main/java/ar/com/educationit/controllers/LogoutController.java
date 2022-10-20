package ar.com.educationit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

	
	@GetMapping()
	public String list(Model model) {
		
		return "home"; // resources/templates/list,html
	}
}
