package com.yc.springstory;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.story.SpringStoryApplication;
import com.yc.story.Biz.BookBiz;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringStoryApplication.class})
public class springstoryApplicationTests {
	@Resource
	private BookBiz biz;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void newbookTest() {
		biz.newbook();
	}

}
