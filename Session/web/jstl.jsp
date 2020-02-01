<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/17
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--定义name的值为张三可以使用el表达式取值${name} 后面指定存储的位置默认page --%>

        <c:set var="name" value="zhangsan" scope="session"></c:set>
        <br>


        <%--判断test表达式是否满足，满足就执行下面--%>
        <c:set var="age" value="18" ></c:set>
        <%--定义表达式真假存在session中--%>
        <c:if test="${age > 16}" var="flag" scope="session">
            条件符合
        </c:if>
        <br>

        <%--循环遍历,step表示增幅为2--%>
        <c:forEach begin="1" end="10" var="i" step="2">
            ${i}
        </c:forEach>
        <%
            List list = new ArrayList();
            pageContext.setAttribute("list",list);
        %>



</body>
</html>
