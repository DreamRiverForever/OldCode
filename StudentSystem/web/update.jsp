<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/24
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>添加学生页面</h3>
<form action="Update" method="get">
    <input type="hidden" name="id" value="${student.id}">
    <table border="1" width="700">
        <tr>
            <td>姓名</td>
            <td><input type="text" name="name" value="${student.name}"></td>
        </tr>
        <tr>
            <td>性别</td>
            <td>
                <input type="radio" name="gender" value="男"  <c:if test="${student.gender == '男'}">checked</c:if>>男

                <input type="radio" name="gender" value="女"   <c:if test="${student.gender == '女'}">checked</c:if>>女
            </td>
        </tr>
        <tr>
            <td>电话</td>
            <td><input type="text" name="phone" value="${student.phone}"></td>
        </tr>
        <tr>
            <td>生日</td>
            <td><input type="text" name="birthday" value="${student.birthday}"></td>
        </tr>
        <tr>
            <td>爱好</td>
            <td>
                <input type="checkbox" name="hobby" value="游泳" <c:if test="${fn:contains(student.hobby,'游泳')}">checked</c:if> >游泳
                <input type="checkbox" name="hobby" value="看书" <c:if test="${fn:contains(student.hobby,'看书')}">checked</c:if>>看书
                <input type="checkbox" name="hobby" value="写代码" <c:if test="${fn:contains(student.hobby,'写代码')}">checked</c:if>>写代码
                <input type="checkbox" name="hobby" value="足球" <c:if test="${fn:contains(student.hobby,'足球')}">checked</c:if>>足球
                <input type="checkbox" name="hobby" value="篮球" <c:if test="${fn:contains(student.hobby,'篮球')}">checked</c:if>>篮球
            </td>
        </tr>
        <tr>
            <td>简介</td>
            <td>
                <textarea name="info" rows="3" cols="20">${student.info}</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="更新"></td>
            <td></td>
        </tr>
    </table>
</form>
</body>
</html>
