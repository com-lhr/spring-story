<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>个人主页</title>
<!-- 引入Bootstrap核心样式文件 -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery.js"></script>
<!-- 引入BootStrap核心js文件 -->
<script src="bootstrap/js/bootstrap.min.js"></script>	
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/self.css" rel="stylesheet" type="text/css">

<script src="js/js.js"></script>
<script src="js/self.js"></script>
</head>

<body>
<header class="clear">
<img src="img/logo.jpg" >
<div class="logo">
    <h1>阅读天地</h1>
    <div class="clear"></div>
    <p>想看既看，想听既听的阅读</p>
</div>
<div class="search left">
    <form  action="" method="get">
        <input type="text" value="" placeholder="请输入书名或作者名称">
        <input type="submit" value="搜索">
    </form>
    <p class="left">
        <span>热门推荐：</span>
        <a href="javascript:;">原来你还在这里</a>
        <a href="javascript:;">原来你还在这里</a>
        <a href="javascript:;">原来你还在这里</a>
        <a href="javascript:;">原来你还在这里</a>
    </p>
</div>
 <div class="reg">
<!--<div class="delu">
    <a  href="javascript:;">登录</a>
    <span>|</span>
    <a  href="javascript:;">注册</a>
  </div>-->
  <div class="delu2 clear">
      <div class="self ease">
      <a href="javascript:;" class="clear">雪剑无影<span class="icon ease"></span></a>
      <div class="clear"></div>
       <ul  class="clear">
         <li><a href="javascript:;">个人中心</a></li>
         <li><a href="javascript:;">我的书架</a></li>
         <li><a href="javascript:;">账号设置</a></li>
         <li><a href="javascript:;">上传文件</a></li>
         <li><a href="javascript:;">退出登录</a></li>
       </ul>
      </div>
      <span class="split">|</span>
       <a  href="javascript:;"  title="您有3条未读消息" class="news">消息<b>3</b></a>
  </div>
   <span>|</span>
    <a  href="javascript:;">意见反馈</a>
 </div>
</header>
<!--头部结束-->

<nav class="clear">
    <ul class="nav_1 clear">
    <div class="active"></div>
    <li><a href="javascript:;">首页</a></li>
    <li><a href="javascript:;">文学</a>
       <ul class="clear">
         <li><a href="javascript:;">现代文学</a></li>
         <li><a href="javascript:;">外国文学</a></li>
         <li><a href="javascript:;">古典文学</a></li>
         <li><a href="javascript:;">散文随笔</a></li>
       </ul>
    </li>
    <li><a href="javascript:;">社会学</a></li>
    <li><a href="javascript:;">心理学</a></li>
    <li><a href="javascript:;">经济学</a></li>
    <li><a href="javascript:;">自然科学</a></li>
    <li><a href="javascript:;">历史</a></li>
    <li><a href="javascript:;">其他</a>
       <ul class="clear">
         <li><a href="javascript:;">旅游攻略</a></li>
         <li><a href="javascript:;">周刊杂志</a></li>
         <li><a href="javascript:;">经典短语</a></li>
       </ul>    
    </li>
    <div class="submission">
    <a href="javascript:;"><span class="icon_span"></span>我要投稿</a>
    </div>
    </ul>
</nav><!--导航结束-->

