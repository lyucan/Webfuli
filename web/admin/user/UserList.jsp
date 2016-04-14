<%@ page import="com.yu.Dao.DaoFactory" %>
<%@ page import="com.yu.Dao.Iuserdao" %>
<%@ page import="com.yu.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yu.Dao.Icompany" %>
<%@ page import="com.yu.Dao.Inumberdao" %>
<%@ page import="com.yu.model.Number" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 17:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UserList</title>
</head>
<body>
<%
    String con = request.getParameter("checkname");
    if(con==null)
    {con="";}
    Iuserdao userdao= DaoFactory.getuserdao();
    Inumberdao numberdao=DaoFactory.getnumberdao();
    User lu=(User)session.getAttribute("loginuser");
    Number num=null;
%>

<table align="center" width="1000"  border="1">
    <tr>
        <form action="showlist.jsp" method="post">
            查询用户:<input type="text" name="checkname" value="<%=con%>"/>
            <input type="submit" value="查询"/>
        </form>
    </tr>
    <tr>
      <td>投资年限</td><td>用户名</td><td>用户昵称</td><td>用户资产</td>
    </tr>
    <%
    int year=Integer.parseInt(request.getParameter("year"));
        int i=-1;

        for(int x=0;x<year;x++){
            i=i+1;
           num=numberdao.load(i);
           %>
    <tr>
        <td><%=i%></td><td><%=lu.getUsername()%></td>
        <td><%=lu.getNeckname()%></td>
        <td><%=num.getFuterMoney()%></td>
    </tr>

    <%}
%>

</table>

</body>
</html>
