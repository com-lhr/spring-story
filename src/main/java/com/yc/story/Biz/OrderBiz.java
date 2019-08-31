package com.yc.story.Biz;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.story.bean.StOrder;
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
	//添加订单
	public int addOrder(StOrder so,StUser su){
		so.setuId(su.getId());
		so.setoStatus(0); // 未支付状态 0
		return  som.insertMyOrder(so);
	}
	
	@Transactional
	public int pay(StOrder so,StUser su){
		so.setoStatus(1);
		int i;
		StUser user = sum.selectByPrimaryKey(su.getId());
		System.out.println(som.selectByPrimaryKey(so.getId()).getbId()+"-----------"+sgm.selectByPrimaryKey(so.getbId()));
		//判断是积分还是月票
		if("积分".equals(sgm.selectByPrimaryKey(som.selectByPrimaryKey(so.getId()).getbId()).getgDesc())){
			i = Integer.parseInt(sgm.selectByPrimaryKey(som.selectByPrimaryKey(so.getId()).getbId()).getgName()) + user.getIntegral();
			su.setIntegral(i);
		}else if("月票".equals(sgm.selectByPrimaryKey(som.selectByPrimaryKey(so.getId()).getbId()).getgDesc())){
			i = Integer.parseInt(sgm.selectByPrimaryKey(som.selectByPrimaryKey(so.getId()).getbId()).getgName()) + user.getTickets();
			su.setTickets(i);
		}
		
		som.updateByPrimaryKeySelective(so);
		return sum.updateByPrimaryKeySelective(su);
	}
}
