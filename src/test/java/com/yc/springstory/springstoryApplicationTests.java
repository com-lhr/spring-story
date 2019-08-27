package com.yc.springstory;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.story.SpringStoryApplication;
import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StComment;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCommentMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringStoryApplication.class})
public class springstoryApplicationTests {
	@Resource
	private BookBiz biz;
	@Resource
	private StBookMapper bookMapper;
	
	@Resource
	private CommentBiz cbiz;
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void newbookTest() {
		biz.newbook();
	}
	
	
	
	
	@Test
	public void findByCateforyAndTimeBIZTest() {
		biz.findByCateforyAndTime(1);
	}
	
	@Test
	public void findCommentByBidTest() {
		List<StComment> sList = cbiz.findCommentByBid(1);
		
		for(StComment s : sList) {
			System.out.println(s);
		}
			
	}
}
