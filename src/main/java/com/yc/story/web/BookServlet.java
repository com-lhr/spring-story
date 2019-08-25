package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.bean.StCategory;

@Controller
public class BookServlet {
	
	@Resource
	private CategoryBiz cbiz;
	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	@RequestMapping("artCategory")
	public String ArticleCategory() {
		return "index_article";
	}

}
