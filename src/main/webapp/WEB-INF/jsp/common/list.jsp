<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
 <div class="list2">
           <div class="one">
                <p>新书上架</p>
                <div class="notice">
                    <ul>
                    <c:forEach items="${category_newbooks }" var="cb">
                    <li><a href="list_info.html">${cb.bName }</a></li>
                    </c:forEach>
                   </ul>
                </div>
            </div><!--新书上架结束-->
         
         <div class="two">
           <p><a href="javascript:;" class="active">本周最热排行</a><a href="javascript:;">本月最热排行</a></p>
                   <ul class="active">
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">谢谢你曾来过我的世界</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                   </ul>
                    <ul>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">谢谢你曾来过我的世界</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">文化苦旅</a></li>
                    <li><a href="javascrip:;">谢谢你曾来过我的世界</a></li>
                   </ul>
         </div><!--tab切换-->
     </div>