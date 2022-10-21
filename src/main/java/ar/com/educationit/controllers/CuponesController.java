package ar.com.educationit.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.com.educationit.domain.Cupon;
import ar.com.educationit.enums.CuponKeysEnum;
import ar.com.educationit.enums.CuponViewEnum;
import ar.com.educationit.services.CuponService;

@Controller
@RequestMapping("/cupon")
public class CuponesController {

	@Autowired
	private CuponService cuponService;
	
	@GetMapping("/list")
	public String list(Model model) {

		Set<Cupon> cupones = new HashSet<>(this.cuponService.buscarTodos());// this.cuponService.buscarTodos().stream().collect(Collectors.toSet());

		model.addAttribute(CuponKeysEnum.CUPONES.getKey(), cupones);

		return CuponViewEnum.LIST.getView();
	}

	@GetMapping("/new")
	public ModelAndView newCupon() {
		
		Cupon newCupon = new Cupon();
		
		ModelAndView model = new ModelAndView(CuponViewEnum.NEW.getView());
		
		model.addObject(CuponKeysEnum.CUPON.getKey(), newCupon);
		
		return model;
	}
	
	@PostMapping("/new")
	public String save(
			@Validated
			@ModelAttribute(name = "CUPON") Cupon cupon,
			BindingResult resul
			) {
		
		//verifico si hay errores
		if(resul.hasErrors()) {
			return CuponViewEnum.NEW.getView();	
		}
				
		if(cupon.getFechaVigenciaHasta() != null) {
			//validar que la fecha desde no sea mayor!!			
		}
		
		this.cuponService.crear(cupon);
		
		return CuponViewEnum.LIST_REDIRECT.getView();
	}
	
	@RequestMapping("/edit/{id}")
	public String edit( @PathVariable(name="id")
						Long id,
						Model model) {
		
		Cupon cupon = this.cuponService.buscar(id);
		
		model.addAttribute(CuponKeysEnum.CUPON.getKey(), cupon);
		
		return CuponViewEnum.EDIT.getView();
	}
	
	@PostMapping("/edit")
	public String edit(
			@Validated
			@ModelAttribute(name = "CUPON") Cupon cupon,
			BindingResult resul
			) {
		
		//verifico si hay errores
		if(resul.hasErrors()) {
			return CuponViewEnum.EDIT.getView();	
		}
		
		this.cuponService.crear(cupon);
		
		return CuponViewEnum.LIST_REDIRECT.getView();
	}
	
	@RequestMapping("/delete")
	public String delete(
			@RequestParam(name = "id", required = true) Long id
			) {
		
		this.cuponService.eliminar(id);
		
		return CuponViewEnum.LIST_REDIRECT.getView();
	}
}
