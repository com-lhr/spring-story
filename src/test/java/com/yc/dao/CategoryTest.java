package com.yc.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.story.Biz.CategoryBiz;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryTest {
	
	@Resource
	CategoryBiz biz ;
	
	@Test
	public void test1() {
		System.out.println(biz.allCategory());
	}

}
