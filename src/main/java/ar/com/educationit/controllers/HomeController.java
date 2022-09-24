package ar.com.educationit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// GET > http://localhost:8080
	@GetMapping(value = "/")
	public String home() {
		//quiero ir a la pagina home.html
		return "home";
	}
	
	public String alert() {
		return "bla";
	}
	
	public void metodo2() {
		
	}
	
	public void metodo3() {
		
	}
	
}
