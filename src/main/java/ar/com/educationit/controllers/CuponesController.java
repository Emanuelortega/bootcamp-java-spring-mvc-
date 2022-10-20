package ar.com.educationit.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.com.educationit.domain.Cupon;
import ar.com.educationit.domain.CuponViewEnum;
import ar.com.educationit.services.CuponService;

@Controller
@RequestMapping("/cupon")
public class CuponesController {
	
	@Autowired
	private CuponService cuponService;
	
	@GetMapping("/list")
	public String list(Model model) {
		
		Set<Cupon> cupones = new HashSet<>(this.cuponService.buscarTodos());//stream().collect(Collectors.toSet());
		
		model.addAttribute("cupones", cupones);
		
		return CuponViewEnum.LIST.getView(); 
	}
}
//1:56 clase: 76