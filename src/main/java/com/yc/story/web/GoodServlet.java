package com.yc.story.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.story.Biz.GoodsBiz;
import com.yc.story.bean.StGoods;

@Controller
public class GoodServlet {

	@Resource
	private GoodsBiz gbiz;
	
	@GetMapping("addGoods")
	@ResponseBody
	public int add(String name,String kind,String price,String cost ){
		StGoods sg = new StGoods();
		sg.setgName(name);
		sg.setgDesc(kind);
		sg.setgPrice(Float.parseFloat(price));
		sg.setgCost(Double.parseDouble(cost));
		
		return gbiz.add(sg);
	}
	
}
