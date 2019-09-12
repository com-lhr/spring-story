package com.yc.story.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.yc.story.Biz.OrderBiz;
import com.yc.story.bean.StOrder;
import com.yc.story.bean.StUser;
import com.yc.story.util.AlipayConfig;

@Controller
public class AlipayServlet {

	@Resource
	private OrderBiz obiz;
	
	@GetMapping("getpay")
	public String getpay(){
		//System.out.println("============="+id);
		
		return "alipay/index";
	}
	
	@GetMapping("addOrder")
	public String addOrder(@SessionAttribute(name="loginedUser",required=false) StUser user,
			String id,String name,String money,Model model){
		System.out.println(id);
		StOrder so = new StOrder();
		so.setId(Integer.parseInt(id));
		so.setbId(Integer.parseInt(name));
		so.setoAmount(Float.parseFloat(money));
		
		obiz.addOrder(so,user);
		return "topay";
	}
	
	@GetMapping("topay")
	public String topay(@SessionAttribute(name="loginedUser",required=false) StUser user,Model model) throws UnsupportedEncodingException{
		return "alipay/alipay.trade.page.pay";
	}
	
	@GetMapping("pay")
	public String pay(@SessionAttribute(name="loginedUser",required=false) StUser user,String orderId, HttpServletRequest request, HttpServletRequest response) throws UnsupportedEncodingException, AlipayApiException{
		
		//获取支付宝GET过来反馈信息
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名

		//——请在这里编写您的程序（以下代码仅作参考）——
		if(signVerified) {
			//商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
		
			//付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
			
			StOrder so = new StOrder();
			so.setId(Integer.parseInt(out_trade_no));
			so.setoAmount(Float.parseFloat(total_amount));
			obiz.pay(so, user);
			return "redirect:collect";
			
		}else {
			return "验签失败";
		}
		//return "self";
	}
}

