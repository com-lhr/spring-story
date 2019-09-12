<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title></title>
    <link href="back/js/bstable/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="back/js/bstable/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="back/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
    <link href="back/css/table.css" rel="stylesheet" type="text/css" />
</head>
<body style="background-color: #ecf0f5;font-family: 微软雅黑;color: #475059;min-width: 1000px;overflow: auto">
<div class="news_main">
   
    <div class="l_left news_right">
        <h6>用户管理</h6>

        <div class="notice_check">
            <div class="btn-group l_left" style="margin-right: 4px">
                <button type="button" class="btn btn-default change" style="height: 30px;line-height: 15px;padding: 0 12px !important;font-size: 12px">选择条件</button>
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="height: 30px;line-height: 30px">
                    <span class="caret"></span>
                    <span class="sr-only"></span>
                </button>
                <ul class="dropdown-menu">
                    <li>用户名</li>
                    <li>电话</li>
                    <li>邮箱号</li>
                    <li>类型</li>
                </ul>
            </div>
            <div class="l_left">
                <input type="text" class="find_input"/>
            </div>
            <button class="check_btn" onclick="findUser()">查询</button>
            <div  class="notice_nav r_right">
                <a class="btn btn-default" onclick="addUser()"><span class="glyphicon glyphicon-plus"></span>新增</a>
                <a class="btn btn-default" onclick="deletechoose()"><span class="glyphicon glyphicon-remove"></span>删除</a>
                <a class="btn btn-default" onclick="addUser()"><span class="glyphicon glyphicon-pencil"></span>编辑</a>
                <a class="btn btn-default" onclick="reset_password()"><span class="glyphicon glyphicon-lock"></span>重置密码</a>
            </div>
            <div class="clear"></div>
        </div>
        <ul class="news_table department_table">
            <li>
                <table id="table" class="table_style" style="margin: 0 auto" ></table>
            </li>
        </ul>

    </div>
    <div class="clear"></div>

</div>
	<div class="modal fade" id="delcfmOverhaul">
		<div class="modal-dialog">
			<div class="modal-content message_align">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title">提示</h4>
				</div>
				<div class="modal-body">
					<!-- 隐藏需要删除的id -->
					<input type="hidden" id="deleteHaulId" />
					<p>您确认要删除该条信息吗？</p>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary" id="deleteHaulBtn" data-dismiss="modal">确认</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
	</div>

<script src="back/js/jquery/jQuery-2.2.0.min.js"></script>
<script src="back/js/bstable/js/bootstrap.min.js"></script>
<script src="back/js/bstable/js/bootstrap-table.js"></script>
<script src="back/js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="back/js/demo/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="back/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="back/js/ztree/jquery.ztree.exedit-3.5.js"></script>
<script src="back/js/layer_v2.1/layer/layer.js"></script>
<script src="back/js/organize.js"></script>

<script>
	$(function() {
		change();
		$('#table')
				.bootstrapTable(
						{
							method : "get",
							striped : true,
							singleSelect : false,
							url : "user1",
							dataType : "json",
							pagination : true, //分页
							pageSize : 10,
							pageNumber : 1,
							search : false, //显示搜索框
							contentType : "application/x-www-form-urlencoded",
							queryParams : null,
							columns : [
									{
										checkbox : "true",
										field : 'check',
										align : 'center',
										valign : 'middle'
									},
									{
										title : "用户名",
										field : 'uName',
										align : 'center',
										valign : 'middle'
									},
									{
										title : '电话',
										field : 'uTel',
										align : 'center',
										valign : 'middle'
									},
									{
										title : '邮件',
										field : 'uEmail',
										align : 'center',
										valign : 'middle'
									},
									{
										title : '密码',
										field : 'uPwd',
										align : 'center',
										valign : 'middle'
									},
									{
										title : '积分',
										field : 'integral',
										align : 'center',
										valign : 'middle'
									},
									{
										title : '类型',
										field : 'level',
										align : 'center',
										valign : 'middle',
										formatter : function(value, row, index) {
											if (value == 1) {
												return "作者";
											} else if (value == 0) {
												return "管理员";
											} else if (value == 2) {
												return "用户";
											}
										}
									},
									{
										title : '图片',
										field : 'uImage',
										align : 'center',
										valign : 'middle',
										formatter : function(value, row, index) {
											return '<image height="60px" width="60px" src="'+value+'">';
										}
									} ]
						});
	});
	function findUser() {
		var choose = $(".change").text();
		var uName = null, uTel = null, uEmail = null, level = null;
		//alert(choose);
		if (choose == "用户名") {
			uName = $('.find_input').val();
		} else if (choose == "类型") {
			level = $('.find_input').val();
		} else if (choose == "邮箱号") {
			uEmail = $('.find_input').val();
		} else if (choose == "电话") {
			uTel = $('.find_input').val();
		}
		$.post("condition", {
			uName : uName,
			type : level,
			uEmail : uEmail,
			uTel : uTel
		}, function(data) {
			$('#table').bootstrapTable('load', data, 'json');
			//$('#table').bootstrapTable('refresh');
		});
	}

	function change() {
		$(".dropdown-menu>li").click(function() {
			$(".change").html($(this).html())
		})
	}

	function deletechoose() {
		// $("#table").bootstrapTable('getSelections');为bootstrapTable自带的，所以说一定要使用bootstrapTable显示表格,#table：为table的id
		var rows = $("#table").bootstrapTable('getSelections');		
		console.log(rows);
		if (rows.length == 0) {// rows 主要是为了判断是否选中，下面的else内容才是主要
			alert("请先选择要删除的记录!");
			return;
		} else {
			$("#delcfmOverhaul").modal({
		        backdrop : 'static',
		        keyboard : false
		    });
			var arrays = new Array();// 声明一个数组
			$(rows).each(function() {// 通过获得别选中的来进行遍历
				arrays.push(this.id);// cid为获得到的整条数据中的一列
			});
			var idcard = arrays.join(','); // 获得要删除的id
			console.log(idcard);
			
			$("#deleteHaulBtn").click(function() {
				$.post("deleteUser", {
					iArray : idcard
				}, function(data) {
					if (data.code == 1) {
						alert(data.msg);
						$('#table').bootstrapTable('refresh');						
					}else{
						alert(data.msg);
					}
				});

			});
			
		}
	}

	function addUser() {
		layer.open({
			type : 2,
			title : '添加新用户',
			shadeClose : true,
			shade : 0.5,
			skin : 'layui-layer-rim',
			closeBtn : 1,
			area : [ '700px', '474px' ],
			content : 'user_tail'
		});
	}
	function reset_password() {
		layer.open({
			type : 2,
			title : '重置密码',
			shadeClose : true,
			shade : 0.5,
			skin : 'layui-layer-rim',
			closeBtn : 1,
			area : [ '500px', '280px' ],
			content : 'user_password'
		});
	}
</script>
</body>
</html>
