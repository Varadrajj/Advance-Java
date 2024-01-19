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

import com.demo.model.Employee;
import com.demo.model.MyUser;
import com.demo.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService eservice;
	
	@GetMapping("/employees")
	public ModelAndView getEmployees(HttpSession session) {
		MyUser u=(MyUser) session.getAttribute("user");
		if(u!=null) {
			List<Employee> elist=eservice.getEmployees();
			return new ModelAndView("displayemployees","elist",elist);
		}else {
			return new ModelAndView("redirect:/login/");
		}
		
	}
	
	@GetMapping("/addnewemployee")
	public String displayForm(HttpSession session) {
		MyUser u= (MyUser) session.getAttribute("user");
		if(u!=null) {
			return "addnewemployee";
		}else {
			return ("redirect:/login/");
		}
	}
	
	
	@PostMapping("/insertemployee")
	public ModelAndView addemployee(@RequestParam int eid, @RequestParam String ename,@RequestParam double sal, @RequestParam String dept) {
		Employee e=new Employee(eid,ename,sal,dept);
		eservice.addemployee(e);
		return new ModelAndView ("redirect:/employee/employees");
		
	}
	
	@GetMapping("/edit/{eid}")
	public ModelAndView getById(@PathVariable  int eid) {
		Employee e=eservice.getById(eid);
		return new ModelAndView("editemployee","e",e);
	}
	
	@PostMapping("/updateemployee")
	public ModelAndView modifyEmployee(@RequestParam int eid, @RequestParam String ename,@RequestParam double sal, @RequestParam String dept) {
		Employee e= new Employee(eid,ename,sal,dept);
		eservice.modifyEmployee(e);
		return new ModelAndView("redirect:/employee/employees");
	}
	
	@GetMapping("delete/{eid}")
	public ModelAndView deleteById(@PathVariable int eid) {
		eservice.deleteById(eid);
		return new ModelAndView("redirect:/employee/employees");
	}

}
