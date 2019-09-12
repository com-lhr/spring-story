package com.yc.story.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.yc.story.Biz.BookBiz;
import com.yc.story.bean.StBook;

@RestController
public class SearchBookServlet {
	@Autowired
	private BookBiz bbzi;
	@GetMapping("searchbookname")
	public List<StBook> searchbook(String name) {
		if(name==null||name=="") {
			name = "";
		}
		return bbzi.findPageBookLikeName(name);	
	}
	
	
}
