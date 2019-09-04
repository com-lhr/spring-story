<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<style>
    *{margin:0;paddign:0;font-family:"微软雅黑";font-style:normal;font-size:14px;}
    .dropdown{position: relative;display:inline-block;width: 300px;padding-left:10px; }
    /* .dropdown-selected{width: 100%!important;height:30px;line-height:30px;border:1px solid #c6c8cc;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;color:#333;text-indent: 10px;margin-bottom: 0!important;}
 */    .dropdown ul{padding:0;width:100%;max-height:200px;overflow-y:auto ;background-color:#fff;margin-top:2px;border:1px solid #c6c8cc;position:absolute;display:none;z-index: 2;}
    .dropdown ul li{list-style: none;text-indent:10px;}
    .dropdown ul li a{display:block;color:#282c33;text-decoration:none;overflow: hidden;text-overflow:ellipsis;white-space: nowrap;}
    .dropdown ul li:hover{background-color:#f2f6fa;}
    .dropdown ul li a:active,.dropdown ul li.active a{background-color: #e4e9f2;}
</style>
<header class="clear">
<img src="img/logo.jpg" >
<div class="logo">
    <h1>阅读天地</h1>
    <div class="clear"></div>
    <p>想看既看，想听既听得阅读</p>
</div>
<div  style="width:50%;  margin-left:400px ; padding-top:80px ">
    <h3 style="display:inline-block;padding-right:10px;border-right:1px solid #ddd;font-size:18px;">请输入关键字</h3>
    <div class="dropdown" id="search" onclick="search.changeValue(this);search.searchKeyword()">
        <input type="text"  value=""   class="dropdown-selected"
               id="search-input" placeholder="请输入关键字"  onkeypress="searchname();" onkeyup="search.searchKeyword();">
        <input type="button" value="搜索" onclick="dosearch();" >
        <ul id="ts">
           
        </ul>
    </div>

<!-- </div>
<div class="search left">
    <form  action="" method="get">
        <input type="text" value="" placeholder="请输入书名或作者名称">
        <input type="submit" value="搜索">
    </form> -->
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
      <a href="${loginedUser == null ? 'tologin' : ''}" class="clear">${loginedUser == null ? 'Hi,请登录'  :   '欢迎：'.concat(loginedUser.uName)}<span class="icon ease"></span></a>
      <div class="clear"></div>
       <ul  class="clear">
         <li><a href="collect">个人中心</a></li>
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
    <li><a href="toindex">首页</a></li>
    <c:forEach items="${cList}" var="c">
    	<li><a href="artCategory?id=${c.id }">${c.caName}</a></li>
    </c:forEach>  
   
    <div class="submission">
    <a href="javascript:;"><span class="icon_span"></span>我要投稿</a>
    </div>
    </ul>
</nav><!--导航结束-->
<script src="js/jquery.js"></script>
<script type="text/javascript">

function dosearch(){
	   var name=$("#search-input").val();
	   if(name!=""&&name!=null){
		   location.href="doSearch?name="+name;   
	   }
}
var t;

function searchname(){
	var name = $("#search-input").val();
	clearTimeout(t);
	t = setTimeout(function(){
		$.get(
			"searchbookname",
			{name:name},
			function(data){
				var str = '';
				for(var i=0;i<data.length;i++){
					str+='<li><a href="javaScript:">'+data[i].bName+
					'</a></li>';
				}
				$('#ts').html(str);
			})		
	}, 1000);
}

    var search = {
        searchKeyword: function () {
            var nWord = $("#search-input").val();
            //var temarray = nWord.split(""); //分割
            var array=this.unique(nWord.split(""));
            var dsa = $("#search").find("ul li a");//获取全部列表
            var linumber = 0;

            $("#search ul li").show();
            for (var t = 0; t < dsa.length; t++) {
                $(dsa[t]).html($(dsa[t]).text());
                var temstr = ($(dsa[t]).text()).split("");
                var yes = false;
                for (var i = 0; i < array.length; i++) {
                    var posarr = this.findAll(temstr, array[i]);
                    if (posarr.length > 0) {
                        yes = true;
                        for (var j = 0; j < posarr.length; j++) {
                            temstr[posarr[j]] = "<em style='color:red;'>" + temstr[posarr[j]] + "</em>";
                        }
                    }
                }
                if (!yes) {
                    $(dsa[t]).closest("li").hide();
                }
                else {
                    linumber++;
                    var htmlstr = "";
                    for (var m = 0; m < temstr.length; m++) {
                        htmlstr += temstr[m];
                    }
                    $(dsa[t]).html(htmlstr);
                }

            }
            if (linumber == 0) {
                $("#search ul li").show();
                $("#search ul").slideDown(200);
            }
        },
        findAll: function (arr, str) {
            var results = [],
                len = arr.length,
                pos = 0;
            while (pos < len) {
                pos = arr.indexOf(str, pos);
                if (pos === -1) {
                    break;
                }
                results.push(pos);
                pos++;
            }
            return results;
        },
        unique: function (arr) {
            var new_arr = [];
            for (var i = 0; i < arr.length; i++) {
                var items = arr[i];
                //判断元素是否存在于new_arr中，如果不存在则插入到new_arr的最后
                if ($.inArray(items, new_arr) == -1) {
                    new_arr.push(items);
                }
            }
            return new_arr;
        },
        changeValue: function (obj) {
            $('.dropdown ul').slideUp(200);
            var input = $(obj).find('.dropdown-selected');
            var ul = $(obj).find('ul');
            if (!ul.is(':visible')) {
                ul.slideDown('fast');
            } else {
                ul.slideUp('fast');
            }

            $(obj).find('ul a').click(function () {
                input.val($(this).text());
                $(this).parent().addClass('active');
                $(this).parent().siblings().removeClass('active')
                $(this).closest('ul').slideUp(200);
                return false;
            })
            var e = this.getEvent();
            window.event ? e.cancelBubble = true : e.stopPropagation();
        },
        _init: function () {
            $("#search").on("click", "ul li a", function () {
                $("#search-input").val($(this).text());
                $(this).parent().addClass('active');
                $(this).parent().siblings().removeClass('active')
                $(this).closest('ul').slideUp(200);
                return false;
            })
        },
        getEvent: function(){
        if(window.event){
            return window.event;
        }
        var f = arguments.callee.caller;
        do{
            var e = f.arguments[0];
            if(e && (e.constructor === Event || e.constructor===MouseEvent || e.constructor===KeyboardEvent)){
                return e;
            }
        }while(f=f.caller);
    }

    }
    search._init();
 </script>