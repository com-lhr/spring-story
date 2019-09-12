<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文章内容区</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/arcticle.css" rel="stylesheet" type="text/css">

<!--<link rel="stylesheet" href="kindeditor-4.1.10/themes/default/default.css" />
<script charset="utf-8"  src="kindeditor-4.1.10/kindeditor-min.js"></script>
<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});

			});
</script>	-->
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/list.js"></script>	
<script src="js/comment.js"></script>
</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box clear">
  <div class="list">
      <div class="pos">
        当前位置：<a href="toindex">首页</a> ><a href="javascript:;">${detailBook.stCategory.caName}</a> > ${detailBook.bName}
        <a href="detail?id=${detailBook.id}" class="right">回到目录>></a> 
      </div>
    <div class="con">
      <h3>${detailBook.bName}</h3>
      <div class="introduce clear">
      <span class="left">出版时间：<fmt:formatDate value="${detailBook.bTime}" pattern="yyyy-MM-dd HH:mm:ss"/>  浏览次数：${detailBook.bReadcnt == null ? 0:detailBook.bReadcnt } </span> 
      <a href="javascript:;" class="sc_c"><span class="icon sc"></span>加入收藏<b>+1</b></a>
      </div>
      <div class="content clear">
        ${chapterDeatil}
     </div><!--文章内容区结束-->
     
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
 </div> <!--文章主体部分结束-->
 
 <div class="prenext clear">
    <!-- <a href="article?id=${detailBook.id}&character=${last}">${last}</a> -->
    <p class="left">上一章 : <a href="javascript:void(0);" onclick="javascript:judge('${detailBook.id}','${last}')">${last}</a></p>
    <!-- <a href="article?id=${detailBook.id}&character=${next}">${next}</a> -->
    <p class="right">下一章 : <a href="javascript:void(0);" onclick="javascript:judge('${detailBook.id}','${next}')">${next}</a></p>
 </div>
<script type="text/javascript">
//判断该书是否被购买
function judge(id,content){
	console.info(id)
	$.get('judge',{
		id:id
	},function(data){
		console.log(data)
		if(data!=null&&data!=""){
			var str = '';
			window.location.href = 'article?id='+id+'&character='+content;
		}else{
			console.log(data)
			read(id,content);
		}
	});
}
function read(id,content){
	console.log(id,content)
	$.get('spend',{
		param:id
	},function(data){
		console.log(data)
		if(data==-1){
			alert('请先登录');
		}else if(data==0){
			alert('积分不够');
		}else{
			var str = '';
			window.location.href = 'article?id='+id+'&character='+content;
			//$('#book"'+id).attr('href',str); 
		}
		
	});
}

</script> 
<div class="fx clear">
    <div class="bdsharebuttonbox right"><span class="left">分享到： </span><a href="#" class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a href="#" class="bds_renren" data-cmd="renren" title="分享到人人网"></a><a href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a href="#" class="bds_more" data-cmd="more"></a></div>
    <script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdPic":"","bdStyle":"0","bdSize":"16"},"share":{},"selectShare":{"bdContainerClass":null,"bdSelectMiniList":["qzone","tsina","tqq","renren","weixin"]}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];
    </script> 
</div> <!--分享标签-->
 
 <div class="comment">
      <div class="tit"><h4>评论</h4> (${detailBook.bCommcount == null ? 0: detailBook.bCommcount}) <a href="javascript:;" class="right">更多</a></div>
      
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
 </div> <!--评论结束-->
</div><!--右边结束-->

<%@ include file="common/list.jsp"%>
<%@ include file="common/footer.jsp" %>

</body>
</html>