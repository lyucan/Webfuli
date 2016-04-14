
<%@ page import="com.yu.model.User" %>
<%@ page import="com.yu.model.shopException" %>
<%@ page import="com.yu.Dao.Iuserdao" %>
<%@ page import="com.yu.Dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/9
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%
    try {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        Iuserdao Logindao= DaoFactory.getuserdao();
        User user= Logindao.login(username,password);
        session.setAttribute("loginuser",user);
        response.sendRedirect(request.getContextPath()+"/admin/user/Menu.jsp");
    }catch (shopException e){
%>
      <h2 style="color:red">发生错误:<%=e.getMessage()%></h2>
 <%
     }

%>
</body>
</html>
