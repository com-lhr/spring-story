package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yc.story.bean.StNote;
import com.yc.story.dao.StNoteMapper;

@Service
public class LogBiz {

	@Resource
	private StNoteMapper snm;
	
	public List<StNote> queryAll(){
		return snm.selectByExample(null);
	}
	
}
