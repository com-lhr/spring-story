package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.yc.story.bean.StUser;
import com.yc.story.bean.StUserExample;
import com.yc.story.dao.StUserMapper;

@Service
public class UserBiz {
	
	@Resource
	private StUserMapper sum;
	
	@Autowired
    private BCryptPasswordEncoder passwordEncoder;
	
	/*
	 * 
    k1是明文密码，k2为加密过的密码，返回true或false
    passwordEncoder.matches(k1,k2);
		
           没什么好说的 传入明文密码，返回加密后密码
    passwordEncoder.encode(password);
	 */
	
	public StUser findUser(StUser user) throws com.yc.story.Biz.BizException {
			
		StUserExample sue = null;
		if(user != null) {
				sue = new StUserExample();
				String s= passwordEncoder.encode(user.getuPwd());
				
//				System.out.println(passwordEncoder.matches("123456","$2a$10$mml8hdNTOCIfIpwCu63RUuWxecJFuuX/8Cc5WvANwfZWOTYKon9Oe"));
//				System.out.println(s);																	
				sue.createCriteria().andUNameEqualTo(user.getuName()).andUPwdEqualTo(user.getuPwd());//*
				List<StUser> list = sum.selectByExample(sue);
				if(list.size() == 0) {
					throw new BizException("用户名或密码错误");
				}
				return list.get(0);//*
				//加密验证
//				for(StUser suer :list) {				
//					boolean istrue = passwordEncoder.matches(user.getuPwd(),suer.getuPwd());
//					if(istrue) {
//						return suer;
//					}else{
//						continue;
//					}				
//				}				
//				throw new BizException("用户名或密码错误");
			}
		throw new BizException("用户名或密码错误");
				
	}

}