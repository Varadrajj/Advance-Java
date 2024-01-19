package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.model.MyUser;
import com.demo.service.LoginService;

@Controller
@RequestMapping("/login")
public class MyLoginController {
	
	@Autowired
	private LoginService lservice;
	
	@GetMapping("/")
	public String showForm() {
		return "login";
	}
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam String uname, @RequestParam String password,HttpSession session) {
		MyUser u=lservice.checkUser(uname,password);
		if(u!=null) {
			session.setAttribute("user", u);
			return new ModelAndView("redirect:/employee/employees");
//			return new ModelAndView("sucess","msg","Successfully logged In..!!");
		}else {
			return new ModelAndView("redirect:/login/");
//			return new ModelAndView("sucess","msg","Unsuccessfull Login");
			
		}
	}

}
