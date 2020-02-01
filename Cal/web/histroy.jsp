<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/25
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link  href="./resource/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="row col-lg-10" >
    <table border="1" width="700" class="table table-striped table-bordered .table-condensed">

        <tr align="center">
            <td>编号</td>
            <td>计算式</td>
            <td>结果</td>
            <td>日期</td>
        </tr>
        <c:forEach items="${list}" var="info">
            <tr align="center">
                <td>${info.id}</td>
                <td>${info.op}</td>
                <td>${info.result}</td>
                <td>${info.date}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
