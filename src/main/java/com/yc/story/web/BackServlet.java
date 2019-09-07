package com.yc.story.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackServlet {

	@GetMapping("toback")
	public String toback(){
		return "back/index";
	}
	
	@GetMapping("toorder")
	public String toorder(){
		return "back/order";
	}
	
	@GetMapping("togoods")
	public String togoods(){
		return "back/goods";
	}
	
	@GetMapping("tolog")
	public String tolog(){
		return "back/log";
	}
	
	@GetMapping("toadd")
	public String toadd(){
		return "back/log_add";
	}
	
	@GetMapping("toupload")
	public String toupload(){
		return "back/storyupload";
	}
}
