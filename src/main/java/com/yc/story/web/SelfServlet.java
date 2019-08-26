package com.yc.story.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.story.Biz.CollectionBiz;
import com.yc.story.bean.StUser;

@Controller
public class SelfServlet {

	@Resource
	private CollectionBiz cb;
	
	@GetMapping("collect")
	public String collect(@SessionAttribute StUser user,Model model){
		user.setId(1);
		model.addAttribute("cList",cb.query(user));
		return "self";
	}
	
}
