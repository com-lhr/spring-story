<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<header class="clear">
<img src="img/logo.jpg" >
<div class="logo">
    <h1>阅读天地</h1>
    <div class="clear"></div>
    <p>想看既看，想听既听得阅读</p>
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
<!-- <div class="delu">
    <a  href="javascript:;">登录</a>
    <span>|</span>
    <a  href="javascript:;">注册</a>
  </div>-->
  <div class="delu2 clear">
      <div class="self ease">
      <a href="javascript:;" class="clear">雪剑无影<span class="icon ease"></span></a>
      <div class="clear"></div>
       <ul  class="clear">
         <li><a href="self.html">个人中心</a></li>
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
    <a  href="tousu.html">意见反馈</a>
 </div>
</header><!--头部结束-->


<nav class="clear">
    <ul class="nav_1 clear">
    <div class="active"></div>
    <li><a href="javascript:;">首页</a></li>
    <c:forEach items="${cList}" var="c">
    	<li><a href="javascript:;">${c.caName}</a></li>
    </c:forEach>  
   
    <div class="submission">
    <a href="javascript:;"><span class="icon_span"></span>我要投稿</a>
    </div>
    </ul>
</nav><!--导航结束-->