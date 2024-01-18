package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUSer;
import com.demo.service.MyUserService;
import com.demo.service.MyUserServiceImpl;

@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	MyUserService uservice ;
	@GetMapping("/")
	public String showUser() {
		System.out.println("Welcome");
		return "login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validateUser(@RequestParam String uname, @RequestParam String passwd, HttpSession sess) {
		MyUSer u = uservice.checkUser(uname, passwd);
		if(u != null) {
			sess.setAttribute("user", u);
			return new ModelAndView("redirect:/animal/getAnimals");
		}
		return new ModelAndView("unsuccess", "msg", "UnSuccessful Login");
	}
}
