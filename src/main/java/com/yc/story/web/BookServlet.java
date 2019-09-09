package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StCategory;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StUser;

@Controller
public class BookServlet {
	
	@Resource
	private CategoryBiz cbiz;
	@Resource
	private BookBiz bbiz;

	
	@Resource
	private CommentBiz cobiz;

	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allRedisCategory();
	}
	
	@RequestMapping("artCategory")
	public String ArticleCategory(Model model,int id,@RequestParam(defaultValue="1")int page) {
		//分类页面右边的新书上架功能 根据该类别和时间排序找出十本小说
		/*Integer aid = Integer.valueOf(id);*/
		model.addAttribute("category_pagebooks", bbiz.findByCategory(id, page));
		model.addAttribute("category_newbooks", bbiz.findByCategoryAndTime(id));
		return "index_article";
	}
	
	@RequestMapping("pageartCategory")
	@ResponseBody
	public List<StBook> pageartCategory(Model model,int id,@RequestParam(defaultValue="1")int page) {
		model.addAttribute("bid",bbiz.findByCategory(id, page));
		return bbiz.findByCategory(id, page);
	}
	
	@RequestMapping("detail")
	public String Detail(Integer id,Model model) {
		model.addAttribute("detailBook", bbiz.findDetail(id));

		model.addAttribute("comments", cobiz.findCommentByBid(id));
		

		return "detail";
	}
	
	@RequestMapping("pagecount")
	@ResponseBody
	public String pageCount(int id) {
		int count = 1;
		if(bbiz.bookcount(id) > 25) {
		count = bbiz.bookcount(id)%25==0 ? bbiz.bookcount(id)/25 :
				(bbiz.bookcount(id)%25) + 1;
		}				
		return count+"";
	}
	@RequestMapping("doSearch")
	public String showSearch(String name,Model model) {
		model.addAttribute("searchBook", bbiz.findBookLikeName(name));		
		return "showSearch";
		
	}
	
	//添加收藏夹
	@GetMapping("addColl")
	@ResponseBody
	public int addCollection(@SessionAttribute(name="loginedUser",required=false) StUser user,
			int bid,Model model){
		if(user==null){
			return 0;
		}
		return bbiz.addCollection(user,bid);
	}


	@ModelAttribute("bookList")
	public List<Object> findColl(@SessionAttribute(name="loginedUser",required=false) StUser user){
		if(user==null){
			return null;
		}else{
			return bbiz.query(user.getId());
		}
	}
	
}
