package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StBookExample;
import com.yc.story.dao.StBookMapper;

@Service
public class BookBiz {

	@Resource
	private StBookMapper bookMapper;
	
	//查出最新上架的小说
	public List<StBook> newbook(){
		StBookExample bookExample = new StBookExample();
		bookExample.setOrderByClause("b_time desc");
		PageHelper.startPage(1, 10);
		return bookMapper.selectByExample(bookExample);
	}
}