<div class="box">
   <div class="box_1 clear">
    <div class="z_left">
      <div class="list_1">
          <div class="portrait">
               <p class="por_modify">
                  <img src="img/avatar.jpg">
                  <a href="javascript:;">修改图像</a>
               </p>
              <p>雪剑无影</p>
              <p  class="border_b"></p>
              <p><span>积分</span> <b>498</b></p>
          </div>
      </div><!--头像部分-->
      <ul class="list_1">
        <li class="active"><a href="#"><span class="icon"></span>个人资料修改</a></li>
        <li><div  class="clear"><a href="#" class="left"><span class="icon"></span>我的消息</a><b>4</b></div></li>
        <li><a href="javascript:tocollect();"><span class="icon"></span>我的收藏</a></li>  
        <li><a href=";"><span class="icon"></span>我的上传记录</a></li>  
        <li><a href="javascript:;"><span class="icon"></span>上传普通文档</a></li>  
        <li><a href="javascript:;"><span class="icon"></span>购买记录</a></li>  
        <li><a href="javascript:;"><span class="icon"></span>购买积分</a></li>  
      </ul>
    </div><!--左边-->
  
   <div class="center_r">
    <div class="c_1" style="display:block;">
        <p class="tit">个人资料修改</p>
        <p class="border_b"></p>
       <p class="ul">
          <a href="#" class="active">个人资料</a>
          |
          <a href="#">修改头像</a>
          |
          <a href="#">修改用户名</a>
          |
          <a href="#">修改邮箱</a>
          |
          <a href="#">修改密码</a>
        </p> 
       <ul class="tab menu_1"  style="display:block;">
          <li class="h_portrait"> <p class="por_modify"><img src="img/avatar.jpg"><a href="javascript:;">修改图像</a></p></li>
          <li><span>用户名</span>：雪剑无影<a href="javascript:;" title="修改用户名"><img src="img/modif.png" class="u_name"></a></li>
          <li><span>邮 &nbsp; 箱</span>：12dedfdsfdsf@qq.com<a href="javascript:;" title="修改邮箱"><img src="img/modif.png" class="u_email"></a></li>
      </ul>  
       <div class="tab menu_2">
          <img src="img/avatar.jpg"> 
          <form   id="up_pro" >  
          <p><input type="file" name="protrait" class="text"><i class="none">您没有上传文件</i></p>
          <p><input type="button" class="submit" name="up_pro"  value="上传"></p>
          </form>
       </div>
       <div class="tab menu_3">
         <form   id="user_name">  
          <p><span>用户名：</span> <input type="text" name="name" value="" class="text_1" placeholder="雪剑无影"   autocomplete="off"> <em>*</em><i>请输入用户名</i></p>
          <p><input type="button"  value="提交"  class="submit"></p>
          </form>
       </div>
       <div class="tab menu_3" >
         <form  id="user_email">  
          <p><span>邮 &nbsp; 箱：</span> <input type="text" name="email" value="" class="text_2"   autocomplete="off"> <em>*</em><i>请输入正确的邮箱</i></p>
          <p><input type="button"  value="提交"   class="submit"></p>
          </form>
       </div>
       <div class="tab menu_3">
         <form  id="user_pass">  
          <p><span>当前密码：</span> <input type="text" name="old_pwd" value="" class="text_3"   autocomplete="off"> <em>*</em><i>请输入当前密码</i></p>
          <p><span>&nbsp;新 密 码：</span> <input type="text" name="new_pwd" value="" class="text_3"   autocomplete="off"> <em>*</em><i>密码6---9个字符，下划线英文数字组合</i></p>
          <p><span>确认密码：</span> <input type="text" name="new_pwd2" value="" class="text_3"   autocomplete="off"> <em>*</em><i>两次密码不一致</i></p>
          <p><input type="button"  value="提交"  class="submit" style="margin-left:77px"></p>
          </form>
       </div>
    </div><!--个人资料修改-->
    
    <div class="c_2">
       <p class="tit">我的消息 <span><a href="javascript:;" class="del">[全部清空]</a></span></p>
       <p class="border_b"></p>
       <ul class="list li">
         <li>
            <p class="tit">系统<time>2015-04-17</time>消息提醒<span><a href="javascript:;">删除</a></span></p>
            <p class="con">恭喜！您已经成功开通了博客。您可以删除或编辑此博文，开始您的博客之旅</p>
         </li>
         <li>
            <p class="tit">系统<time>2015-04-17</time>消息提醒<span><a href="javascript:;">删除</a></span></p>
            <p class="con">您上传的ＸＸＸ的文档已通过审核,在我的上传里可以查看。</p>
         </li>
         <li>
            <p class="tit">aa<time>2015-04-17</time>回复 <a href="javascript:;">thinkphp3.2中不支持mySql 函数...</a><span><a href="javascript:;">删除</a></span></p>
            <p class="con">回复： 配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数
            据库配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数据库</p>
         </li>
           <li>
            <p class="tit">aa<time>2015-04-17</time>回复 <a href="javascript:;">thinkphp3.2中不支持mySql 函数...</a><span><a href="javascript:;">删除</a></span></p>
            <p class="con">回复： 配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数
            据库配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数据库</p>
         </li>
                  <li>
            <p class="tit">系统<time>2015-04-17</time>消息提醒<span><a href="javascript:;">删除</a></span></p>
            <p class="con">恭喜！您已经成功开通了博客。您可以删除或编辑此博文，开始您的博客之旅</p>
         </li>
         <li>
            <p class="tit">系统<time>2015-04-17</time>消息提醒<span><a href="javascript:;">删除</a></span></p>
            <p class="con">您上传的ＸＸＸ的文档已通过审核,在我的上传里可以查看。</p>
         </li>
         <li>
            <p class="tit">aa<time>2015-04-17</time>回复 <a href="javascript:;">thinkphp3.2中不支持mySql 函数...</a><span><a href="javascript:;">删除</a></span></p>
            <p class="con">回复： 配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数
            据库配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数据库</p>
         </li>
           <li>
            <p class="tit">aa<time>2015-04-17</time>回复 <a href="javascript:;">thinkphp3.2中不支持mySql 函数...</a><span><a href="javascript:;">删除</a></span></p>
            <p class="con">回复： 配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数
            据库配置里的数据库配置项都是为数据库驱动服务的吧，用原生不使用驱动的话自然要自己连接数据库</p>
         </li>
       </ul><!--一页显示10条-->
        <ul class="page clear">
            <li>首页</li>
            <li>上一页</li>
            <li><a href="javascript:;" class="thispage">1</a></li>
            <li><a href="javascript:;">2</a></li>
            <li><a href="javascript:;">3</a></li>
            <li><a href="javascript:;">4</a></li>
            <li><a href="javascript:;">5</a></li>
            <li><a href="javascript:;">下一页</a></li>
           <li><a href="javascript:;">尾页</a></li>
           <li class="tz"><select>
           <option value="1">1</option>
           <option value="1">1</option>
           <option value="1">1</option>
           </select><a href="javascript:;">跳转</a>
           </li>
           <li>共 1/3 页</li>
      </ul><!--分页--> 
     </div><!--我的消息-->
     
    <div class="c_3">
        <p class="tit">我的收藏<span><a class="del" href="#" onclick="javascript:cancel(0);">[取消全部收藏]</a></span></p>
        <p class="border_b"></p>
        <ul class="list li" id="collect">
            <c:forEach items="${coList }" var="c">
            <li id="li${c.bId }"><span class="icon_span pos_book"></span><a href="javascript:;">${c.stBook.bName }</a>
            <span><c:if test="${c.stBook.bStatus == 0}" >更新中</c:if>
            <c:if test="${c.stBook.bStatus == 1}" >已完结</c:if></span>
            <span class="right">
            <time>
            <%-- <fmt:formatDate value="${c.stBook.bTime}" pattern="yyyy-MM-dd"/> 
            	    /*  '<time><fmt:formatDate value="${c.stBook.bTime }" pattern="yyyy-MM-dd"/></time>'+ */
            	     /*  '<time><fmt:formatDate value="${'+data[i].stBook.bTime+'}" pattern="yyyy-MM-dd"/></time>'+ */
            --%>
            <fmt:formatDate value="${c.stBook.bTime}" pattern="yyyy-MM-dd"/>
            </time>
              <a href="#" onclick="javascript:buy(${c.bId });">
                 <span>
                    <c:if test="${c.cStatus == 1}" >已购买</c:if>
                    <c:if test="${c.cStatus == 0}" >未购买</c:if>
                 </span></a>
              <a href="#" onclick="javascript:cancel(${c.bId });">取消收藏</a></span></li>
            </c:forEach>
        </ul>
        <ul class="page clear">
            <li>首页</li>
            <li>上一页</li>
            <!-- href="collect?page=1"   href="collect?page=2"-->
            <c:forEach var="i" begin="1" end="${count}">
            <li><a href="javascript:void(0)" class="thispage" onclick="page(${i })">${i }</a></li>
            </c:forEach>
            <li><a href="javascript:page()">下一页</a></li>
           <li><a href="javascript:;">尾页</a></li>
           <li class="tz"><select id="page">
           
           <option value=1>1</option>
           <option value=2>2</option>
           </select><a href="javascript:page()">跳转</a>
           </li>
           <li>共 1/3 页</li>
      </ul><!--分页--> 
    </div>
    <!--我的收藏-->
	<script type="text/javascript">
    function page(page){
    	$.get("collectPage",{
    		page:page
    	},
    	function(data){
    		console.info(data);
    		$("#collect").empty();
    		for(var i=0;i<data.length;i++){
    			$("#collect").append(
        				'<li>'+
        				'<span class="icon_span pos_book"></span>'+
        				'<a href="javascript:;">'+data[i].stBook.bName+'</a>'+
        	            '<span>&nbsp;'+(data[i].stBook.bStatus=="0"?"未完结":"已完结")+'</span>'+
        	            '<span class="right">'+
        	            '<time>'+(data[i].stBook.bTime).substring(0,10)+'</time>&nbsp;'+
        	            '<a href="#" onclick="javascript:buy(${c.bId });"><span>'+
        	            (data[i].cStatus=="0"?"未购买":"已购买")+
        	            '</span></a>'+
        	            '&nbsp;<a href="javascript:cancel('+data[i].bId+');">取消收藏</a>'+
        	            '</span>'+
        	            '</li>'
        		);
    		}
    		
    	});
    }
    //获取收藏夹
    function tocollect(){
    	var url = "collect";
	   	var page= document.getElementById(page);
	   	var param = {page:page};
	   	var callback = function(data){
	   		
	   	};
	   	$.get(url,param,callback);
    }
    //取消收藏
    function cancel(bid){
    	 var url = "cancel";
	   	 var param= {bid:bid};
	   	 var callback = function(data){
	   		 console.info(data.length)
	   		if(data.length==0){
	   			$("#collect").empty();
    			$("#collect").append('您的书架上没有书哦，请去书城找找看吧。。。');		
    		}else{
    			console.info(data.length)
	    		$("#collect").empty();
	    		for(var i=0;i<data.length;i++){
	    			$("#collect").append(
	        				'<li>'+
	        				'<span class="icon_span pos_book"></span>'+
	        				'<a href="javascript:;">'+data[i].stBook.bName+'</a>'+
	        	            '<span>&nbsp;'+(data[i].stBook.bStatus=="0"?"更新中":"已完结")+'</span>'+
	        	            '<span class="right">'+
	        	            '<time>'+(data[i].stBook.bTime).substring(0,10)+'</time>&nbsp;'+
	        	            (data[i].cStatus=="0"?"未购买":"已购买")+
	        	            '&nbsp;</span></a>'+
	        	            '<a href="javascript:cancel('+data[i].bId+');">取消收藏</a>'+
	        	            '</span>'+
	        	            '</li>'
	        		);
	    		}
        		
    		}
	    		
	     };
	   	 $.get(url,param,callback);
    }
    
    </script>
    <div class="c_3">
        <p class="tit">我的上传记录<span><a href="javascript:;" class="del">[删除全部记录]</a></span></p>
        <p class="border_b"></p>
          <ul class="list li">
            <li><span class="icon_span pos_book"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">删除记录</a></span></li>
            <li><span class="icon_span pos_book"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">删除记录</a></span></li>
            <li><span class="icon_span pos_book"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">删除记录</a></span></li>
            <li><span class="icon_span pos_book"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">删除记录</a></span></li>
        </ul>
          <ul class="page clear">
            <li>首页</li>
            <li>上一页</li>
            <li><a href="javascript:;" class="thispage">1</a></li>
            <li><a href="javascript:;">2</a></li>
            <li><a href="javascript:;">3</a></li>
            <li><a href="javascript:;">4</a></li>
            <li><a href="javascript:;">5</a></li>
            <li><a href="javascript:;">下一页</a></li>
           <li><a href="javascript:;">尾页</a></li>
           <li class="tz"><select>
           <option value="1">1</option>
           <option value="1">1</option>
           <option value="1">1</option>
           </select><a href="javascript:;">跳转</a>
           </li>
           <li>共 1/3 页</li>
      </ul><!--分页-->
       </div> <!--我的上传-->

    <div class="c_5">
        <p class="tit">购买记录</p>
        <p class="border_b"></p>
        <div class="showOrder">
            <table class="table table-hover">
				<thead>
					<tr>
						<th>订单编号</th>
						<th>商品</th>
						<th>支付时间</th>
						<th>状态</th>
						<th>金额</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody id = "ordertable">
				    <c:forEach items="${taList }" var="ta">
					<tr class="<c:if test="${ta.oStatus == 1}" >success</c:if><c:if test="${ta.oStatus == 0}" >warning</c:if>">
						<td>${ta.id }</td>
						<td>${ta.bId }</td>
						<td><fmt:formatDate value="${ta.oTime}" pattern="yyyy-MM-dd"/></td>
						<td><span>
		                   <c:if test="${ta.oStatus == 1}" >已支付</c:if>
		                   <c:if test="${ta.oStatus == 0}" >未支付</c:if>
		                </span></td>
		                <td>￥${ta.oAmount }</td>
		                <td><div class="btn-group">
						  <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						    详情 <span class="caret"></span>
						  </button><ul class="dropdown-menu">
						    <li><a href="../alipay/alipay.trade.page.pay.jsp?WIDout_trade_no=${ta.id }&WIDsubject=${ta.bId}&WIDtotal_amount=${ta.oAmount }&WIDbody='无'">支付</a></li>
						    <li><a href="javascript:deleteOrder(${ta.id });">删除</a></li>
						  </ul></div></td>
					</tr>
					</c:forEach>
					
				</tbody>
			</table>
        </div>
   </div><!--查看订单 -->
 
   
    <div class="c_4">
        <p class="tit">购买积分</p>
        <p class="border_b"></p>
       
     <form name="up_file2" class="up_file2"  id="soud_file">
        <input  type="hidden" value="" name="up_temp" class="up_temp"><!--上传的文件名称-->
        <c:forEach items="${gList }" var="g">
        <div class="clear p_t">
               <div class="up_fm">
               <a href="javascript:void(0);" onclick="window.location='../alipay/index.jsp?gid=${g.id}&integ=${g.gPrice*g.gCost }'"><img src="img/album_100.jpg"  class="fm_img"><br/>
               <label>${g.gName}${g.gDesc }</label><br/>
               <label>原价：￥${g.gPrice}</label><br/>
               <label style="color: red;font-weight: bold;">现价：￥${g.gPrice*g.gCost}</label></a>
               </div>
         </div><!--设置积分-->
         </c:forEach>
         
     </form><!--积分-->
   </div><!--购买积分-->
   <script type="text/javascript">
   function pay(money){
	   $.get('pay',{
		   money:money
	   },function(data){
		   if(data==null){
			   alert('支付失败');
		   }
	   });
   }
       
   </script>
     <div class="c_3">
        <p class="tit">我的专辑<span><a href="javascript:;" class="del">[删除全部专辑]</a></span>
         <a href="javascript:;" class="right" id="zj_c">创建新专辑</a>
        </p>
        <p class="border_b"></p>
          <ul class="list li">
            <li><span class="icon_span pos_yiyue"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">编辑</a><a href="javascript:;"  onClick="return confirm('您确定删除此专辑')">删除专辑</a></span></li>
            <li><span class="icon_span pos_yiyue"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">编辑</a><a href="javascript:;"  onClick="return confirm('您确定删除此专辑')">删除专辑</a></span></li>
            <li><span class="icon_span pos_yiyue"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">编辑</a><a href="javascript:;"  onClick="return confirm('您确定删除此专辑')">删除专辑</a></span></li>
            <li><span class="icon_span pos_yiyue"></span><a href="javascript:;">黑色的办公室出租H5响应式网站模板免费</a>
            <span class="right"><time>2012-04-04</time><a href="javascript:;">编辑</a><a href="javascript:;"  onClick="return confirm('您确定删除此专辑')">删除专辑</a></span></li>
        </ul>
          <ul class="page clear">
            <li>首页</li>
            <li>上一页</li>
            <li><a href="javascript:;" class="thispage">1</a></li>
            <li><a href="javascript:;">2</a></li>
            <li><a href="javascript:;">3</a></li>
            <li><a href="javascript:;">4</a></li>
            <li><a href="javascript:;">5</a></li>
            <li><a href="javascript:;">下一页</a></li>
           <li><a href="javascript:;">尾页</a></li>
           <li class="tz"><select>
           <option value="1">1</option>
           <option value="1">1</option>
           <option value="1">1</option>
           </select><a href="javascript:;">跳转</a>
           </li>
           <li>共 1/3 页</li>
      </ul><!--分页-->
       </div> <!--我的专辑-->
   
   <div class="up_load">
      <img src="img/load.gif">
   </div><!--上传文件或头像的load-->
   
   </div><!--右边-->
 </div>
