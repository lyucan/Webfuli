<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/10
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>logout</title>
</head>
<body>
<%
    session.invalidate();
    response.sendRedirect("Logininput.jsp");
%>
</body>
</html>
