package com.yc.story.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.UserBiz;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StBook2;
import com.yc.story.bean.StBookExample;
import com.yc.story.bean.StCategory;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StBookMapper;

@Controller
public class IndexServlet {
	@Autowired
    private RedisTemplate<Object,Object> template;
	@Autowired
	private RedisTemplate<String, ?> redisTemplate;
	@Resource
	private CategoryBiz cbiz;
	@Resource
	private BookBiz bbiz;
	@Resource 
	private UserBiz ubiz;
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allRedisCategory();
	}
	
	
	
	@RequestMapping("toindex")
	public String toIndex(Model model) {
		//编者推荐推荐
		model.addAttribute("recommendationList",bbiz.findRedisRecommendation());
		
		model.addAttribute("authorList", ubiz.redisFindAuthor());
		//首页的最新上架功能 根据时间排序找出最新的十本小说
		model.addAttribute("newbook", bbiz.newbook());
		return "index";
	}
	@RequestMapping("authorDetail")
	public String toAuthorDetail(String name,int id,Model model) {
		model.addAttribute("author", bbiz.findAuthor(id));
		model.addAttribute("bookofauthor", bbiz.findBookByAuthor(name));
		return "authordetail";		
	}
	
	/*@RequestMapping("toTest")
	public String test() {
		Map<String, String> m = new HashMap<>();
		m.put("1", "玄幻小说");
		m.put("2", "科幻小说");
		m.put("3", "都市小说");
		m.put("4", "穿越小说");
		m.put("5", "修真小说");
		m.put("6", "网游小说");
		redisTemplate.opsForHash().putAll("category", m);
		Map<String,StUser> m1 = new HashMap<>();
		List<StUser> users = ubiz.findAuthor();
		for(StUser u :users ) {
			m1.put(u.getId()+"", u);
		}
		template.opsForHash().putAll("Author", m1);
		Map<String,StBook2> m3 = new HashMap<>();
		StBookExample bookExample = new StBookExample();
		bookExample.createCriteria().andBNameEqualTo("斗罗大陆");
		List<StBook> s = bookMapper.selectByExample(bookExample);
		for(StBook u :s ) {
			StBook2 s2 = new StBook2();
			s2.setId(u.getId());
			s2.setbFace(u.getbFace());			
			s2.setbName(u.getbName());
			m3.put(s2.getId()+"", s2);
		}
		template.opsForHash().putAll("StRecommendations", m3);
		return "test";
	}*/
}
