<%--
  Created by IntelliJ IDEA.
  User: sam
  Date: 2019/10/15
  Time: 下午4:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh">
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="style.css">
  <script type="text/javascript" src="myjs.js"></script>
  <script type="text/javascript" src="jquery-3.3.1.js"></script>
  <title>考研用作业自动完成系统</title>
</head>
<body class="mainbody">
<div class="header">考研专用作业自动完成系统</div>




<div class="box">
  <div class="w_220 fl">
    <div class="f_1 mb10">
      <dl class="menu_left">
        <dt>考研的同胞，您好！</dt>
        <dt>请 <a href="sign-in.html">登录</a> 或<a href="register.jsp">注册</a> 以使用本系统</dt>
        <dt></dt>
        <dt>看一看我们的太阳系吧</dt>


        <ul id="navigation">
          <li class="home"><a title="Earth" href="https://www.google.com/intl/zh-CN/earth/"></a></li>
          <li class="about"><a title="Mars"></a></li>
          <li class="search"><a title="木星"></a></li>
          <li class="photos"><a title="Photos"></a></li>
          <li class="rssfeed"><a title="Rss Feed"></a></li>
          <li class="podcasts"><a title="Podcasts"></a></li>
        </ul>
      </dl>

    </div>

  </div>
  <div class="w_720 fr">

    <div class="t_1 clear">
      <div>
        <h3><a href="#">应用系统列表</a></h3>

      </div>
      <table width="90%" border="0" align="center" cellpadding="10" cellspacing="6" class="table">
        <tr>
          <td class="apic" width="25%" ><a href="https://www.baidu.com" target="_blank"><img src="./images/baidu.png" title="百度" alt="百度"></a></td>
          <td class="apic" width="25%"><a href="http://www.google.com" target="_blank"><img src="./images/Google.gif" title="Google" alt="Google"></a></td>
          <td class="apic" width="25%"><a href="https://www.bing.cn" target="_blank"><img src="./images/bing.jpg" title="Bing" alt="Bing"></a></td>
          <td class="apic" width="25%"><a href="https://yahoo.com" target="_blank"><img src="./images/yahoo.png" title="Yahoo" alt="Yahoo"></a></td>
        </tr>
        <tr>
          <td class="tdc2"><a href="#" >凑数第一</a></td>
          <td class="tdc1"><a href="#" >凑数第二</a></td>
          <td class="tdc2"><a href="#" >凑数第三</a></td>
          <td class="tdc1"><a href="#" >凑数第四</a></td>
        </tr>
        <tr>
          <td class="tdc1">&nbsp;</td>
          <td class="tdc2">&nbsp;</td>
          <td class="tdc1">&nbsp;</td>
          <td class="tdc2">&nbsp;</td>
        </tr>
        <tr ><td></td><td></td><td></td><td align="center">
          <p id="time"></p></td></tr>
      </table>
    </div>
    <!--/t_1--><!--/tabbox-->
  </div>

  <!--/w_720-->
</div>
<!--/box-->
</body>
</html>