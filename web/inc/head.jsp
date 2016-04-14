<%@ page import="com.yu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/13
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    User user=(User) session.getAttribute("loginuser");
%>

<div style="text-align: right" >
    欢迎[<%=user.getNeckname()%>]使用系统:<a href="<%=request.getContextPath()%>/admin/user/useradd.jsp">用户添加</a> <a href="<%=request.getContextPath()%>/admin/user/showlist.jsp">用户列表</a>
    <a href="<%=request.getContextPath()%>/logout.jsp">退出系统</a>
</div>