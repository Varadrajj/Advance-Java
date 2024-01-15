package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/login")
public class HelloController {
	@GetMapping("/hello")
	public ModelAndView sayHello() {
		String s="Hello From My Controller";
		return new ModelAndView("myhello","msg",s);
			
	}
	
	@GetMapping("/test")
	public String method(Model model) {
		model.addAttribute("msg","Welcome");
		model.addAttribute("num1",10);
		model.addAttribute("num2",20);
		return "testaddition";
	}
}
