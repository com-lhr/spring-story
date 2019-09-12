<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title></title>
    <link href="back/js/bstable/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="back/js/bstable/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="back/css/table.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #ecf0f5;font-family: 微软雅黑;color: #475059;min-width: 1000px;overflow: auto">
<div class="notice_main">
    <h6>查看订单</h6>

    <div class="notice_check">
        <div class="btn-group l_left" style="margin-right: 4px">
            <button type="button" class="btn btn-default change" style="height: 30px;line-height: 30px;padding: 0 12px !important;font-size: 12px">选择条件</button>
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" style="height: 30px;line-height: 30px">
                <span class="caret"></span>
                <span class="sr-only"></span>
            </button>
            <ul class="dropdown-menu">
                <li>角色名称</li>
                <li>角色描述</li>
            </ul>
        </div>
        <div class="l_left">
            <input type="text" class="find_input">

        </div>
        <button class="check_btn">查询</button>


    <div class="notice_nav r_right">
        <a class="btn btn-default" onclick="addRole()"><span class="glyphicon glyphicon-plus"></span>新增</a>
        <a class="btn btn-default"><span class="glyphicon glyphicon-remove"></span>删除</a>
        <a class="btn btn-default" onclick="addRole()"><span class="glyphicon glyphicon-pencil"></span>编辑</a>
    </div>
</div>
    <table id="table" class="table_style" style="margin: 0 auto" > </table>
</div>
<script src="back/js/jquery/jQuery-2.2.0.min.js"></script>
<script src="back/js/bstable/js/bootstrap.min.js"></script>
<script src="back/js/bstable/js/bootstrap-table.js"></script>
<script src="back/js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script src="back/js/layer_v2.1/layer/layer.js"></script>
<script type="text/javascript">
    $(function () {
         change();
        $('#table').bootstrapTable({
            method: "get",
            striped: true,
            singleSelect: false,
            url: "order",
            dataType: "json",
            pagination: true, //分页
            pageSize: 3,
            pageNumber: 1,
            search: false, //显示搜索框
            contentType: "application/x-www-form-urlencoded",
            queryParams:null,
            columns: [
                {
                    checkbox: "true",
                    field: 'check',
                    align: 'center',
                    valign: 'middle'
                }
                ,
                {
                    title: "订单编号",
                    field: 'id',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '商品编号',
                    field: 'bId',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '日期',
                    field: 'oTime',
                    align: 'center',
                    valign: 'middle'
                },
                {
                    title: '状态',
                    field: 'oStatus',
                    align: 'center'
                },
                {
                    title: '金额',
                    field: 'oAmount',
                    align: 'center'
                }
            ]
        });
    });
    function change(){
       $(".dropdown-menu>li").click(function(){
           $(".change").html($(this).html())
       })
    }
    function addRole(){
        layer.open({
            type: 2,
            title: '添加详情',
            shadeClose: true,
            shade: 0.5,
            skin: 'layui-layer-rim',
            closeBtn:1,
            area: ['500px', '320px'],
            content: 'role_tail.html'
        });
    }
</script>

</body>
</html>
