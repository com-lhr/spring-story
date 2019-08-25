<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>首页</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/index.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/index.js"></script>

    <!--[if lt IE 9]>
    <script>for(var i=0,t="abbr, article, aside, audio, canvas, datalist, details, dialog, eventsource, figure, footer, header, hgroup, mark, menu, meter, nav, output, progress, section, time, video, figcaption, main".split(", ");i<t.length;i++){document.createElement(t[i]);}</script>
    <![endif]-->
</head>  

<!--[if lte IE 9]>
<body class="ie9-lt ">
<![endif]-->
<body>
<%@ include file="common/header.jsp" %>

<div class="banner clear">
    <ul>
      <li class="active"><a href="javascript:;"></a></li>  
      <li><a href="javascript:;"></a></li>  
      <li><a href="javascript:;"></a></li>  
      <li><a href="javascript:;"></a></li>  
    </ul>
    <p class="num"><a href="javascript:;" class="active"></a><a href="javascript:;"></a><a href="javascript:;"></a><a href="javascript:;"></a></p>
    <p class="left_right">
        <a href="javascript:;"></a>
        <a href="javascript:;"></a>
    </p>
</div><!--banner结束-->

<div class="box">
  <div class="box_1 box_con">
    <h3>编者推荐</h3>
    <ul class="clear">
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    <li><a href="javascript:;"><img src="img/article.jpg"></a>
    <p><a href="javascript:;">新西兰岛屿湾旅行攻略</a></p>
    </li>
    </ul>
  </div>
  
  <div class="box_2 box_con">
  <h3>最新上架</h3>
      <ul class="clear">
      <c:forEach items="${newbook }" var="b">
        <li><a href="javascript:;"><span class="icon_span"></span></a>
             <a href="javascript:;"><b>[${b.stCategory.caName } ]</b></a>
             <a href="javascript:;"><strong>${b.bName }</strong></a><time><fmt:formatDate value="${b.bTime}" 
          	pattern="yyyy-MM-dd"/></time></li>
      </c:forEach>
     </ul>
  </div>
  
  <div class="box_3 clear">
      <ul  class="author clear">
        <h4>大神</h4>
        <li>
            <a href="http://bb.com"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
            <div class="mask"></div><p>路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
            <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
        <li>
            <a href="javascript:;"><img  src="img/other.jpg">
             <div class="mask"></div><p>路遥</p></a>
        </li>
      </ul>
      <!--作者-->
  </div>
  
</div><!--内容-->

<%@ include file="common/footer.jsp" %>

</body>
</html>