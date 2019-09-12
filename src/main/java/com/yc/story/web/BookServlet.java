package com.yc.story.web;

import java.util.ArrayList;
import java.util.Date;
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

import org.springframework.web.bind.annotation.SessionAttributes;


import com.github.pagehelper.PageHelper;
import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StCategory;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StUser;

@Controller
@SessionAttributes(types={java.util.List.class},names= {"chapter"})
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
		model.addAttribute("book_readCnt", bbiz.findBookOrderByReadCnt());
		model.addAttribute("book_readcount", bbiz.findBookOrderByCount());
		return "index_article";
	}
	
	@RequestMapping("pageartCategory")
	@ResponseBody
	public List<StBook> pageartCategory(Model model,int id,@RequestParam(defaultValue="1")int page) {
		model.addAttribute("bid",bbiz.findByCategory(id, page));
		return bbiz.findByCategory(id, page);
	}
	
	@RequestMapping("detail")
	public String Detail(@RequestParam(defaultValue="1") int page1 , Integer id,Model model,@RequestParam(defaultValue="1") int page2) {
		StBook book = bbiz.findDetail(id);
		model.addAttribute("detailBook", book);		
		PageHelper.startPage(page2,5);
		
		//第一次目录加载
		List<String> list1 =  book.getChapter();
		model.addAttribute("chapter", list1);
		List<String> list2 = new ArrayList<String>();
		int start = (page1-1)*20;
		int end = page1*20 >list1.size() ? list1.size() : page1*20;
		for(int i = start;i<end;i++) {
			list2.add(list1.get(i));
		}				
		model.addAttribute("chapter1", list2);
		model.addAttribute("comments", cobiz.findCommentByBid(id));
		model.addAttribute("category_newbooks", bbiz.findByCategoryAndTime(book.getbCategory()));
		model.addAttribute("book_readCnt", bbiz.findBookOrderByReadCnt());
		model.addAttribute("book_readcount", bbiz.findBookOrderByCount());
		return "detail";
	}
	

	//目录分页
	@RequestMapping("sections")
	@ResponseBody
	public List<String> section(@RequestParam(defaultValue="1") int page1 ,@ModelAttribute(value="chapter")List<String> list1){
		List<String> list2 = new ArrayList<String>();
		int start = (page1-1)*20;
		int end = page1*20 >list1.size() ? list1.size() : page1*20;
		for(int i = start;i<end;i++) {
			list2.add(list1.get(i));
		}		
		return list2;
	}
	
	@RequestMapping("article")
	public String article(Integer id ,Model model , String character,@ModelAttribute(value="chapter")List<String> list1) {
		int index = list1.indexOf(character);
		System.out.println(index);
		StBook book = bbiz.findDetail(id);
		book.setbReadcnt((book.getbReadcnt() == null ? 0 : book.getbReadcnt())+1);
		bbiz.updateReadCnt(book);
		String last = null,next = null;
		String str = null;
		if("到头了".equals(character) ) {
			last = "到头了";
			next = list1.get(index+1);	
			str = "没有了";
		}else if("到底了".equals(character) ) {
			next = "到底了";
			last = list1.get(index-1);
			str = "没有了";
		}else {
			str = bbiz.chapterDeatil(id, character.replace(" ", ""));
		}
		
		if(index == 0) {
			last = "到头了";
			next = list1.get(index+1);	
		}else if(index == (list1.size()-1)) {
			next = "到底了";
			last = list1.get(index-1);
		}else {
			last = list1.get(index-1);
			next = list1.get(index+1);			
		}
		
		model.addAttribute("last", last);
		model.addAttribute("next", next);
		
		model.addAttribute("chapterDeatil", str);
		model.addAttribute("detailBook", book);
		model.addAttribute("comments", cobiz.findCommentByBid(id));
		return "article";
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
		model.addAttribute("book_readCnt", bbiz.findBookOrderByReadCnt());
		model.addAttribute("book_readcount", bbiz.findBookOrderByCount());
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
			List<Object> list = new ArrayList<>();
			list.add(-1);
			return list;
		}else{
			return bbiz.query(user.getId());
		}
	}
	
	@RequestMapping("CompositeQueryBook")
	@ResponseBody
	public List<StBook> CompositeQueryBook(String id,String bName,
			String stCategory,String author){
		
		return bbiz.CompositeQueryBook(id, bName, stCategory,author);
	}
}
