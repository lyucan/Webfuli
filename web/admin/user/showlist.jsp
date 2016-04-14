
<%@ page import="com.yu.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yu.Dao.Iuserdao" %>
<%@ page import="com.yu.Dao.DaoFactory" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/8
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>显示用户列表</title>
</head>
<body>
<%

        String con = request.getParameter("checkname");
        if(con==null)
        {con="";}
        User lu=(User)session.getAttribute("loginuser");
        Iuserdao userdao= DaoFactory.getuserdao();
        List<User> users= userdao.list(con);



%>


<%=con%>
<table align="center" width="1000" style="color: aqua" border="1">
    <tr>
        <form action="showlist.jsp" method="post">
            查询用户:<input type="text" name="checkname" value="<%=con%>"/>
            <input type="submit" value="查询"/>
        </form>
    </tr>

         <tr>
            <td>用户序号</td> <td>用户姓名</td><td>用户密码</td><td>用户昵称</td><td>用户状态</td><td>用户身份</td><td>用户功能</td>
         </tr>
     <%
          for(User u:users){
     %>
            <tr><td><%=u.getId()%></td>
                <td><%=u.getUsername()%></td><td><%=u.getPassword()%></td>
                <td><%=u.getNeckname()%></td>
                <td>
                    <%
                       if(u.getStadio()==0){
                       %>
                       启用
                    <%
                       }else {
                           %>
                       停用
                    <%
                       }
                    %>
                </td>
                <td>
                    <%
                        if(u.getType()==0){
                    %>
                    普通管理员
                    <%

                            if(lu.getType()==1){
                    %>
                    <a href="settyple.jsp?id=<%=u.getId()%>">设置管理员</a>


                    <%
                        }
                    }else {
                    %>
                    超级管理员
                    <%
                        if(lu.getType()==1){
                    %>
                    <a href="settyple.jsp?id=<%=u.getId()%>">取消管理员</a>
                     <%}
                    }
                    %>
                </td>

                <td> <%
                    if(lu.getType()==1){
                %>
                    <a href="delete.jsp?id=<%=u.getId()%>">删除</a>&nbsp;<a href="updata.jsp?id=<%=u.getId()%>">更新</a></td>

                <%}%>
            </tr>
    <%
          }
     %>



</table>


</body>
</html>
