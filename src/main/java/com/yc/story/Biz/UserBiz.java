package com.yc.story.Biz;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StUser;
import com.yc.story.bean.StUserExample;
import com.yc.story.dao.StUserMapper;

@Service
public class UserBiz {
	
	@Resource
	private StUserMapper sum;
	@Autowired
    private RedisTemplate<Object,Object> template;
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
				System.out.println(s);
//				System.out.println(passwordEncoder.matches("123456","$2a$10$mml8hdNTOCIfIpwCu63RUuWxecJFuuX/8Cc5WvANwfZWOTYKon9Oe"));
//				System.out.println(s);																	
				sue.createCriteria().andUNameEqualTo(user.getuName());//.andUPwdEqualTo(user.getuPwd());//
				List<StUser> list = sum.selectByExample(sue);
				if(list.size() == 0) {
					throw new BizException("用户名或密码错误");
				}
//				return list.get(0);//*
				//加密验证
				for(StUser suer :list) {				
					boolean istrue = passwordEncoder.matches(user.getuPwd(),suer.getuPwd());
					if(istrue) {
						return suer;
					}				
				}				
				throw new BizException("用户名或密码错误");
			}
		throw new BizException("用户名或密码错误");
				
	}
	
	//用户注册
	public int register(StUser user) {
		return sum.insert(user);
	}
	
	//修改用户信息
	public int updata(StUser user) {
		StUserExample example = new StUserExample();
		example.createCriteria().andUNameEqualTo(user.getuName()).andUEmailEqualTo(user.getuEmail());
		List<StUser> uList = sum.selectByExample(example);
		StUser suer = uList.get(0);
		suer.setuPwd(user.getuPwd());
		return sum.updateByPrimaryKey(suer);
	}

	//阅读扣积分
	public int koujif(StUser user){
		if(user.getIntegral()-2<0){
			return 0;
		}else{
			System.out.println("----------jf+++++"+user);
			int integral = user.getIntegral() - 2;
			user.setIntegral(integral);
			return sum.updateByPrimaryKeySelective(user);
		}
	}

	//查询作者
		public List<StUser> findAuthor() {
			StUserExample example = new StUserExample();
			example.createCriteria().andLevelEqualTo(1);
			PageHelper.startPage(1,8);
			return sum.selectByExample(example);		
		}
		//redis查询作者
		public List<StUser> redisFindAuthor(){
			/*template.opsForHash().va*/
			List<Object> us = new ArrayList<>();
			List<StUser> uss = new ArrayList<>();
			System.out.println(template.opsForHash().size("Author"));
			us =  template.opsForHash().values("Author");
			for(Object u: us) {
				uss.add((StUser)u);
			}		
			return uss;
			
		}
		
		//删除用户
		public void deleteUserById(Integer id) {
			sum.deleteByPrimaryKey(id);
		}
		
		//根据条件查询用户
		public List<StUser> findUserBy(StUser user) {
			StUserExample sue = null ;
			if( user != null) {
				sue = new StUserExample();
				if(user.getuEmail() != null && !"".equals(user.getuEmail())) {
					sue.createCriteria().andUEmailEqualTo(user.getuEmail());
					return sum.selectByExample(sue);
				}
				
				if(user.getuName() !=null && !"".equals(user.getuName())) {
					System.out.println(user.getuName());
					sue.createCriteria().andUNameLike(user.getuName());
					return sum.selectByExample(sue);
				}
				
				if(user.getuTel() !=null && !"".equals(user.getuTel())) {
					sue.createCriteria().andUTelEqualTo(user.getuTel());
					return sum.selectByExample(sue);
				}
				
				if(user.getLevel() !=null ) {
					sue.createCriteria().andLevelEqualTo(user.getLevel());
					return sum.selectByExample(sue);
				}
			}
			return sum.selectByExample(sue);
			
			
		}
	
}
