<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>无标题文档</title>
    <link href="back/css/tail.css" rel="stylesheet" type="text/css">
    <link href="back/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
</head>

<body style="border-radius: 8px;width: 900px">
<form>
<div class="top">
    <div>
        <div class="top_out">
            <table class="table">
                <tbody>
                <tr>
                    <td>标题<span>*</span></td>
                    <td colspan = "8" ><input type="text" class="frist_input" placeholder="请输入标题" required  minlength ="2"></td>
                </tr>
                <tr>
                    
                    <td>发布时间<span>*</span></td>
                    <td>
                        <input type="date" placeholder="2017-05-03" id="demo" required>
                    </td>
                </tr>
                <tr>
                    <td>内容<span></span></td>
                    <td colspan = "8" style="text-align: left">
                        <textarea id="editor"  class="form_area"></textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <div class="notice_bot">
        <div class="l_left"><input type="checkbox" checked="checked"/>保存并关闭窗口</div>
        <div class="r_right but_p"><button class="but_save">保存</button><button class="but_close" onclick="Cancel()">关闭</button></div>
    </div>
</div>
</form>
</body>
<script src="back/js/jquery/jQuery-2.2.0.min.js"></script>
<script src="back/js/utf8-php/ueditor.config.js"></script>
<script src="back/js/utf8-php/ueditor.all.min.js"></script>
<script >
    function Cancel() {
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
    }
    var ue = UE.getEditor('editor');
    function isFocus(e){
        alert(UE.getEditor('editor').isFocus());
        UE.dom.domUtils.preventDefault(e)
    }
    function setblur(e){
        UE.getEditor('editor').blur();
        UE.dom.domUtils.preventDefault(e)
    }
    function insertHtml() {
        var value = prompt('????html????', '');
        UE.getEditor('editor').execCommand('insertHtml', value)
    }
    function createEditor() {
        enableBtn();
        UE.getEditor('editor');
    }
    function getAllHtml() {
        alert(UE.getEditor('editor').getAllHtml())
    }
    function getContent() {
        var arr = [];
        arr.push("");
        arr.push("");
        arr.push(UE.getEditor('editor').getContent());
        alert(arr.join("\n"));
    }
    function getPlainTxt() {
        var arr = [];
        arr.push("");
        arr.push("");
        arr.push(UE.getEditor('editor').getPlainTxt());
        alert(arr.join('\n'))
    }
    function setContent(isAppendTo) {
        var arr = [];
        arr.push("");
        UE.getEditor('editor').setContent('??????ueditor', isAppendTo);
        alert(arr.join("\n"));
    }
    function setDisabled() {
        UE.getEditor('editor').setDisabled('fullscreen');
        disableBtn("enable");
    }

    function setEnabled() {
        UE.getEditor('editor').setEnabled();
        enableBtn();
    }

    function getText() {

        var range = UE.getEditor('editor').selection.getRange();
        range.select();
        var txt = UE.getEditor('editor').selection.getText();
        alert(txt)
    }

    function getContentTxt() {
        var arr = [];
        arr.push("");
        arr.push("");
        arr.push(UE.getEditor('editor').getContentTxt());
        alert(arr.join("\n"));
    }
    function hasContent() {
        var arr = [];
        arr.push("");
        arr.push("");
        arr.push(UE.getEditor('editor').hasContents());
        alert(arr.join("\n"));
    }
    function setFocus() {
        UE.getEditor('editor').focus();
    }
    function deleteEditor() {
        disableBtn();
        UE.getEditor('editor').destroy();
    }
    function disableBtn(str) {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            if (btn.id == str) {
                UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
            } else {
                btn.setAttribute("disabled", "true");
            }
        }
    }
    function enableBtn() {
        var div = document.getElementById('btns');
        var btns = UE.dom.domUtils.getElementsByTagName(div, "button");
        for (var i = 0, btn; btn = btns[i++];) {
            UE.dom.domUtils.removeAttributes(btn, ["disabled"]);
        }
    }

    function getLocalData () {
        alert(UE.getEditor('editor').execCommand( "getlocaldata" ));
    }

    function clearLocalData () {
        UE.getEditor('editor').execCommand( "clearlocaldata" );
        alert("")
    }
</script>
</html>


