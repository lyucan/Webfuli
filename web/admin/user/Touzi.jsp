<%@ page import="com.yu.model.Company" %>
<%@ page import="com.yu.Dao.Icompany" %>
<%@ page import="com.yu.Dao.DaoFactory" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 22:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Touzi</title>
</head>
<body>
<%
    Icompany com= DaoFactory.getcompanydao();
    String con = request.getParameter("checkname");
    if(con==null)
     {con="";}
    List<Company> coms= com.list(con);

%>
<table align="center" border="1">
<form action="DealTouzi.jsp" method="post">

    <tr>
   <td colspan="4">
        基本资金：<input type="text" name="NonMoney" value="10000"/>
    </td>
    </tr>
    <tr>
        <td colspan="4">
        投资年限：<input type="text" name="Year" value="5"/>
        </td>
    </tr>
    <tr>
        <td>
            投资项目：
        </td><%
            int i=0;
            for(Company c:coms){
                i=i+1;

        %>

            <td>
                <input type="checkbox" name="item" value="<%=i%>"><%=c.getCompanyname()%>
            </td>

        <%
            }
        %>
    </tr>
    <tr>
        <td colspan="4">
            <input type="submit" value="提交"/>
            <input type="reset" value="重置"/>
        </td>
    </tr>

</form>
</table>


</body>
</html>
