package com.yc.story.web;

import java.util.List;

import javax.annotation.Resource;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.yc.story.Biz.BizException;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.UserBiz;
import com.yc.story.bean.StCategory;
import com.yc.story.bean.StUser;
import com.yc.story.vo.Result;

@Controller
@SessionAttributes("loginedUser")
public class UserServlet {
	
	
	@Resource
	private CategoryBiz cbiz;
	
	@Resource
	private UserBiz ubiz;
	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	

	
	@RequestMapping("userLogin")
	@ResponseBody
	public Result userLogin(StUser user, Model model) {	
		try {
			StUser u = ubiz.findUser(user);
			if( u!= null) {
				if(u.getLevel() == 2 || u.getLevel() == 1) {
					model.addAttribute("loginedUser",u);
					System.out.println(u);
					return new Result(1,"登录成功");
				}
				
				return new Result(0, "用户名或密码错误");
			}
			
			return new Result(0, "用户名或密码错误");		
		}catch(BizException e) {
			return new Result(0,e.getMessage());
		}catch(RuntimeException e) {
			e.printStackTrace();
			return new Result(0, "业务繁忙,请稍后再试");
		}
		
	}
	
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	
}
