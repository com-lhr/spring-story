package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StCategory;
import com.yc.story.dao.StCategoryMapper;

@Service
public class CategoryBiz {
	
	@Resource
	private StCategoryMapper scm;
	
	public List<StCategory> allCategory(){
		return scm.selectByExample(null);
	}

}
