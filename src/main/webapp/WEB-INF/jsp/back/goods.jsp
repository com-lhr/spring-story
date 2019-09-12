<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title></title>
    <link href="back/js/bstable/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="back/js/bstable/css/bootstrap-table.css" rel="stylesheet" type="text/css">
    <link href="back/css/jquery.treetable.css" rel="stylesheet" type="text/css">
    <link href="back/css/jquery.treetable.theme.default.css" rel="stylesheet" type="text/css">
    <link href="back/css/table.css" rel="stylesheet" type="text/css">

</head>
<body style="background-color: #ecf0f5;font-family: 微软雅黑;color: #475059;min-width: 1000px;overflow: auto">
<div class="notice_main">
    <h6>商品详情</h6>
    <div style="border-bottom: 1px #ccc solid;padding-bottom: 8px">
        <p style="line-height: 24px;font-size: 14px;padding: 4px 0 0 36px ;color:#bb8940;background-image: url(back/img/ts_03.png);background-repeat: no-repeat;background-position: 10px 8px;font-weight: bold">温馨提示</p>
        <ul class="ts">
            <li><span>*</span>该页面主要显示的是商品详情表格的类容。</li>
            <li><span>*</span>该页面主要显示的是商品详情表格的类容。</li>
        </ul>
    </div>
    <div class="goods_main" >
        <div><label>商品名称：</label><input type="text" placeholder="请输入商品的名称" class="goods_input" id="goods_name"></div>
        
        <div><label>商品种类：</label><select class="goods_input" id="goods_kind"><option>积分</option><option>月票</option></select></div>
        
        <div><label>商品价格：</label><input type="text" class="goods_input" id="goods_price"></div>
        <div><label>商品折扣：</label><input type="text" class="goods_input" id="goods_cost"></div>
        
        <div class="good_btn" onclick="javascript:add();"><button>保存</button></div>
    </div>
</div>

<script src="back/js/jquery/jQuery-2.2.0.min.js"></script>
<script src="back/js/date/js/laydate.js"></script>
<script type="text/javascript">
function add(){
	var name = $('#goods_name').val();
	var kind = $('#goods_kind').val();
	var price = $('#goods_price').val();
	var cost = $('#goods_cost').val();
	$.get("addGoods",{
		name:name,
		kind:kind,
		price:price,
		cost:cost
	},function(data){
		if(data==1){
			alert("添加成功!");
		}
	});
}
</script>

</body>
</html>
