// JavaScript Document
$(document).ready(function(e) {
//	(function(){
//		var but=$('.comment .com_con form').find('input');
//        but.each(function(i) {
//			$(this).click(function()
//			{
//				//$(this).parent('form').find();
//				var T=editor.text();
//				if(T=='' || T=='发表评论')
//				{ 
//				 $(this).siblings('p').text('您没有评论');
//				 $(this).siblings('p').fadeIn('slow','linear');
//				 return false;
//				}
//				else if(T.length<10)
//				{
//				 $(this).siblings('p').text('评论内容不得小于10个字符');
//				 $(this).siblings('p').fadeIn('slow','linear');
//				 return false;
//				}
//				else
//				{
//					$(this).siblings('p').fadeOut('slow','linear');
//					return true;
//				}
//			});
//		 });
//		})();
//KindEditor-----------------评论框
		
	var kg=/^[\s]*$/,val=null,prom=null;	
	
	(function(){
		var but=$('.comment .com_con form').find('input');
		var txt=$('.comment .com_con form').find('textarea');
	
		txt.each(function(i) {
		   $(this).css('color','#999');
			
		   $(this).focus(function()
		   {
			   val=$(this).val();
			   if(val=='发表评论')
			   {
				   $(this).val('');
				}
			   $(this).css('border-color','#16A1E7');
			   $(this).css('color','#333'); 
		   });//获取焦点
				   
		   $(this).blur(function(){
			   val=$(this).val();
			   prom=$(this).siblings('p');
			   if(kg.test(val))
			   {
				  $(this).css('color','#999'); 
				  $(this).val('发表评论'); 
				   prom.text('您没有评论');
				   prom.fadeIn('slow','linear'); 
			   }
				else if(val.length<10 || val=='发表评论')
				{
				  prom.text('评论内容不得小于10个字符');
				  prom.fadeIn('slow','linear');
				 return false;
				}
				else
				{
					if(!prom.is(':hidden'))
					{
					 prom.fadeOut('slow','linear');
					}
					return true;
				}
			   
			   $(this).css('border-color','#dcdcdc');  
		   });//失去焦点
		});//循环
	})();//提交评论验证
	
	(function(){
	 var fab=$('.go .com_1 .kdit_w');	
	 var hui_click=fab.find('.red');	
     var hui_con=$('.go2');
	 var j=0;
	
	hui_click.each(function(i)
	{
		 $(this).click(function()
		 {  if(++j%2==1)
			{
				$(this).text('收起');
			}
			else
			{$(this).text('展开回复'); }
			 hui_con.eq(i).slideToggle('slow','linear'); 
			
		 });   
	});//展开回复-------------展开回复--更多回复
			
	 var huifu=$('ul.com_con .go .hui');
	  colse_hui(fab,huifu);//顶级评论点击回复框
	  
	 var come=$('ul.com_con .go2 .come');	
	 var huifu2=come.find('.hui');
	 colse_hui(come,huifu2);//2级评论点击回复框

	})();//评论回复

function colse_hui(alist,ele)
{
	 alist.each(function(i)
	 {
		var obj=$(this).find('a').first();
		 obj.click(function()
		 {  
		 	 ele.eq(i).slideToggle('slow','linear');
			 ele.eq(i).find('textarea').val('发表评论');
			 ele.eq(i).find('textarea').css({'color':'#999','border-color':'#dcdcdc'});
			 if(!ele.eq(i).find('p').is(':hidden'))
			 {
				 ele.eq(i).find('p').css('display','none');
			 }
		 })//1 . 2级评论点击回复框
	 });
	
}//-----------------------------------展开关闭回复框

function reg_Exp(objParent,i,obj)
{
	z_txt=objParent.eq(i).find('textarea').val();	
	prom=obj.siblings('p');

  if(kg.test(z_txt))
   {
	   z_txt.css('color','#999'); 
	   z_txt.val('发表评论'); 
	   prom.text('您没有评论');
	   prom.fadeIn('slow','linear'); 
   }
	else if(val.length<10 || val=='发表评论')
	{
	  prom.text('评论内容不得小于10个字符');
	  prom.fadeIn('slow','linear');
	 return false;
	}	
	else
	{
	  return {t:z_txt,p:prom}
	}
}//----------------------------------------------评论验证
	
	(function(){
		var com_two=$('.comment .go2 .come');
		var txt=null,but=null;
		var bId = $('input[name="bId"]').val();
		com_two.each(function(i)
		{
		 but_two=$(this).find('.ease');
		 but_two.click(function()
		 {
			var reg=reg_Exp(com_two,i,but_two);
			if(reg)
			{
				if(!reg.p.is(':hidden'))
				{
				 $(this).siblings('p').fadeOut('slow','linear');
				}
			 
			 /*
		        ajax提交如果成功插入内容
		   
		     */
			 com_two.eq(i).after('<div class="come"><div class="com_con clear hui2"><div class="portrait left">'+
                 '<img src="img/avatar.jpg"><br/>'+
                  '<span>1922527784</span>'+
                  '</div>'+
                  '<div class="word left">'+
                  '<p><span class="user">222 回复 1111：</span>'+reg.t+'</p>'+
                  '<p class="right"><time>2001-3-4</time></p>'+
             '</div></div>'+
           '<div class="com_con clear hui">'+
              '<div class="portrait left mar_top">'+
             '<img src="img/avatar.jpg"><br/>'+
              '<span>1922527784</span></div>'+
             '<form action="" method="get" class="right kdit_w_550">'+
              '<textarea name="content">发表评论</textarea>'+
              '<p></p>'+
              '<input type="bottom" value="提交" class="ease"></form></div></div>');
			   com_two.eq(i).find('.hui').slideUp('slow','linear');
			   com_two.eq(i).find('.hui textarea').val('发表评论');
			   com_two.eq(i).find('.hui textarea').css({'border-color':'#dcdcdc','color':'#999'});
             }
		  });
        });//2级回复
		
	 var com_one=$('.comment .go');
	 var txt_one=null,but_one=null;	
	
		com_one.each(function(i) 
		{	
			 var otherCommid = $(this).find('.otherCommid').val();
           	 but_one=$(this).find('.ease');
			 but_one.click(function()
			 {
				var reg=reg_Exp(com_one,i,but_one);
			    if(reg)
				{	if(!reg.p.is(':hidden'))
					{
					 $(this).siblings('p').fadeOut('slow','linear');
					}
					//----------------------------------验证是否合法
                   /*
				    ajax提交如果成功插入内容
				   
				   */
				$.post("reply",{bId:bId,cmContent:reg.t,otherCommid:otherCommid},
					function(data){
						if(data.code == 1){
							var time = Format(data.data.cmCreatetime,"yyyy-MM-dd hh-mm-ss");
							com_one.eq(i).after('<li class="go2" style="display:block">'+
				             '<div class="come">'+
				            '<div class="com_con clear hui2">'+
				                  '<div class="portrait left">'+
				                 ' <img src="'+data.data.nextuser.uImage+'"><br/>'+
				                  '<span>'+data.data.nextuser.uName+'</span></div>'+
				                  '<div class="word left">'+
				                  '<p><span class="user">'+data.data.nextuser.uName+'回复'+data.data.user.uName+'：</span><br/>'+reg.t+'</p>'+
				                  '<p class="right"><time>'+time+'</time></p>'+
				             '</div></div>'+
				             '<div class="com_con clear hui">'+
				                  '<div class="portrait left mar_top">'+
				                 '<img src="img/avatar.jpg"><br/>'+
				                  '<span>1922527784</span></div>'+
				                  '<form action="" method="get" class="right kdit_w_550">'+
				                  '<textarea name="content" >发表评论</textarea>'+
				                  '<p></p>'+
				                  '<input type="bottom" value="提交" class="ease">'+
				                  '</form></div></div></li>');
									com_one.eq(i).find('.hui').slideUp('slow','linear');
									com_one.eq(i).find('.hui textarea').val('发表评论');
									com_one.eq(i).find('.hui textarea').css({'border-color':'#dcdcdc','color':'#999'});
						}else if(data.code == -2){
							alert('请先进行登录');
							window.location.href="tologin";
						}				
					});								
				}
			 }); 
        });//循环结束--------------------一级评论回复
		
		 function Format(datetime,fmt) {
		        if (parseInt(datetime)==datetime) {
		            if (datetime.length==10) {
		                datetime=parseInt(datetime)*1000;
		            } else if(datetime.length==13) {
		                datetime=parseInt(datetime);
		            }
		        }
		        datetime=new Date(datetime);
		        var o = {
		            "M+" : datetime.getMonth()+1,                 //月份
		            "d+" : datetime.getDate(),                    //日
		            "h+" : datetime.getHours(),                   //小时
		            "m+" : datetime.getMinutes(),                 //分
		            "s+" : datetime.getSeconds(),                 //秒
		            "q+" : Math.floor((datetime.getMonth()+3)/3), //季度
		            "S"  : datetime.getMilliseconds()             //毫秒
		        };
		        if(/(y+)/.test(fmt))
		            fmt=fmt.replace(RegExp.$1, (datetime.getFullYear()+"").substr(4 - RegExp.$1.length));
		        for(var k in o)
		            if(new RegExp("("+ k +")").test(fmt))
		                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
		        return fmt;
		    }		
		
		var z_p=$('.comment .zong');
		var z_c=$('.comment ul.com_con');
		var bId = $('input[name="bId"]').val();
		z_p.find('.onSubmit').click(function()				
		{
			
			 var reg=reg_Exp(z_p,0,z_p.find('.button'));
			if(reg)
			{ if(!reg.p.is(':hidden'))
				{
				 $(this).siblings('p').fadeOut('slow','linear');
				}
				//	return true;
           /*
		        ajax提交如果成功插入内容
		   
		   */
			console.log(bId+reg.t);
			$.post("comment",{bId:bId,cmContent:reg.t},
					function(data){
				if(data.code == 1){					
						alert('评论成功');						
						var time1 = Format(data.data.cmCreatetime,"hh-mm-ss");
						var time2 = Format(data.data.cmCreatetime,"yyyy-MM-dd");
						var h='<div class="com_bor"></div>';
						z_c.prepend(h);
						z_c.find('.com_bor').eq(0).css('display','none');
						
					   var html='<li class="go">'+
						 '<div class="com_1 clear">'+
							  '<div class="portrait left">'+
								  '<img src="'+data.data.user.uImage+'"><br/>'+
								 '<span>'+data.data.user.uName+'</span></div>'+
							 '<div class="word left kdit_w">'+
							 '<p class="time">在'+time1+'评论：</p><br>'+
								 '<p>'+reg.t+'</p>'+
								  '<p class="right"><time>'+time2+'</time></p>'+
						  '</div></div>'+
						  '<div class="com_con clear hui">'+
								  '<div class="portrait left mar_top">'+
								  '<img src="img/avatar.jpg"><br/>'+
								  '<span>1922527784</span></div>'+
								  '<form action="" method="get" class="right kdit_w_550">'+
								  '<textarea name="content"  >发表评论</textarea>'+
								  '<p></p>'+
								  '<input type="bottom" value="提交" class="ease">'+
								  '</form></div><!--回复框--></li></div>';
							
							z_c.find('.com_bor').eq(0).prepend(html);
							z_c.find('.com_bor').eq(0).slideDown('slow','linear');
						
					}else if(data.code == -2){
						alert('请先进行登录');
						window.location.href="tologin";
					}
				
				});
			
			 }
			
			
		});//第一次评论
		
		$('.comment .tit .right').click(function()
		 {
			 $(this).css('color','#16A1E7');
			$('.comment .page').slideDown('slow','linear');
			
		 });//显示分页
		
	})();//回复
});	