</div><!--内容区结束-->
 <div class="mark">
       <div class="zj_create">
         <h3>创建新专辑<span class="right">×</span></h3>
          <form name="zj"  class="up_file2" id="zj_file">
          <div class="clear"><p><label>专辑名称：</label><input type="text" value="" name="zj_name" class="zj_name"> 
                 <em>*</em><i>专辑名称2---20个字符</i></p>
           <p  style="margin-left:63px;"><i>好的专辑标题至关重要，要用简短文字概括出最有吸引力的卖点哦~<br/>
            &nbsp;例如：青雪讲故事（结合人名）；科技相对论（结合行业）</i></p>
          </div>
          <div  class="clear p_t"><label class="left">设置封面：</label>
               <div class="up_fm">
               <span class="icon fm_icon"></span>
               <img src="img/album_100.jpg"  class="fm_img"> 
               <span class="icon fm_colse"></span>
               </div>
           </div><!--设置封面-->
          <div class="up_img">
              <p  class="icon up_img1">上传图片</p>
              <input type="file" name="up_img" class="up_img2"><i>文件大小<3M,尺寸最好>200X200 </i><!--当改变时，上传图片，ajax提交返回图片地址-->
          </div>
          
          <p class="up_type clear"><label>类 &nbsp; &nbsp; 型：</label>
             <select name="up_type">
             <option value="0">请选择一个类型</option>
             <option value="1">娱乐</option>
             <option value="2">文化</option>
             <option value="3">商业经济</option>
             <option value="4">文学</option>
             <option value="5">历史</option>
              <option value="6">情感生活</option>
             </select> <em>*</em><i class="none">请选择一个类型</i>
          </p>
          <div class="up_px clear p_t"><label class="left">专辑排序： </label>
             <div class="left">
               <p><input type="radio" value="px_desc" name="zj_px"> 倒序 <i>最新在前（如：第3集、第2集、第1集）</i></p>
               <p><input type="radio" value="px_asc" name="zj_px" checked> 正序 <i>最新在后（如：第1集、第2集、第3集）</i><em>*</em> </p>
           </div>
          </div>
                 
         <p><label  style="vertical-align:top">文档描述：</label><textarea name="up_area" class="area"></textarea>
             <br/><em style="margin-left:65px;">*</em><i>文档描述20----200个字</i>
         </p>
         
          <div class="up_tag p_t">
             <label>标 &nbsp; &nbsp; 签：</label>
             <input type="text" name="up_tag" class="up_txt" ><i class="nored">标签名称禁止重复</i>
             <div class="list_tag  clear del_tag"></div>
             <div class="list_tag clear old_tag">
                <samp>访谈</samp>
               <samp>娱乐</samp>
               <samp>情感</samp>
                <samp>心理</samp>
               <samp>心灵</samp>     
                <i class="nored none">标签名称禁止重复</i> 
               <input type="hidden" name="up_tag2" class="up_txt2" value="">
             </div>
             <p style="margin-left:60px;" class="tag_len"><i>最多5个标签,自定义单个标签最长6个汉字(英文12个),标签之间用,隔开;  建议添加,方便用户搜索</i></p>
         </div>
         <p style="margin-left:70px; padding-top:20px"><input type="submit" value="保存" class="submit"></p> 
        </form>
       </div><!--创建专辑-->
       
       <div class="zj_load">
        <img src="img/load.gif">
        <p>专辑正则创建中，请稍后。。。</p>
       </div>
       
       <div class="mark_bor">
        <div class="clear"><img src="img/selected.png"><p></p></div><!--创建专辑成功和失败-->
      </div>
       
       <div id="up_3">
       <p>您确定删除此文档吗</p>
       <p><span class="ease">确定</span><span class="ease">取消</span></p>
       </div>
  </div><!--遮罩层-->

<footer class="clear">
    <p>阅读天地是学习分享平台，如对本站有意见和建议请<a href="javascript:;">留言</a></p>
    <p>本站所有信息仅用于学习交流，不用商业用途   Powered by 阅读天地</p>
</footer><!--底部结束-->
</body>
</html>
