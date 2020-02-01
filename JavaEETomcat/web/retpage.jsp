<%@ page import="java.util.*" language="java" pageEncoding="utf-8" %>
<%@ page import="classes.pkg.Username" %>
<jsp:getProperty name="name" property="username"/>
<%  Username name = new Username();
    name.setUsername(request.getParameter("name"));
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
hh
</body>
</html>