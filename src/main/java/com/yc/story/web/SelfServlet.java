package com.yc.story.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.yc.story.Biz.CollectionBiz;
import com.yc.story.Biz.GoodsBiz;
import com.yc.story.Biz.OrderBiz;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StGoods;
import com.yc.story.bean.StOrder;
import com.yc.story.bean.StUser;
import com.yc.story.util.AlipayConfig;

@Controller
public class SelfServlet {

	@Resource
	private CollectionBiz cbiz;

	@Resource
	private GoodsBiz gbiz;
	
	//获取收藏夹
	@GetMapping("collect")
	public String collect(@SessionAttribute(name="loginedUser",required=false) StUser user,
			@RequestParam(defaultValue="1") int page,Model model){
	
		List<StCollection> query = cbiz.query(user,page);
		System.out.println(query);
		model.addAttribute("count",cbiz.queryAll(user));
		model.addAttribute("coList",query);
		return "self";
	}
	
	//获取收藏夹
	@GetMapping("collectPage")
	@ResponseBody
	public List<StCollection> collect1(@SessionAttribute(name="loginedUser",required=false) StUser user,
			@RequestParam(defaultValue="1") int page,Model model){
		
		model.addAttribute("count",cbiz.queryAll(user));
		List<StCollection> query = cbiz.query(user,page);
		return query;
	}
	
	//取消收藏
	@GetMapping("cancel")
	@ResponseBody
	public List<StCollection> cancel(@SessionAttribute(name="loginedUser",required=false) StUser user,
			String bid, Model model){
		
		cbiz.del(user, Integer.parseInt(bid));
		return collect1(user, 1,model);
	}
	
	// 商品展示
	@ModelAttribute("gList")
	public List<StGoods> queryGoods(){
		return gbiz.query();
	}
}
