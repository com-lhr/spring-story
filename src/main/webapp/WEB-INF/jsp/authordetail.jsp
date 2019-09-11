<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html>
<meta charset="utf-8">
<title>大神简介</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/arcticle2.css" rel="stylesheet" type="text/css">
<link  href="css/index.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/list.js"></script>
<script src="js/comment.js"></script>
<script type="text/javascript" src="js/MyPage.js"></script>
<style>
.fx{ margin-bottom:30px;}

.page0{
	padding-left: 5%;
}

.page0 ul {
	padding: 0;
	min-width: 450px;
}

.page0 ul::after {
	content: '';
	display: block;
	clear: both;
}

.page0 ul li {
	float: left;
	width: auto;
	min-width: 32px;
	height: 30px;
	line-height: 30px;
	list-style: none;
}

.page0 a {
	color: #aaa;
	font-family: "微软雅黑";
	padding: 0 10px;
	text-decoration: none;
	display: block;
	text-align: center;
	border: 1px solid #ccc;
	border-left: none;
}

.page0 ul li:first-child a {
	border-left: 1px solid #ccc;
}

.page0 ul li a:hover {
	background-color: dodgerblue;
}

.page0 ul li a:hover {
	color: white;
}

.page0 .disabled a:hover {
	background-color: white;
	cursor: not-allowed;
	color: #aaa;
}

.page0 .active a {
	background-color: dodgerblue;
	color: white;
}
</style>


</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box clear">
 <div class="list">
  <div class="pos">
     当前位置：<a href="toindex">首页</a> ><a href="javascript:;">${author.uName}</a>
  </div>
  <h3></h3>

 <ul class="tab clear">
     <li class="active"><a href="#">简介</a></li>
 </ul>
  <div class="tab_1">
    <div class="info clear">
     <img src="${author.uImage == null ? 'img/album.jpg':author.uImage }" class="left" style="margin-right:20px;width:150px;"> <p class="left" style="width:580px; overflow:hidden;">${author.uIntroduction}
    </p>
     </div>
  
  </div><!--简介介绍-->
 
<div class="box">
  <div class="box_1 box_con">
    <h3>本站收录的作品</h3>
    <ul class="clear">
    <c:forEach items="${bookofauthor }" var="bot">
    <li><a href="detail?id=${bot.id }"><img src="${bot.bFace }"></a>
    <p><a href="detail?id=${bot.id }">${bot.bName }</a></p>
    </li>
    </c:forEach>
    </ul>
  </div>
  </div>
</div>

</div>
<%@ include file="common/footer.jsp" %>
</body>
</html>