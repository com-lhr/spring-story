package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.bean.StCategory;

@Controller
public class BookServlet {
	
	@Resource
	private CategoryBiz cbiz;
	@Resource
	private BookBiz bbiz;
	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	@RequestMapping("artCategory")
	public String ArticleCategory(Model model,String id) {
		//分类页面右边的新书上架功能 根据该类别和时间排序找出十本小说
		Integer aid = Integer.valueOf(id);
		model.addAttribute("category_newbooks", bbiz.findByCateforyAndTime(aid));
		return "index_article";
	}

}
