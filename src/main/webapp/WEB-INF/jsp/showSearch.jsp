<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<div class="list2">
           <div class="one">
               
            </div><!--新书上架结束-->
         
         <div class="two">
           <p><a href="javascript:;" class="active">阅读排行</a><a href="javascript:;">本月最热排行</a></p>
                   <ul class="active">
                   <c:forEach items="${book_readCnt }" var="brc">
                    <li><a href="detail?id=${brc.id }">${brc.bName }</a></li>
                   </c:forEach>
                   </ul>
                    <ul id="ul2">
                     <c:forEach items="${book_readcount }" var="brct">
                    <li><a href="detail?id=${brct.id }">${brct.bName }</a></li>
                   </c:forEach>
                   </ul>
         </div><!--tab切换-->
       <script type="text/javascript">
       		$(".two>p>a").click(function(){
       			var op =$(this).text();
       			if(op=="阅读排行"){
       				$('.active').removeAttr("class");
       				$(this).attr("class","active");
       				$(".two>ul:first").attr("class","active");       				
       			}else{
       				$('.active').removeAttr("class");
       				$(this).attr("class","active");
       				$("#ul2").attr("class","active");  
       			}
       		})
       </script>
     </div>
 <div class="con left">
   <div class="position"><a href="javascript:;">首页</a> > 搜索结果</div>
   <ul class="con_list clear">
   	    <c:forEach items="${searchBook }" var="cpb">
       <li class="ease">
       <a href="detail?id=${cpb.id }"><img src="${cpb.bFace }"></a>
       <div class="sm">
       <p> <a href="arcticle3.html">有声阅读</a> 
        <a href="detail?id=${cpb.id }">在线阅读</a> </p>
       <p> <a href="#"><span class="icon down"></span>下载</a>
       <!-- style="background-position:-40px -20px;" --> 
        <a href="#" onclick="javascript:addColl(${cpb.id })" class="coll${cpb.id }">
        <c:if test="${fn:contains(bookList,cpb.id )}">
        <span class="icon sc" style="background-position:-40px -20px;"></span>收藏
        </c:if>
        <c:if test="${fn:contains(bookList,cpb.id )!=true}">
        <span class="icon sc" ></span>收藏
        </c:if></a></p>
       </div>
       <p class="s_n"><a href="detail?id=${cpb.id }">${cpb.bName }</a></p>
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
