package com.ts.studentcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ts.dto.Student;
import com.ts.service.StudentService;

@Controller
public class StudentController {
	
	@Autowired
private StudentService studentService;
	
	@GetMapping("admissionRequest")
	public ModelAndView requestForm() {
		ModelAndView model = new ModelAndView("registration");
		return model;
	}
	/*
	@PostMapping("registerController")
	public ModelAndView registration(@RequestParam("id") String id,@RequestParam("sname") String sname,@RequestParam("fees") String fees) {
		ModelAndView model = new ModelAndView("success");
		model.addObject("id",id);
		model.addObject("sname",sname);
		model.addObject("fees",fees);
		return model;
	}
	@PostMapping("registerController")
	public ModelAndView registration(@RequestParam Map<String,String> mapReq) {
		ModelAndView model = new ModelAndView("success");
		model.addObject("id",mapReq.get("id"));
		model.addObject("sname",mapReq.get("sname"));
		model.addObject("fees",mapReq.get("fees"));
		return model;
	}*/
	@PostMapping("registerController")
	public ModelAndView registration(@ModelAttribute("student") Student student) {
		//System.out.println(student);
		studentService.studentRegistration(student);
		ModelAndView model = new ModelAndView("success");		
		return model;
	}
	@GetMapping("listAllStudents")
	public ModelAndView listStudents() {
		
		List<Student> list = studentService.listStudents();
		ModelAndView model = new ModelAndView("liststudents");	
		model.addObject("studentsList",list);
		return model;
	}
	@GetMapping("getStudent")
	public ModelAndView listStudent() {				
		ModelAndView model = new ModelAndView("getstudentid");			
		return model;
	}
	@PostMapping("printStudent")
	public ModelAndView listStudent(@RequestParam("id") int sid) {		
		Student student = studentService.listStudent(sid);
		ModelAndView model = new ModelAndView("show");	
		model.addObject("studentList",student);
		return model;
	}
}




