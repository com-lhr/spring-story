package com.yc.story.Biz;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import java.util.Date;
import java.util.List;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.yc.story.bean.StBook;
import com.yc.story.bean.StBookExample;
import com.yc.story.bean.StCollection;
import com.yc.story.bean.StCollectionExample;
import com.yc.story.bean.StRecommendation;
import com.yc.story.bean.StRecommendationExample;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StBookMapper;
import com.yc.story.dao.StCollectionMapper;
import com.yc.story.dao.StRecommendationMapper;

@Service
public class BookBiz {
	
	@Resource
	private StBookMapper bookMapper;
	
	@Resource
	private StCollectionMapper collMapper;
	
	@Resource
	private StRecommendationMapper recommendationMapper;
		
	
	//查出最新上架的小说
	public List<StBook> newbook(){
		StBookExample bookExample = new StBookExample();
		bookExample.setOrderByClause("b_time desc");
		PageHelper.startPage(1, 10);
		return bookMapper.selectByExample(bookExample);
	}
	public List<StBook> findByCategory(int bCategory,int page){
		StBookExample bookExample = new StBookExample();
		bookExample.createCriteria().andBCategoryEqualTo(bCategory);
		PageHelper.startPage(page,5);
		return bookMapper.selectByExample(bookExample);
	}
	
	//根据类别和时间排序找出十本小说
	public List<StBook> findByCategoryAndTime(Integer bCategory){
		StBookExample bookExample = new StBookExample();
		bookExample.createCriteria().andBCategoryEqualTo(bCategory);
		bookExample.setOrderByClause("b_time desc");
		PageHelper.startPage(1,10);
		return bookMapper.selectByExample(bookExample);
	}
	
	/*public List<StBook> findByCateforyAndOrderbReadCnt(Integer bCategory){
		StBookExample bookExample = new StBookExample();
		
	}*/
	

	//更新某本书的信息
	public int updateReadCnt(StBook book) {
		return bookMapper.updateByPrimaryKey(book);
	}
	
	//根据id和章节目录名查出该章节内容
	public String chapterDeatil(Integer id,String name) {
		StBook book = bookMapper.selectByPrimaryKey(id);
		String path="e:/story/"+book.getbStatus()+"/"+book.getStCategory().getCaName()+"/"+book.getbAuthor()+"/"+book.getbName()+"/"+name+".html";
		File file = new File(path);
		FileReader in;
		try {
			in = new FileReader(file);
			BufferedReader bin=new BufferedReader(in);
			StringBuffer sb = new StringBuffer();
			String str;
			while ((str=bin.readLine())!=null) {				
				sb.append(str);
			}
			System.out.println(sb.toString());
			return sb.toString();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "该章节内容不见了";
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "该章节内容不见了";
		}
		
	}
	

	public int bookcount(Integer bCategory) {
		StBookExample example = new StBookExample();
		example.createCriteria().andBCategoryEqualTo(bCategory);
		return (int) bookMapper.countByExample(example);
	}

	
	//根据id一本书的详情
	public StBook findDetail(Integer id){
		Properties prop = new Properties();
		Map<Integer,String> map = new TreeMap<Integer,String>();
		List<String> list = new ArrayList<String>();
		StBook book = bookMapper.selectByPrimaryKey(id);

		//System.out.println(book.getbStatus()+"/"+book.getStCategory().getCaName()+"/"+book.getbAuthor()+"/"+book.getbName()+"/a.nin");
		//文件路径
		String path="e:/story/"+book.getbStatus()+"/"+book.getStCategory().getCaName()+"/"+book.getbAuthor()+"/"+book.getbName()+"/a.nin";						
		try {
			File file = new File(path);
			FileInputStream in = new FileInputStream(file);
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 返回Properties中包含的key-value的Set视图  
        Set<Entry<Object, Object>> set = prop.entrySet();  
        // 返回在此Set中的元素上进行迭代的迭代器  
        Iterator<Map.Entry<Object, Object>> it = set.iterator();  
        int key = 0;
		String value = null;  
        // 循环取出key-value  
        while (it.hasNext()) {  
  
            Entry<Object, Object> entry = it.next();  
            String str1= entry.getKey().toString();
            String[] str2 = str1.split("\\.");
            //System.out.println(str2[0]);
            key =Integer.parseInt(str2[0]);  
            value = String.valueOf(entry.getValue());  
   
            map.put(key, value);  
        }
        
        Set<Integer> set1 = map.keySet();
        Iterator<Integer> iterator = set1.iterator();
        while (iterator.hasNext()) {
            int key1 = iterator.next();
            String value1 =  map.get(key1);
            list.add(value1);
        }
        //存入章节名
        book.setbNum(list.size());
        book.setChapter(list);
		return book;		
	}
	
	//编者推荐
	public List<StRecommendation> findRecommendation(){
		StRecommendationExample example = new StRecommendationExample();
		example.setOrderByClause("recomTime desc");
		PageHelper.startPage(1,10);
		return recommendationMapper.selectByExample(example);
	}
	
	public List<StBook> findPageBookLikeName(String name){
		StBookExample example = new StBookExample();
		example.createCriteria().andBNameLike("%"+name+"%");
		PageHelper.startPage(1,5);
		return bookMapper.selectByExample(example);
	}
	
	public List<StBook> findBookLikeName(String name){
		StBookExample example = new StBookExample();
		example.createCriteria().andBNameLike("%"+name+"%");
		return bookMapper.selectByExample(example);
	}
	
	//查询收藏夹已有图书
	public List<Object> query(int uid){
		return collMapper.selectByUid(uid);
	}
	
	//查询收藏夹已有图书
	public List<Object> queryBefore(int uid){
		return collMapper.selectAllByUid(uid);
	}

	//添加收藏
	public int addCollection(StUser user, int bid){
		/*for(int i=0;i<query(user.getId()).size();i++){
			if(bid==query(user.getId()).get(i).getbId()){
				return 3;
			}
		}*/
		System.out.println(queryBefore(user.getId()).contains(bid));
		if(queryBefore(user.getId()).contains(bid)){
			StCollectionExample example = new StCollectionExample();
			example.createCriteria().andUIdEqualTo(user.getId()).andBIdEqualTo(bid);
			System.out.println(collMapper.selectByExample(example).get(0).getcStatus()+"------------");
			if(collMapper.selectByExample(example).get(0).getcRecord()==0){
				StCollection sc = new StCollection();
				sc.setcRecord(1);
				collMapper.updateByExampleSelective(sc, example);
				return 1;
			}else{
				return 3;
			}
			
		}else{
			StCollection sc = new StCollection();
			sc.setbId(bid);
			sc.setuId(user.getId());
			sc.setcStatus(0);
			sc.setcTime(new Date());
			sc.setcRecord(1);
			return collMapper.insertSelective(sc);
		}
		
	}
	
}
