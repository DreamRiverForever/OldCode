<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/3/15
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h2>您购买了如下商品</h2>
        <%
            Map<String,Integer> map = (Map<String,Integer>)session.getAttribute("car");
            if (map != null){
                for (String id: map.keySet()
                 ) {
                int count = map.get(id);
        %>
                <h3> <%=id%> --- <%=count%><h3>
        <%
                 }
            }
        %>
                    <a href="Clear">清空购物车<a/>

</body>
</html>
