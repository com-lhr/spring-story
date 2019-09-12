package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.story.Biz.LogBiz;
import com.yc.story.bean.StNote;

@Controller
public class LogServlet {

	@Resource
	private LogBiz lbiz;
	
	@GetMapping("querylog")
	@ResponseBody
	public List<StNote> query(){
		return lbiz.queryAll();
	}
	
}
