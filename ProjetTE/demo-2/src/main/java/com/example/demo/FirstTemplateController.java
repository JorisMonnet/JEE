package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hellotemplate")
public class FirstTemplateController {

	@GetMapping
	public String hello(Model model) {
		
		HelloWorld hw = new HelloWorld("hello le monde");
		
		model.addAttribute("test",hw);
		
		return "test";
	}
	
	
}
