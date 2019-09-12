<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
    <meta http-equiv="Content-Type" content="text/html"; charset="utf-8" />
    <title>统计表</title>
    <link href="back/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="back/css/table.css" rel="stylesheet" type="text/css">
</head>
<body style="background-color: #ecf0f5;font-family: 微软雅黑;color: #475059;min-width: 1000px;overflow: auto">
<div class="from_main" >
    <div class="news_check">
        <div class="check_left l_left">
            <label>查询条件：</label><input type="text" placeholder="" style="margin-right: 10px"><input type="text" placeholder=""><button>查询</button>
        </div>
        <div class="check_right r_right">
            <a class="btn btn-default"><span class=" glyphicon glyphicon-circle-arrow-down l_left"></span>打印</a>
            <a class="btn btn-default"><span class=" glyphicon glyphicon-download-alt l_left"></span>导出</a>
        </div>
        <div class="clear"></div>
    </div>

    <div style="padding: 0 10px 0 10px ;border: 1px #ccc solid;background-color: #fff;">
        <div class="e_chart">
        <div class="charts l_left">
            <p class="charts_p">饼状图<span class="r_right">更多></span></p>
            <div id="container" style="height:350px;width: 98%"></div>
        </div>
        <div class="charts l_left last_charts">
            <p class="charts_p">柱状图<span class="r_right">更多></span></p>
            <div id="container1" style="height:350px;width: 98%"></div>
        </div>
        <div class="clear"></div>
        </div>
        <div class="e_chart">
            <div class="charts charts_last">
                <p class="charts_p">折线图<span class="r_right">更多></span></p>
                <div id="container2" style="height:350px"></div>
            </div>
        </div>
    </div>

</div>



</body>
<script type="text/javascript" src="back/js/jquery-2.2.0.min.js"></script>
<script src="back/js/echarts-all.js"></script>
<script src="back/js/analysis.js"></script>

<script type="text/javascript">
//初始化echarts
function chushihua(myChart){
    var option = {
        title:{
            text:'ECharts 数据统计'
        },            
        series:[{
            name:'访问量',
            type:'pie', 
            radius:'90%', 
            data:[
                {value:0,name:'无'},
            ]
        }]
    };

    myChart.setOption(option);   
}

//从数据库读取数据赋值给echarts
function fuzhi(myChart){
    $.ajax({
        contentType : "application/json",
        type : "GET",
        url : "getCate",
        dataType : "json",
        success : function(data) {
            //创建一个数组，用来装对象传给series.data，因为series.data里面不能直接鞋for循环
            var servicedata=[];

            for(var i=0;i<data.length;i++){
                var obj=new Object();
                obj.name=data[i].username; 
                obj.value=data[i].age;
                servicedata[i]=obj;
            }

            myChart.setOption({
                title:{
                text:'ECharts 数据统计'
                },            
                series:[{
                    name:'访问量',
                    type:'pie', 
                    radius:'60%', 
                    data:servicedata,
                }]

            });

        }
    });
}

//初始化echarts实例
var myChart = echarts.init(document.getElementById('#container'));
chushihua(myChart);
fuzhi(myChart);    

/* $(function(){
    var myChart = echarts.init($("#container")[0]);
    var option = {
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient : 'vertical',
            x : 'left',
            data:['全体会议','常委会议','主体会议','其他']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        series : [
            {
                name:'小说类型',
                type:'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {
                        value:124,
                        name:'全体会议',
                        itemStyle:{
                            normal:{
                                color:""
                            }
                        }
                    },
                    {
                        value:86,
                        name:'常委会议'
                    },
                    {
                        value:9,
                        name:'主体会议'
                    },
                    {
                        value:39,
                        name:'其他'
                    }

                ]
            }
        ]
    };
    myChart.setOption(option);
}); */
</script>
</html>
