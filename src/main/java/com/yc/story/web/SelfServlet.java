package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.yc.story.Biz.CollectionBiz;
import com.yc.story.Biz.GoodsBiz;
import com.yc.story.Biz.OrderBiz;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StGoods;
import com.yc.story.bean.StUser;

@Controller
public class SelfServlet {

	@Resource
	private CollectionBiz cbiz;

	@Resource
	private GoodsBiz gbiz;
	
	@Resource
	private OrderBiz obiz;
	
	//购买小说（整本）
	@GetMapping("buy")
	@ResponseBody
	public int buy(@SessionAttribute(name="loginedUser",required=false) StUser user,int id,int money){
		return cbiz.buy(user, id, money);
	}
	
	//判断书籍是否被购买
	@GetMapping("judge")
	@ResponseBody
	public List<StCollection> judge(@SessionAttribute(name="loginedUser",required=false) StUser user,int id){
		if(null==user){
			return null;
		}else{
			return cbiz.queryOne(user, id);
		}
	}
	
	//获取收藏夹
	@GetMapping("collect")
	public String collect(@SessionAttribute(name="loginedUser",required=false) StUser user,
			@RequestParam(defaultValue="1") int page,Model model){
	
		// 查询收藏夹
		List<StCollection> query = cbiz.query(user,page);
		System.out.println(query);
		model.addAttribute("count",cbiz.queryAll(user));
		model.addAttribute("coList",query);
		// 查询订单
		model.addAttribute("taList",obiz.queryOrder(user));
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
