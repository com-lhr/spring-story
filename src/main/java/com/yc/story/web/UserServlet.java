package com.yc.story.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.yc.story.Biz.BizException;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.UserBiz;
import com.yc.story.bean.StCategory;
import com.yc.story.bean.StUser;
import com.yc.story.util.Code;
import com.yc.story.util.MailServiceImpl;
import com.yc.story.vo.Result;

@Controller
@SessionAttributes("loginedUser")
public class UserServlet {
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	@Resource
	private MailServiceImpl msi;
	
	@Resource
	private CategoryBiz cbiz;
	
	@Resource
	private UserBiz ubiz;
	
	@ModelAttribute("cList")
	public List<StCategory> init(){
		return cbiz.allCategory();
	}
	
	//用户修改密码
	@PostMapping("forgetpass")
	@ResponseBody
	public Result forgetpass(StUser user) {
		try {
			user.setuPwd(passwordEncoder.encode(user.getuPwd()));
			int i = ubiz.updata(user);
			if(i == 0) {
				System.out.println("失败");
				return new Result(0,"密码修改失败");				
			}else {
				System.out.println("成功");
				return new Result(1,"密码修改成功");
			}			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败");
			return new Result(0,"密码修改失败");
		}
	}
	
	//用户注册
	@PostMapping("register")
	@ResponseBody
	public Result register(StUser user , @RequestParam("img") MultipartFile file) {
		user.setLevel(2);
		System.out.println(user);
		user.setuPwd(passwordEncoder.encode(user.getuPwd()));
		
		//设置文件名
		String filename = System.currentTimeMillis()+new Random().nextInt(1000)+file.getOriginalFilename();
		try {
			File f = new File("/e:/story/userImages",filename);		
			file.transferTo(f);
			user.setuImage("userImages/"+filename);
			int i= ubiz.register(user);
			if( i == 0) {
				return new Result(0 , "注册失败，请稍后再试");
			}else {
				return new Result(1,"注册成功,请立即登录！");
			}			
		} catch (IllegalStateException e) {			
			e.printStackTrace();
			return new Result(0 , "注册失败，请稍后再试");
		} catch (IOException e) {			
			e.printStackTrace();
			return new Result(0 , "注册失败，请稍后再试");
		}
		
		
	}

	//用户登录
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
	
	//邮箱发送验证码
	@RequestMapping("mail")
	@ResponseBody
	public Result testSendMail( String uEmail,Model model) {
		//产生一个6位数的验证码
		String a=Code.createData() ;	
		try {
			msi.sendSimpleMail(uEmail, "验证邮件", "这是一封验证邮件，你的验证码为"+a+",为保障你的信息安全，切勿让其他人观看");
			model.addAttribute("code", a);
			return new Result(0,"发送成功,请注意接收信息",a);
		}catch(Exception e) {
			e.printStackTrace();		
			return new Result(-1,"发送失败，请稍后再试");
		}
		
	}
	//所有用户
		@ResponseBody
		@RequestMapping("user1")
		public List<StUser> allUser(){
			return  ubiz.findUserBy(null);
		}
		
		@PostMapping("deleteUser")
		@ResponseBody
		public Result deleteuser(String iArray) {
			String[] arr = iArray.split(",");
			try {
				for(int i=0;i<arr.length;i++) {
					ubiz.deleteUserById(Integer.parseInt(arr[i]));
				}
				return new Result(1,"删除成功");
			}catch(Exception e) {
				e.printStackTrace();
				return  new Result(0,"删除用户失败");
			}
		}
	
	
		//根据条件查询出用户
		@ResponseBody
		@RequestMapping("condition")
		public List<StUser> findUserByUser(StUser user,@RequestParam("type") String type){
			if(type.equals("管理员")) {
				user.setLevel(0);
			}else if(type.equals("用户")) {
				user.setLevel(2);
			}else if(type.equals("作者")) {
				user.setLevel(1);
			}else {
				user.setLevel(null);
			}
			return ubiz.findUserBy(user);
		}
	
	@GetMapping("spend")
	@ResponseBody
	public int spend(@SessionAttribute(name="loginedUser",required=false) StUser user){
	
		if(user==null){
			System.out.println("=====user========");
			return -1;
		}else{
			return ubiz.koujif(user);
		}
	}

	@RequestMapping("topass")
	public String toPass() {
		return "pass";
	}
		
	@RequestMapping("tologin")
	public String toLogin() {
		return "login";
	}
	
	@RequestMapping("toregister")
	public String toRegister() {
		return "register";
	}
	
}
