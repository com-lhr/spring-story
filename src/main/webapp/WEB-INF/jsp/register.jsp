<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>注册</title>
<link  href="css/css.css" rel="stylesheet" type="text/css">
<link  href="css/sign.css" rel="stylesheet" type="text/css">
<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/sign.js"></script>
<style>
.submit{ margin-left:82px;}
</style>

</head>

<body>
<%@ include file="common/header.jsp" %>

<div class="box">
<h3>注册账号   <span class="right">还没有账号 点击<a href="javascript:;">注册</a></span></h3>

       <div class="menu_3">
         <form  id="user_name" method="post" enctype="multipart/form-data" action="register">  
          <p><span>用 户 名：</span> <input type="text" name="uName" value="" class="text_1" placeholder="用户名/邮箱"   autocomplete="off" required>
             <br/><span  class="none"> <em>*</em><i>用户名2~10位</i></span>
           </p> 
            <input name="uPwd" type="password" hidden />     
          <p><span> &nbsp;新 密 码：</span> <input type="password" name="pwd1"  class="text_3"   autocomplete="off" required>
              <br/><span  class="none">  <em>*</em><i>密码6---9个字符，下划线英文数字组合</i></span>
          </p>
        <p><span>确认密码：</span> <input type="password" name="pwd2"  class="text_3"   autocomplete="off" required>
              <br/><span  class="none">  <em>*</em><i>两次密码不一致</i></span>
          </p>
         <div class="clear" id="divImg"><label class="left">设置头像：</label>
               <div class="up_fm">
               <span class="icon fm_icon"></span>
               <img src="img/avatar.jpg" id="fm_img" class="fm_img"> 
               <span class="icon fm_colse"></span>
               </div>
         </div><!--设置封面-->
         <div class="up_img">
              <span  class="icon up_img1">上传图片</span>
              <input type="file" name="img" class="up_img2" onChange="change_photo()"><!--multiple-->
              <br/><i style="margin-left:0px;">文件大小≤3M,尺寸最好200X200--300X300 </i><!--当改变时，上传图片，ajax提交返回图片地址-->
          </div>
          <p><span>电&nbsp; &nbsp; &nbsp;话：</span> <input type="text" name="uTel" value="" class="text_4" placeholder="电话"   autocomplete="off" required>
             <br/><span  class="none"> <em>*</em><i>请输入正确的电话</i></span>
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
          <p><input type="submit"  value="提及保存"  class="submit"></p>
          </form>
       </div>
</div>

<script type="text/javascript" src="js/from.js"></script>
<script type="text/javascript" src="js/jQuery.md5.js"></script>
<script>
var countdown = 60;
var isover = false;
var code = 0;

function sendemail() {
	$.get("mail",{uEmail:$('input[name="uEmail"]').val()},
			function(data){
				if(data.code == 0){					
					code = data.data;
					alert(data.msg+code);
				}else{
					alert(data.msg);
				}	
	});
    var obj = $("#btn");
    settime(obj);
}
function change_photo() {
	PreviewImage($("input[name='img']")[0], 'fm_img', 'divImg');
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
	}else if(ver == code ){
		$('.style_none').siblings('.none').find('i').hide();
		$('.style_none').siblings('.none').find('em').hide();
		return true;
	}
}

$(document).ready(function(e) {
   (function()
	{
		var fm_img=$('.up_fm .fm_img');
		var fm_del=$('.up_fm .fm_colse');
		var file=$('.up_img .up_img2');
		fm(file.eq(0),fm_img.eq(0),fm_del.eq(0));
	})();//设置头像
	
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
		var email=/^\s*([a-zA-Z0-9][\w\.]{2,15})+@([a-zA-Z0-9]{2,5})+\.([a-zA-Z0-9]{2,5})\s*$/;
		var pwd=/^\s*[\w]{6,9}\s*$/;		
		var tel=/^([1]\d{10}|([\(（]?0[0-9]{2,3}[）\)]?[-]?)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?)$/;
		
		reg($('.text_1'),name);
		reg($('.text_2'),email);
		reg($('.text_3').eq(0),pwd);
		equal($('.text_3').eq(1),$('.text_3').eq(0));
		reg($('.text_4'),tel);
		
		
		$('.submit').click(function()
		{
			if(!name.test($('.text_1').val()))
			{
				$('.text_1').siblings('.none').slideDown('slow');
				$('.text_1').siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!tel.test($('.text_4').val()))
			{
				$('.text_4').siblings('.none').slideDown('slow');
				$('.text_4').siblings('.none').find('i').css('color','red');
				return false;
			}
			if(!email.test($('.text_2').val()))
			{
				$('.text_2').siblings('.none').slideDown('slow');
				$('.text_2').siblings('.none').find('i').css('color','red');
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
			if($('.text_3').eq(1).val()!=$('.text_3').eq(0).val())
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
<%@ include file="common/footer.jsp" %>
</body>
</html>
