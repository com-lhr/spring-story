<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/sign.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/sign.js"></script>
<style>
.submit{ margin-left:73px;}
</style>
<script>
$(function(){
	
	(function()
	{
		var Name=/^\s*[\w\.\@\u4e00-\u9fa5]{2,20}\s*$/;
		var Pwd=/^\s*[\w]{6,9}\s*$/;
		var ver=/\s*[\w]{5,5}\s*$/;
		
		/*匹配中文字符的正则表达式： [\u4e00-\u9fa5]
        匹配双字节字符(包括汉字在内)：[^\x00-\xff]*/
		
		reg($('.text_1'),Name);
		reg($('.text_3'),Pwd);
		reg($('.style_none'),ver);
		
		$('.submit').click(function()
		{
			if(!Name.test($('.text_1').val()))
			{
				$('.text_1').siblings('.none').slideDown('slow');
				$('.text_1').siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!Pwd.test($('.text_3').val()))
			{
				$('.text_3').siblings('.none').slideDown('slow');
				$('.text_3').siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!ver.test($('.style_none').val()))
			{
				$('.style_none').siblings('.none').slideDown('slow');
				$('.style_none').siblings('.none').find('i').css('color','red');
				return false;
			}
			$.post("userLogin", { uName: $('.text_1').val(), uPwd: $('.text_3').val() },
				function(data){
					if(data.code == 1){
						alert('登录成功');
						window.location.href="toindex";
					}else{
						alert(data.msg);
					}
					
			});
			/*
			
			提交表单
			*/
		});
	})();
});
</script>
</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box">
<h3>用户登录   <span class="right">还没有账号 点击<a href="javascript:;">注册</a></span></h3>

       <div class="menu_3">
         <form  id="user_name">  
          <p><span>用户名：</span> <input type="text" name="uName" value="" class="text_1" placeholder="用户名/邮箱">
             <br/><span  class="none"> <em>*</em><i>请输入正确的用户名</i></span>
           </p>
          <p><span>密 &nbsp; &nbsp;码：</span> <input type="password" name="uPwd"  class="text_3">
              <br/><span  class="none">  <em>*</em><i>请输入正确的密码</i></span>
          </p>
          <p style=" margin-left:70px;"><input  type="checkbox" value="1" name="cookie">两周内免登录 <a href="pass.html">忘记密码</a></p>
          <p><input type="button"  value="提交"  class="submit"></p>
          <p><span>使用其他帐号直接登录</span>  <a href="javascript:;">腾讯QQ</a> <a href="javascript:;">新浪微博</a></p>
          </form>
       </div>
       
</div>
<footer class="clear">
    <p>阅读天地是学习分享平台，如对本站有意见和建议请<a href="javascript:;">留言</a></p>
    <p>本站所有信息仅用于学习交流，不用商业用途   Powered by 阅读天地</p>
</footer><!--底部结束-->
</body>
</html>