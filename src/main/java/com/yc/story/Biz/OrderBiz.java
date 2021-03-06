package com.yc.story.Biz;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.story.bean.StOrder;
import com.yc.story.bean.StOrderExample;
import com.yc.story.bean.StUser;
import com.yc.story.dao.StGoodsMapper;
import com.yc.story.dao.StOrderMapper;
import com.yc.story.dao.StUserMapper;

@Service
public class OrderBiz {

	@Resource
	private StOrderMapper som;
	
	@Resource
	private StUserMapper sum;
	
	@Resource
	private StGoodsMapper sgm;
	
	//查询订单（后台）
	public List<StOrder> queryAll(){
		return som.selectByExample(null);
	}
	
	// 查询个人订单
	public List<StOrder> queryOrder(StUser su){
		StOrderExample soe = new StOrderExample();
		soe.createCriteria().andUIdEqualTo(su.getId());
		return som.selectByExample(soe);
	}
	
	// 添加个人订单
	public int addOrder(StOrder so,StUser su){
		so.setuId(su.getId());
		so.setoStatus(0); // 未支付状态 0
		return som.insertMyOrder(so);
	}
	
	@Transactional
	// 支付
	public int pay(StOrder so,StUser su){
		so.setoStatus(1);
		int i;
		StUser user = sum.selectByPrimaryKey(su.getId());
		int bid = som.selectByPrimaryKey(so.getId()).getbId();
		System.out.println("-----------"+sgm.selectByPrimaryKey(bid));
		//判断是积分还是月票
		if("积分".equals(sgm.selectByPrimaryKey(bid).getgDesc())){
			i = Integer.parseInt(sgm.selectByPrimaryKey(bid).getgName()) + user.getIntegral();
			su.setIntegral(i);
		}else if("月票".equals(sgm.selectByPrimaryKey(bid).getgDesc())){
			i = Integer.parseInt(sgm.selectByPrimaryKey(bid).getgName()) + user.getTickets();
			su.setTickets(i);
		}
		
		som.updateByPrimaryKeySelective(so);
		return sum.updateByPrimaryKeySelective(su);
	}
}
