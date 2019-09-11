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
	<%@ include file="common/list.jsp" %>
 <div class="con left">
   <div class="position"><a href="javascript:;">首页</a> > <a href="javascript:;">文学类</a> > <a href="javascript:;"  class="acative">现代文学</a></div>
   <div class="bidList" style="display: none;">${bookList }</div>
   <ul class="con_list clear">
   	   <c:forEach items="${category_pagebooks }" var="cpb">
       <li class="ease">
       <a href="javascript:;"><img src="${cpb.bFace }"></a>
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
       <p class="s_n"><a href="javascript:;">${cpb.bName }</a></p>
       </li>
       </c:forEach>
   </ul>
   <!--列表内容-->
   <input id="id" type="hidden"  value="${param.id }">
   <ul class="page clear">
        <li>首页</li>
        <li>上一页</li>
        <li><a id="p1" href="javascript:void(0);"  onclick="thispage(this);" class="thispage">1</a></li>
        <li><a id="p2" href="javascript:void(0);"  onclick="thispage(this);">2</a></li>
        <li><a id="p3" href="javascript:void(0);"  onclick="thispage(this);">3</a></li>
        <li><a id="p4" href="javascript:void(0);"  onclick="thispage(this);">4</a></li>
        <li><a id="p5" href="javascript:void(0);"  onclick="thispage(this);">5</a></li>
        <li><a href="javascript:nextpage();">下一页</a></li>
       <li><a href="javascript:;">尾页</a></li>
       <li class="tz"><select id = "select">
       
       </select><a href="javascript:;">跳转</a>
       </li>
       <li>共 1/3 页</li>
   </ul><!--分页-->
   
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

	//分页的页面跳转
	function thispage(thispage){
		var id = $('#id').val();
		var value =thispage.innerText;
		$(".thispage").removeAttr("class");
		var thispage = '#p'+value;
		$(thispage).attr('class','thispage');
		var pagenum = $('.thispage').text();
		/* alert(pagenum); */
		/* location.href = "artCategory?id="+id+'&page='+pagenum; */
		showPage(id,pagenum);
	}
	
	function showPage(id,page){
		var pagenum = page;
		$.get(
				"pageartCategory",
				{id:id,page:pagenum},
				function(data){
					var li =${bookList};
					$('.con_list').empty();
					/* alert(data[0].bName); */
					str='';
					for(var i=0;i<data.length;i++){
						var bid = data[0].id;
						if($.inArray(data[i].id, li)==-1){
							str+='<li class="ease">'+
						       '<a href="javascript:;"><img src="'+data[i].bFace+'"></a>'+
						       '<div class="sm">'+
						       '<p> <a href="arcticle3.html">有声阅读</a> '+
						        '<a href="detail?id='+data[i].id+'">在线阅读</a> </p>'+
						       '<p> <a href="#"><span class="icon down"></span>下载</a> '+
						        '<a href="#" onclick="javascript:addColl('+data[i].id+')" class="coll'+data[i].id+'">'+
						        '<span class="icon sc" ></span>收藏'+
						        '</a></p>'+
						       '</div>'+
						       '<p class="s_n"><a href="javascript:;">'+data[i].bName+'</a></p>'+
						       '</li>';
						}else{
							str+='<li class="ease">'+
						       '<a href="javascript:;"><img src="'+data[i].bFace+'"></a>'+
						       '<div class="sm">'+
						       '<p> <a href="arcticle3.html">有声阅读</a> '+
						        '<a href="detail?id='+data[i].id+'">在线阅读</a> </p>'+
						       '<p> <a href="#"><span class="icon down"></span>下载</a> '+
						        '<a href="#" onclick="javascript:addColl('+data[i].id+')">'+
						        '<span class="icon sc" style="background-position:-40px -20px;"></span>收藏'+
						        '</a></p>'+
						       '</div>'+
						       '<p class="s_n"><a href="javascript:;">'+data[i].bName+'</a></p>'+
						       '</li>';
						}
						   
					}
					$('.con_list').html(str);
					$('.ease').hover(function()
							{
							  $(this).find('.sm').slideDown('fast','linear');
							},function()
							{
							  $(this).find('.sm').slideUp('fast','linear'); 
							});
				}
			)
	}
$('.ease').hover(function()
		{
		  $(this).find('.sm').slideDown('fast','linear');
		},function()
		{
		  $(this).find('.sm').slideUp('fast','linear'); 
		});
	
function nextpage(){
	/* alert($(".thispage").text());
	alert($(".thispage").attr("id")); */
	if($(".thispage").attr("id")!='p5'){
		var page = parseInt($(".thispage").text())+1;
		/* alert(page); */
		$(".thispage").removeAttr("class");
		var id = '#p'+page;
		$(id).attr('class','thispage');
		var id = $('#id').val();
		var pagenum = $('.thispage').text();
		showPage(id,pagenum);
	}
}

//添加收藏夹
function addColl(bid){
	$.get('addColl',{
		bid:bid
	},function(data){
		if(data==1){
			alert('添加成功');
			var page = $(".thispage").text();
			var str='';
			str+='<span class="icon sc" style="background-position:-40px -20px;"></span>收藏';
			$('.coll'+bid).html(str);
		}else if(data==0){
			alert('请先登录')
		}else{
			alert('已添加')
		}
	});
}
</script>
</body>
</html>
