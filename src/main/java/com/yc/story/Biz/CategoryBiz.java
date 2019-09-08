package com.yc.story.Biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.yc.story.bean.StCategory;
import com.yc.story.dao.StCategoryMapper;

@Service
public class CategoryBiz {
	@Autowired
	private RedisTemplate<String, ?> redisTemplate;
	@Resource
	private StCategoryMapper scm;
	
	public List<StCategory> allCategory(){
		return scm.selectByExample(null);
	}
	
	public List<StCategory> allRedisCategory(){
		List<StCategory> list = new ArrayList<StCategory>();
		Map<Object, Object> m = new HashMap<>();
	    m = redisTemplate.opsForHash().entries("category");
	    for(Entry<Object, Object> entry : m.entrySet()){
	    	list.add(new StCategory() {
	    		{
	    			setId(Integer.valueOf(entry.getKey()+""));
	    			setCaName(entry.getValue()+"");
	    		}
	    	});
	    }
		return list;
	}

}
