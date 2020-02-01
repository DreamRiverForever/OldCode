<%@ page import="java.util.*" language="java" pageEncoding="utf-8" %>
<%@ page import="com.test.Username" %>
<jsp:useBean id="name" class="com.test.Username" scope="session"/>
<jsp:setProperty name="name" property="username"/>

<html lang="zh">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <script type="text/javascript" src="myjs.js"></script>
    <script type="text/javascript" src="jquery-3.3.1.js"></script>
    <title>注册</title>
</head>
<body>

<form action="retpage.jsp" method="post">
    <div class="red">请注意：带有“*”的项目必须填写。</div>
    <table>
        <tr>
            <td class="blue" colspan="3">请填写您的用户名：</td>
        </tr>
        <tr>
            <td class="left"><span class="red">*</span>用户名：</td>
            <td class="center"><label for="username"></label><input type="text" id="username" name="username" placeholder="请输入用户名" onkeyup="NameCheck();"><br/><a href="#">查看是否被占用</a></td>
            <td class="right" id="nametip">6~18位，由字母、数字或下划线组成</td>
        </tr>
        <tr>
            <td class="blue" colspan="3">请填写安全设置：<span class="normal">（安全设置用于验证账号和找回密码）</span></td>
        </tr>
        <tr>
            <td colspan="3"><div class="red">以下信息对您账号的安全极为重要，请您务必认真填写。</div></td>
        </tr>
        <tr>
            <td class="left"><span class="red">*</span>登录密码：<br /><span class="red">*</span>确认密码：</td>
            <td class="center"><label>
                <input type="password" id="pwd">
            </label><br /><label>
                <input type="password" id="pwd2" onkeyup="PwdCheck();">
            </label><br /></td>
            <td class="right" id="tip">6~16位，由字母、数字或特殊字符组成，区分字母大小写</td>
        </tr>
        <tr>
            <td colspan="3"><hr /></td>
        </tr>

        <tr>
            <td class="left"><span class="red">*</span>手机号码：<br /><span class="red">*</span>邮箱地址：</td>
            <td class="center">
                <label>
                    <input type="text"  name="code">
                </label>
                <br />
                <label>
                    <input type="text" name="code2">
                </label><br /></td>
            <td class="right">忘记密码时，可以通过手机号码或邮箱找回密码</td>
        </tr>
        <tr>
            <td colspan="3"><hr /></td>
        </tr>
        <tr>
            <td class="tocenter" colspan="3">
                <input class="submit" type="submit" title="注册" value="注册" >
            </td>
        </tr>
    </table>
</form>

</body>
</html>