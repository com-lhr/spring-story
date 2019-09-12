package com.yc.story.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.google.gson.Gson;
import com.yc.story.vo.Result;


public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		if(request.getSession().getAttribute("loginedUser") == null) {
			if(request.getHeader("X-Requested-With") == null) {
				response.sendRedirect("tologin");
			}else {
				Gson gson = new Gson();
				String json= gson.toJson(new Result(-2,"请先登录系统"));
				response.setContentType("application/json;charset=UTF-8");
				response.getWriter().append(json);
			}			
			return false;
		}else {
			return true;
		}
	}

	
	
}
