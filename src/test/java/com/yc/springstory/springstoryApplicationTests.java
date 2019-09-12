package com.yc.springstory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.yc.story.SpringStoryApplication;
import com.yc.story.Biz.BookBiz;
import com.yc.story.Biz.CategoryBiz;
import com.yc.story.Biz.CommentBiz;
import com.yc.story.Biz.UserBiz;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StBook2;
import com.yc.story.bean.StBookExample;
import com.yc.story.bean.StComment;
import com.yc.story.bean.StRecommendation;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCommentMapper;
import com.yc.story.dao.StRecommendationMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={SpringStoryApplication.class})
public class springstoryApplicationTests {
	@Autowired
    private RedisTemplate<Object,Object> template;
	@Resource
	private CategoryBiz cgbiz;
	@Resource
	private BookBiz biz;
	@Resource
	private StBookMapper bookMapper;
	@Resource
	private UserBiz ubiz;
	@Resource
	private StRecommendationMapper sram;
	@Resource
	private CommentBiz cbiz;
	@Autowired
	private RedisTemplate<String, ?> redisTemplate;
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
	
	@Test
	public void saveHash() {
		Map<String, String> m = new HashMap<>();
		m.put("1", "玄幻小说");
		m.put("2", "科幻小说");
		m.put("3", "都市小说");
		m.put("4", "穿越小说");
		m.put("5", "修真小说");
		m.put("6", "网游小说");
		redisTemplate.opsForHash().putAll("category", m);
	}
	
	@Test
	public void findcategoryTest() {
		System.out.println(redisTemplate.opsForHash().values("category"));
	}
	@Test
	public void findAuthorTest() {
		ubiz.findAuthor();
	}
	@Test
	public void saveHashAuthor() {
		Map<String,StUser> m = new HashMap<>();
		List<StUser> users = ubiz.findAuthor();
		for(StUser u :users ) {
			m.put(u.getId()+"", u);
		}
		template.opsForHash().putAll("Author", m);
	}
	@Test
	public void getHash() {
		StUser u = new StUser();
		List<Object> us = new ArrayList<>();
		System.out.println(template.opsForHash().size("Author"));
		us =  template.opsForHash().values("Author");
		u =(StUser)us.get(0);
		System.out.println(u.getuImage());
	}
	
	@Test 
	public void savaHashbook() {
		Map<String,StBook2> m = new HashMap<>();
		StBookExample bookExample = new StBookExample();
		bookExample.createCriteria().andBNameEqualTo("斗罗大陆");
		List<StBook> s = bookMapper.selectByExample(bookExample);
		for(StBook u :s ) {
			StBook2 s2 = new StBook2();
			s2.setId(u.getId());
			s2.setbFace(u.getbFace());			
			s2.setbName(u.getbName());
			m.put(s2.getId()+"", s2);
		}
		template.opsForHash().putAll("StRecommendations", m);
		System.out.println( template.opsForHash().values("StRecommendations"));
	}
	@Test
	public void findAuthortest() {
		System.out.println(biz.findAuthor(13));
	}
}
