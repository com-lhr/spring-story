package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.story.Biz.OrderBiz;
import com.yc.story.bean.StOrder;

@Controller
public class OrderServlet {

	@Resource
	private OrderBiz obiz;
	
	@GetMapping("order")
	@ResponseBody
	public List<StOrder> query(){
		return obiz.queryAll();
	}
	
	
}
