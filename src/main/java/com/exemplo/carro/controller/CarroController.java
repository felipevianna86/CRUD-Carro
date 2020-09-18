package com.exemplo.carro.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.exemplo.carro.model.Carro;
import com.exemplo.carro.service.CarroService;

@Controller 
public class CarroController {
	
	@Autowired
	private CarroService service; 
	
	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("lista_carros");
		mv.addObject("carros", service.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	public ModelAndView add(Carro carro) {
		
		ModelAndView mv = new ModelAndView("/add_carro");
		mv.addObject("carro", carro);
		
		return mv;
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		return add(service.findOne(id));
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}
	
	
	@PostMapping("/save")
	public ModelAndView save(@Valid Carro carro, BindingResult result) {
		
		if(result.hasErrors()) {
			return add(carro);
		}
		
		service.save(carro);
		
		return findAll();
	}
	
}
