<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<mete  ttp-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>频道列表页</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/index.css" rel="stylesheet" type="text/css">
<link  href="css/index_article.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>

<script src="js/list.js"></script>
<script src="js/list_1.js"></script>

</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box clear">
	<%@ include file="common/list.jsp" %>
 <div class="con left">
   <div class="position"><a href="javascript:;">首页</a> > 搜索结果</div>
   <ul class="con_list clear">
   	   <c:forEach items="${searchBook }" var="sbook">
       <li class="ease">
       <a href="javascript:;"><img src="img/article2.jpg"></a>
       <div class="sm">
       <p> <a href="arcticle3.html">有声阅读</a> 
        <a href="detail?id=${sbook.id }">在线阅读</a> </p>
       <p> <a href="#"><span class="icon down"></span>下载</a> 
        <a href="#" onclick="javascript:addColl(${sbook.id });"><span class="icon sc"></span>收藏</a></p>
       </div>
       <p class="s_n"><a href="javascript:;">${sbook.bName }</a></p>
       </li>
       </c:forEach>
   </ul>
   <!--列表内容-->
   <input id="id" type="hidden"  value="${param.id }">
 <!--   <ul class="page clear">
        <li>首页</li>
        <li>上一页</li>
        <li><a id="p1" href="javascript:;" class="thispage">1</a></li>
        <li><a id="p2" href="javascript:;">2</a></li>
        <li><a id="p3" href="javascript:;">3</a></li>
        <li><a id="p4" href="javascript:;">4</a></li>
        <li><a id="p5" href="javascript:;">5</a></li>
        <li><a href="javascript:nextpage();">下一页</a></li>
       <li><a href="javascript:;">尾页</a></li>
       <li class="tz"><select id = "select">
       
       </select><a href="javascript:;">跳转</a>
       </li>
       <li>共 1/3 页</li>
   </ul> --><!--分页-->
   
 </div><!--右边内容页-->

</div><!--中间内容区-->

<%@ include file="common/footer.jsp" %>
<script type="text/javascript">
var id = $('#id').val();
/* alert(id); */
$.get(
	"pagecount",
	{id:id},
	function(data){
		var count = parseInt(data);
		var str='';
		for(var i=1;i<=count;i++){
			str+='<option value="'+count+'">'+count+'</option>';
		}
		$("#select").html(str);
	}
	)


function nextpage(){
	/* alert($(".thispage").text());
	alert($(".thispage").attr("id")); */
	if($(".thispage").attr("id")!='p5'){
		var page = parseInt($(".thispage").text())+1;
		/* alert(page); */
		$(".thispage").removeAttr("class");
		var id = '#p'+page;
		$(id).attr('class','thispage');		
	}
}

</script>
</body>
</html>
