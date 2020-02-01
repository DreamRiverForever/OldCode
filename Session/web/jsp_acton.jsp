<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/16
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h1>jsp的动作标签</h1>
        <%--输出另一界面上的输出结果--%>
        <%--<jsp:include page="other2.jsp"></jsp:include>--%>

        <%--前往哪一个页面--%>
        <%--<jsp:forward page="other2.jsp"></jsp:forward>--%>

        <%--跳转到other2页面，并且传值name，响应页面可以用requst来接受相应的参数--%>
        <jsp:forward page="other2.jsp">
            <jsp:param name="address" value="xuzhou"/>
        </jsp:forward>


</body>
</html>
