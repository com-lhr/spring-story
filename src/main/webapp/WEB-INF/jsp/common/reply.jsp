<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--回复框-->
<div class="com_con clear hui">
	<div class="portrait left mar_top">
		<img src="${loginedUser == null ? 'img/avatar.jpg' : loginedUser.uImage }"><br /> <span>当前用户${loginedUser.uName}回复</span>
	</div>
	<form action="" method="get" class="right kdit_w_550">
		<textarea name="content">发表评论</textarea>
		<p></p>
		<input name="bId" type="hidden" value="${detailBook.id}">
		<input name="otherCommid" class="otherCommid" type="hidden" value="${c.id}"/>
		<input type="button" value="提交" class="ease">
	</form>
</div>
