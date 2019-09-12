<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>忘记密码--输入新密码</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/sign.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/sign.js"></script>
<script type="text/javascript" src="js/from.js"></script>
<script type="text/javascript" src="js/jQuery.md5.js"></script>
<style>
.submit{ margin-left:82px;}
</style>

</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box">
<h3>找回密码   <span class="right">还没有账号 点击<a href="javascript:;">注册</a></span></h3>

       <div class="menu_3">
         <form  id="user_name" method="post" action="forgetpass">  
         <p><span>  &nbsp;用 户 名：</span> <input type="text" name="uName" value="" class="text_1"   autocomplete="off"  required>
             <br/><span  class="none"> <em>*</em><i>不存在此用户名</i></span>
           </p>       
          <p><span> &nbsp;新 密 码：</span> <input type="password" name="pwd"  class="text_3"   autocomplete="off" required>
              <br/><span  class="none">  <em>*</em><i>密码6---9个字符，下划线英文数字组合</i></span>
          </p>
          <input name="uPwd" type="password" hidden/>
        <p><span>确认密码：</span> <input type="password" name="pwd2"  class="text_3"   autocomplete="off" required>
              <br/><span  class="none">  <em>*</em><i>两次密码不一致</i></span>
          </p>
          <p><span> 邮 &nbsp; &nbsp; &nbsp;箱：</span> <input type="text" name="uEmail"  class="text_2" placeholder="电子邮件"  autocomplete="off" required>
              <br/><span  class="none">  <em>*</em><i>请输入正确的邮箱</i></span>
          </p>
                    
          <p><span> &nbsp;验&nbsp; 证&nbsp; 码：</span><input onblur="er()" class="style_none" type="text" name="ver" id="code" placeholder="请输入验证码">
			<a class="btn"  id="sendMobileCode">
			    <input type="button" id="btn" value="获取验证码" onclick="sendemail()" />
			</a>
			<br><span id="sver"  class="none">  <em>*</em><i>请输入正确的验证码</i></span>
           </p>
          <p><input type="submit"  value="提交保存"  class="submit"></p>
          </form>
       </div>
</div>
<%@ include file="common/footer.jsp"%>

<script>
var countdown = 60;
var isover = false;
var code = 0;
function sendemail() {
	$.get("mail",{uEmail:$('input[name="uEmail"]').val()},
			function(data){
				if(data.code == 0){					
					code = data.data;
					alert(data.msg);
				}else{
					alert(data.msg);
				}	
	});
    var obj = $("#btn");
    settime(obj);
}

function settime(obj) { //发送验证码倒计时	
    if (countdown == 0) {
        obj.attr('disabled', false);
        //obj.removeattr("disabled");
        obj.val("获取验证码");
        countdown = 60;
        return;
    } else {
        obj.attr('disabled', true);
        obj.val("重新发送(" + countdown + ")");
        countdown--;
        var e = er()
        if( e == true){
        	isover = true;
        } 
    } 
    setTimeout(function() {
        settime(obj)
    }, 1000)
}

function er(){
	var ver = $('input[name="ver"]').val();
	if(ver != code || ver ==null ||ver == 0){
		$('.style_none').siblings('.none').find('i').show();
		$('.style_none').siblings('.none').find('em').show();
		$('.style_none').siblings('.none').slideDown('slow');
		$('.style_none').siblings('.none').find('i').css('color','red');
		return false;
	}else if(ver == code && ver != 0 &&ver != null){
		$('.style_none').siblings('.none').find('i').hide();
		$('.style_none').siblings('.none').find('em').hide();
		return true;
	}
}
$(function(){
	(function()
		{
			$("#user_name").ajaxForm(function(data){    
				 if(data.code=="1"){  
				    alert(data.msg);    
				    window.location.href="tologin";
				 }else{
				   	alert(data.msg);
			}  
		});		
	})();
	
	(function()
	{	
		var name=/^\s*[\w\.\@\u4e00-\u9fa5]{2,20}\s*$/;
       	var pwd=/^\s*[\w]{6,9}\s*$/;
		var ver=/\s*[\w]{5,5}\s*$/;
		var email=/^\s*([a-zA-Z0-9][\w\.]{2,15})+@([a-zA-Z0-9]{2,5})+\.([a-zA-Z0-9]{2,5})\s*$/;
		
		/*匹配中文字符的正则表达式： [\u4e00-\u9fa5]
        匹配双字节字符(包括汉字在内)：[^\x00-\xff]*/
		
		reg($('.text_1'),name);
		reg($('.text_2'),email);
		reg($('.text_3').eq(0),pwd);
		equal($('.text_3').eq(1),$('.text_3').eq(0))
		reg($('.style_none'),ver);
		
		$('.submit').click(function()
		{
			if(!name.test($('.text_1').val()))
			{
				$('.text_1').siblings('.none').slideDown('slow');
				$('.text_1').siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!pwd.test($('.text_3').eq(0).val()))
			{
				$('.text_3').eq(0).siblings('.none').slideDown('slow');
				$('.text_3').eq(0).siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!pwd.test($('.text_3').eq(1).val()))
			{
				$('.text_3').eq(1).siblings('.none').slideDown('slow');
				$('.text_3').eq(1).siblings('.none').find('i').css('color','red');
				return false;
			}
			if($('.text_3').eq(1).val()!==$('.text_3').eq(0).val())
			{
				$('.text_3').eq(1).siblings('.none').slideDown('slow');
				$('.text_3').eq(1).siblings('.none').find('i').css('color','red');
				return false;
			}else{
				$('input[name="uPwd"]').val($.md5($('.text_3').eq(1).val()));
			}
			
			var a = er();
			
			if(a == false){
				return false;				
			}
			
			if(isover == false){
				alert('验证码超时');
				return false;
			}
			/*
			
			提交表单
			*/
		});
		
	})();
});
</script>
</body>
</html>