<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

 <div class="list2">
           <div class="one">
                <p>相关分类新书上架</p>
                <div class="notice">
                    <ul>
                    <c:forEach items="${category_newbooks }" var="cb">
                    <li><a href="detail?id=${cb.id }">${cb.bName }</a></li>
                    </c:forEach>
                   </ul>
                </div>
            </div><!--新书上架结束-->
         
         <div class="two">
           <p><a href="javascript:;" class="active">阅读排行</a><a href="javascript:;">月票排行</a></p>
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