<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>小说详情页</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/arcticle2.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/list.js"></script>
<script src="js/comment.js"></script>
<style>
.fx{ margin-bottom:30px;}
</style>


</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box clear">
 <div class="list">
  <div class="pos">
     当前位置：<a href="toindex">首页</a> ><a href="javascript:;">${detailBook.stCategory.caName}</a> > ${detailBook.bName}
  </div>
  <h3>${detailBook.bName}</h3>

 <ul class="tab clear">
     <li class="active"><a href="#">简介</a></li>
     <li><a href="#">章节目录<b>(${detailBook.bNum})</b></a></li>
     <li><a class="pl_c" href="#">评论<b>(${detailBook.bCommcount})</b></a></li>
 </ul>
  <div class="tab_1">
    <div class="info clear">
     <img src="${detailBook.bFace == null ? 'img/album.jpg':detailBook.bFace }" class="left" style="margin-right:20px;width:150px;"> <p class="left" style="width:580px; overflow:hidden;">${detailBook.bIntroduce}
    </p>
     </div>
     <ul class="clear info_1">
     <p>基本信息</p>
     <li><span>作 &nbsp; &nbsp; &nbsp; 者：</span>${detailBook.bAuthor}</li>
     <li><span>出版时间：</span><fmt:formatDate value="${detailBook.bTime}" pattern="yyyy-MM-dd HH:mm:ss"/></li>
     <li><span>分 &nbsp; &nbsp; &nbsp; 类：</span>${detailBook.stCategory.caName}</li>
     <li><span>评 &nbsp; &nbsp; &nbsp; 价：</span>${detailBook.bCommcount}人评论 <samp>|</samp> ${detailBook.bReadcnt}人在读</li>
     </ul>
  </div><!--简介介绍-->
 
  <div class="tab_1">
     <div class="play">
          <p class="play_t"><a href="#">新版小叙</a><time>00:01/14:00</time></p>
          <div class="start clear">
               <div class="left">
                  <a href="javascript:;" class="icon play_1" id="p1"></a>
               </div>
               <div class="sound" title="点击播放"><img src="img/play.gif" class="b1">
               <div class="sound_stream clear">
                 <p class="time">00:23</p>
                 <div  class="s_2">
                     <p class="dian"></p>
                     <p class="line"></p>
                 </div>
               </div><!--声音流-->
               </div><!--控制声音-->
         </div>
         <div class="fx clear">
         <div class="bdsharebuttonbox right"><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_more" data-cmd="more"></a></div>
             <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
         </script>
         <p class="dsf1">
           <a href="javascript:;"><span  class="icon down"></span>下载到手机</a> 
           <a href="javascript:;" class="sc_c"><span  class="icon sc"></span>收藏<b>+1</b></a>
           <a href="javascript:;" class="pl_c">评论(345)</a>
         <b>分享到 :  &nbsp; </b>
         </p>
     </div>
     </div><!--有声播放-->
     
     <div class="tit">章节目录<b>(${detailBook.bNum})</b><a href="javascript:;" class="right f_s_12">更新排序</a></div>
     <div class="mu">
         <ul class="clear">
         <p>第一部分</p>
         <li class="active"><span class="icon play_3" id="b1"></span><a href="#">新版小叙</a>
               <div class="play_xq">
                <a href="javascript:;" class="sc_c"><span class="icon sc" title="收藏"></span><b>+1</b></a>
                <a href="javascript:;" class="fx_c"><span class="icon xq2" title="分享"></span></a>
                <a href="javascript:;" class="pl_c"><span class="icon xq3" title="评论"></span></a>
                <a href="javascript:;" class="xz_c"><span class="icon xq4" title="下载"></span></a>
                <time>2000-2-34</time>
                     <div class="fx_con">
                         <div class="bor_1"></div>
                         <div class="bor_2"></div>
                         <div class="colse clear"><a href="javascript:;"  class="icon"></a></div>
                         <div class="bdsharebuttonbox"><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
                          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
                         </script>
                     </div>
                 </div>
           </li>
         <li><span class="icon play_3" id="b2"></span><a href="#">新版小叙1</a>
                <div class="play_xq">
                <a href="javascript:;" class="sc_c"><span class="icon sc" title="收藏"></span><b>+1</b></a>
                <a href="javascript:;" class="fx_c"><span class="icon xq2" title="分享"></span></a>
                <a href="javascript:;" class="pl_c"><span class="icon xq3" title="评论"></span></a>
                <a href="javascript:;" class="xz_c"><span class="icon xq4" title="下载"></span></a>
                <time>2000-2-34</time>
                     <div class="fx_con">
                         <div class="bor_1"></div>
                         <div class="bor_2"></div>
                         <div class="colse clear"><a href="javascript:;"  class="icon"></a></div>
                         <div class="bdsharebuttonbox"><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
                          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
                         </script>
                     </div>
                 </div>
         </li>
         <li><span class="icon play_3" id="b3"></span><a href="#" >新版小叙2</a>
                <div class="play_xq">
                <a href="javascript:;" class="sc_c"><span class="icon sc" title="收藏"></span><b>+1</b></a>
                <a href="javascript:;" class="fx_c"><span class="icon xq2" title="分享"></span></a>
                <a href="javascript:;" class="pl_c"><span class="icon xq3" title="评论"></span></a>
                <a href="javascript:;" class="xz_c"><span class="icon xq4" title="下载"></span></a>
                <time>2000-2-34</time>
                     <div class="fx_con">
                         <div class="bor_1"></div>
                         <div class="bor_2"></div>
                         <div class="colse clear"><a href="javascript:;"  class="icon"></a></div>
                         <div class="bdsharebuttonbox"><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a></div>
                          <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
                         </script>
                     </div>
                 </div>
         
         </li>
         <li><a href="#">新版小叙3</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         </ul>
         <ul class="clear tab_list">
         <p>第二部分</p>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         </ul>
         <ul class="clear  tab_list">
         <p>第三部分</p>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         <li><a href="#">新版小叙</a></li>
         </ul>
     </div>
     <div  id="up" class="clear"><a href="javascript:;"><samp>查看全部</samp><span class="icon ease"></span></a></div>
  </div><!--章节目录-->
  
 <div class="tab_1 ">
   <div class="tit">评论<b>(${detailBook.bCommcount})</b></div>
  </div>  
  <div class="comment">
  
  <div class="com_con clear zong">
      <div class="portrait left mar_top">
      <img src="${loginedUser == null ? 'img/avatar.jpg' : loginedUser.uImage}"><br/>
      <span>${loginedUser.uName}</span>
      </div>
      <form action="" method="post" class="right kdit_w">
      <textarea id="cmContent" name="content" ></textarea>
      <p></p>
      <input name="bId" type="hidden" value="${detailBook.id}">
      <input type="button" value="提交" class="onSubmit" />
      </form>
  </div><!--当前用户评论-->
 
				<ul class="com_con clear">
					<!-- 第一条评论 -->
					<c:forEach items="${comments}" var="c">
						<div class="com_bor">
							<!--评论内容-->
							<li class="go">
								<div class="com_1 clear">
									<div class="portrait left">
									<!-- img/avatar.jpg -->
										<img src="${c.user.uImage}"><br /> <span>${c.user.uName}</span>
									</div>
									<div class="word left kdit_w">
										<p class="time">在 <fmt:formatDate value="${c.cmCreatetime}" pattern="HH:mm:ss"/>评论：</p>
										<br>
										<p>${c.cmContent}</p>
										<p class="right">
											<a href="javascript:;">回复</a> <a href="javascript:;"
												class="red">${fn:length(c.sList) > 0 ? '展开回复' : '' }</a>
											<time><fmt:formatDate value="${c.cmCreatetime}" pattern="yyyy-MM-dd"/></time>
										</p>
									</div>
								</div>
								 
								<!--回复框--> <%@ include file="common/reply.jsp"%>
							</li>
							
	
							<!--第一条评论的回复-->
							
														
									<li class="go2">
										<c:if test="${c.sList != null && fn:length(c.sList) > 0}">
										<c:forEach items="${c.sList}" var = "s">																			
											<div class="come">
												<!--回复内容-->
												<div class="com_con clear hui2">
													<div class="portrait left">
														<img src="${s.user.uImage}"><br /> <span>${s.user.uName}</span>
													</div>
													<div class="word left">
														<p>
															<span class="user">${s.user.uName}&nbsp回复 ${c.user.uName}：</span><br>${s.cmContent}
														</p>
														<p class="right">
															<a href="javascript:;">回复</a>
															<time><fmt:formatDate value="${s.cmCreatetime}" pattern="yyyy-MM-dd HH:mm:ss"/></time>
														</p>
													</div>
												</div>
												<!--回复框-->
												<%@ include file="common/reply.jsp"%>
											</div>
										
										</c:forEach>
										</c:if>
									</li>								
							
						</div>
					</c:forEach>					
					<!--      -第一条评论结束  -->
			
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

</div><!--评论结束-->

</div><!--右边结束-->
 	<%@ include file="common/list.jsp" %>
</div><!--中间box 结束-->


<%@ include file="common/footer.jsp" %>
</body>
</html>