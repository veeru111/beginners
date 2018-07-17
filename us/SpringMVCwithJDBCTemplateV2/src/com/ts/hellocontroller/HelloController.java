package com.ts.hellocontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@Autowired
	private Wish wish;
	

	public Wish getWish() {
		return wish;
	}

	public void setWish(Wish wish) {
		this.wish = wish;
	}

	@RequestMapping("/hello")
	public ModelAndView helloWorld() {

		ModelAndView model = new ModelAndView("hello");
		model.addObject("msg","hello world");

		return model;
	}
	
	@RequestMapping("/hi")
	public ModelAndView hiWorld() {

		ModelAndView model = new ModelAndView("hi");
		wish.showWish();
		model.addObject("msg","hi world");

		return model;
	}
}