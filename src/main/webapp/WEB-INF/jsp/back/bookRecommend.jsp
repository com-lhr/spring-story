<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title></title>
    <link href="back/js/bstable/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="back/js/bstable/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="back/css/table.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #ecf0f5;font-family: 微软雅黑;color: #475059;min-width: 1150px;overflow: auto">
<div class="notice_main ">
    <div class="notice_check" style="padding: 16px 15px 8px 15px">
        <p>
            <label class="">小说编号：</label>
            <input type="text" id="bid" class="find_input">
            <label class="">小说名称：</label>
            <input type="text" id="bname" class="find_input">
            <label class="">小说作者：</label>
            <input type="text" id="author" class="find_input">
        </p>
    </div>
    <div class="notice_check  notice_check_last">
        <p class="l_left">
            <label class="">小说类别：</label>
            <select class="check_category"><option value="0">全部</option>
            <c:forEach items="${categorys }" var="cgs">
            <option value="${cgs.id }">${cgs.caName }</option>
            </c:forEach>
            </select> 
            <button id="check" class="check_btn">查询</button>
        </p>
        <div class="notice_nav r_right">
           <!--  <a class="btn btn-default" onclick="addRole()"><span class="glyphicon glyphicon-plus"></span>新增</a>
            <a class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>删除</a>
            <a class="btn btn-default" onclick="addRole()"><span class="glyphicon glyphicon-pencil"></span>编辑</a> -->
        </div>
        <div class="clear"></div>
        </div>
    <table id="table" class="table_style" style="margin: 0 auto" > </table>
</div>

<script src="back/js/jquery/jQuery-2.2.0.min.js"></script>
<script src="back/js/bstable/js/bootstrap.min.js"></script>
<script src="back/js/bstable/js/bootstrap-table.js"></script>
<script src="back/js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script src="back/js/layer_v2.1/layer/layer.js"></script>
<script type="text/javascript">
/* 	$("#check").click(function(){
/*        var category = $('.check_category option:selected').val();//选中的值
        if(category='全部'){
        	category='';
        }
        var bid = $("#bid").val();
        var bname = $("#bname").val();
        var author = $("#author").val(); */
       /* $('#table').empty();
         queryParams();
        showtable();  		
	}) */

$("#check").click(function (){
 
    var opt = {
        url: "CompositeQueryBook",
        silent: true,
        queryParams: queryParams
    };
    //带参数 刷新
    $("#table").bootstrapTable('refresh', opt);

});


		$(function () {
        $('#table').bootstrapTable({
            method: "get",
            striped: true,
            singleSelect: false,
            url: "CompositeQueryBook",
            dataType: "json",
            pagination: true, //分页
            pageSize: 10,
            pageNumber: 1,
            search: false, //显示搜索框
            contentType: "application/x-www-form-urlencoded",
            queryParams: queryParams,
            columns: [
                {
                    checkbox: "true",
                    field: 'check',
                    align: 'center',
                    valign: 'middle'
                }
                ,
                {
                    title: "小说编号",
                    field: 'id',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '小说名称',
                    field: 'bName',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '小说类别',
                    field: 'stCategory.caName',
                    align: 'center',
                    valign: 'middle'
                },

                {
                    title: '小说简介',
                    field: 'bIntroduce',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '小说作者',
                    field: 'bAuthor',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '操作',
                    field: 'operate',
                    align: 'center',
                	formatter: function (value, row, index) {
    					var str = '';
    				
    						str += '<a class="btn btn-primary btn-sm href="javascript:void(0);" οnclick=" shelveProduct('+row.id+','+row.onlineStatus+')" title="下架"><i class="fa fa-edit"></i>下架</a>';
    					
    					
    						str += '<a class="btn btn-warning btn-sm href="javascript:void(0);" οnclick="shelveProduct('+row.id+','+row.onlineStatus+')" title="上架"><i class="fa fa-edit"></i>上架</a>';
    					
    					return str;
    				}
                }
            ]
        });
    	});
    function queryParams() {
        /* debugger
        console.info(params); */
        var category = $('select option:selected').val();//选中的值
        if(category=='0'){
        	category='';
        }
        var bid = $("#bid").val();
        var bname = $("#bname").val();
        var author = $("#author").val();
        
       
        return {
            "stCategory": category,
            "id": bid,
            "bName": bname,
            "author":author
        }

        return params;
    }
    function addRole(){
        layer.open({
            type: 2,
            title: '添加角色',
            shadeClose: true,
            shade: 0.5,
            skin: 'layui-layer-rim',
            closeBtn:1,
            area: ['700px', '474px'],
            content: 'toAddBookRecommend'
        });
    }
    function warrant(){
        layer.open({
            type: 2,
            title: '角色授权',
            shadeClose: true,
            shade: 0.5,
            skin: 'layui-layer-rim',
            closeBtn:1,
            area: ['700px', '474px'],
            content: 'user_tail.html'
        });
    }
</script>
</body>
</html>
