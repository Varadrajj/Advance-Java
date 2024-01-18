package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.Animal;
import com.demo.model.MyUSer;
import com.demo.service.AnimalService;

@Controller
@RequestMapping("/animal")
public class AnimalController {
	@Autowired
	private AnimalService aservice;
	
	@GetMapping("/getAnimals")
	public ModelAndView getAnimals(HttpSession session) {
		MyUSer u = (MyUSer) session.getAttribute("user");
		if(u != null) {
			System.out.println(u);
			List<Animal> alist = aservice.getAllAnimals();
			return new ModelAndView("displayanimal","alist",alist);
		}
		return new ModelAndView("redirect:/login/");
	}
	
	@GetMapping("/edit/{id}")
	public ModelAndView editanimal(@PathVariable int id) {
		Animal a = aservice.getById(id);
		return new ModelAndView("editanimal","a",a);
	}
	@PostMapping("/updateanimal")
	public ModelAndView updateAnimal(@RequestParam int id, @RequestParam String name, @RequestParam int age) {
		aservice.updateAni(new Animal(id, name, age));
		return new ModelAndView("redirect:/animal/getAnimals");
	}
}
