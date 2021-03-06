<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="back/css/index.css" rel="stylesheet" type="text/css" />
    <link href="back/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
    <link href="back/css/zTreeStyle/zTreeStyle.css" rel="stylesheet" type="text/css" />
</head>
<body style="border-radius: 8px;width: 680px;overflow: hidden">
<form>
<div class="top">
    <div>
        <div class="top_out">
            <table class="table">
                <tbody>
                <tr>
                    <td>用户名<span class="span">*</span></td>
                    <td><input type="text" required   minlength ="2"></td>
                    <td>密码<span class="span">*</span></td>
                    <td><input type="password" class="long_text" required></td>
                </tr>
                <tr>
                    <td>地区<span class="span"></span></td>
                    <td>
                        <select class="td_select">
                            <option>选择省</option>
                            <option>四川省</option>
                            <option>河北省</option>
                        </select>
                        <select class="td_select">
                            <option>选择市</option>
                            <option>成都市</option>
                            <option>巴中市</option>
                        </select>
                        <select class="td_select">
                            <option>选择区</option>
                            <option>金牛区</option>
                            <option>高新区</option>
                        </select>
                    </td>
                    <td>岗位<span class="span"></span></td>
                    <td>
                        <select>
                            <option>全部</option>
                            <option>Java工程师</option>
                            <option>前端工程师</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>部门<span class="span"></span></td>
                    <td>
                        <div class="dropdown">
                            <input class="dropdown_select"  id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" placeholder="--请选择--" >
                            <span class="caret"></span>
                            <div class="dropdown-menu" aria-labelledby="dropdownMenu1" style="width: 247px">
                                <div class=" order_ztree l_left organize_ztree" style="width: 100%;background-color: #fff;padding-bottom: 10px;height: 240px;overflow: auto;">
                                    <ul id="treeDemo" class="ztree"  style=" overflow:auto;margin-left: 20px"></ul>

                                </div>
                            </div>
                        </div>
                    </td>
                    <td>角色<span class="span"></span></td>
                    <td>
                        <select>
                            <option>全部</option>
                            <option>超级管理员</option>
                            <option>普通管理员</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>工号<span class="span">*</span></td>
                    <td><input type="text" required></td>
                    <td>姓名<span class="span">*</span></td>
                    <td><input type="text" required></td>
                </tr>
                <tr>
                    <td>性别<span class="span"></span></td>
                    <td>
                        <select>
                            <option>男</option>
                            <option>女</option>
                        </select>
                    </td>
                    <td>生日<span class="span"></span></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>手机<span class="span"></span></td>
                    <td><input type="text"></td>
                    <td>电话<span class="span"></span></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>邮箱<span class="span"></span></td>
                    <td><input type="email" required></td>
                    <td>QQ<span class="span"></span></td>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>备注<span class="span"></span></td>
                    <td colspan = "8" style="text-align: left"><textarea></textarea></td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="notice_bot">
        <div class="l_left"><input type="checkbox" checked="checked"/>保存并关闭窗口</div>
        <div class="r_right but_p"><button class="but_save" type="submit">保存</button><button class="but_close" onclick="Cancel()">关闭</button></div>
    </div>
</div>
</form>
<script src="back/js/jquery-2.2.0.min.js"></script>
<script src="back/js/bstable/js/bootstrap.min.js"></script>
<script src="back/js/bstable/js/bootstrap-table.js"></script>
<script src="back/js/bstable/js/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="back/js/demo/jquery.ztree.core-3.5.js"></script>
<script type="text/javascript" src="back/js/ztree/jquery.ztree.excheck-3.5.js"></script>
<script type="text/javascript" src="back/js/ztree/jquery.ztree.exedit-3.5.js"></script>
<script src="back/js/organize.js"></script>
<script>
    function Cancel() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }
</script>
</body>
</html>