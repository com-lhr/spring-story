package com.yc.springstory;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.story.SpringStoryApplication;
import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.bean.StComment;
import com.yc.story.bean.StRecommendation;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCommentMapper;
import com.yc.story.dao.StRecommendationMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringStoryApplication.class})
public class springstoryApplicationTests {
	@Resource
	private CategoryBiz cgbiz;
	@Resource
	private BookBiz biz;
	@Resource
	private StBookMapper bookMapper;
	@Resource
	private StRecommendationMapper sram;
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
	public void findByCateforyAndTimeTest() {
		bookMapper.findByCategoryAndTime("玄幻魔法");
	}

	
	@Test
	public void findByCateforyAndTimeBIZTest() {
		biz.findByCategoryAndTime(1);
	}
	
	@Test
	public void findCommentByBidTest() {
		List<StComment> sList = cbiz.findCommentByBid(1);		
		for(StComment s : sList) {

			System.out.println("评论"+s);


		}
			
	}
	
	
	@Test
	public void findBookByid() {
		System.out.println(biz.findDetail(1));
	}
	
	@Test
	public void findrecommendation() {
		List<StRecommendation> list = sram.selectByExample(null);
		System.out.println(list.get(0).getStBook().getbName());
	}
	@Test
	public void searchbooklikenameTest() {
		System.out.println(biz.findPageBookLikeName("道").get(0).getbName());
	}
	
	@Test
	public void redisCategoryTest() {
		System.out.println(cgbiz.allRedisCategory().get(0).getId());
	}
	
}
