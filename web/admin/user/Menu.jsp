<%@ page import="com.yu.model.User" %>
<%@ page import="com.yu.model.Number" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/13
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/inc/head.jsp"/>
<p/><br/>
<html>
<head>
    <title>Menu</title>
</head>
<body>
<%
    User user =(User) session.getAttribute("loginuser");
%>
<h2 align="center">菜单界面</h2>
<p>
</p>
    <input type="hidden" name="userid"  value="<%=user.getId()%>"/>
    <a href="Touzi.jsp"><h1 style="color: red">查看信息</h1></a>
    <a href="DanliFuterMoney.jsp"><h1 style="color: red" align="left">单利计算</h1></a>
    <a href="FuliFuterMoney.jsp"><h1 style="color: red">复利计算</h1></a>
    <a href="FuliYear.jsp"><h1 style="color: red">年限计算</h1></a>
    <a href="FuliRate.jsp"><h1 style="color: red">利率计算</h1></a>
    <a href="FuliNonMoney.jsp"><h1 style="color: red">本金计算</h1></a>
</body>
</html>
