<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>DanliFuterMoney</title>
</head>
<body>
<form action="Fuli" method="post">
<table border="1" align="center" style="background-image: url(background.jpg); width: 600px">
    <input type="hidden" value="5" name="select"/>
    <input type="hidden" value="0" name="FuterMoney"/>
    <tr>
        <td> <jsp:include page="Menu.jsp"/> </td>
    </tr>
    <tr>
    <tr>

        <td  style="font-size:12px">
            本金：  <input type="text" name="NonMoney" />
        </td>


    </tr>

    <tr>

        <td  style="font-size:12px">
            利率：   <input type="text" name="Rate" />
        </td>
    </tr>


    <tr>

        <td  style="font-size:12px">
            年限：   <input type="text" name="year" />
        </td>
    </tr>

    <tr>
        <td colspan="3" style="font-size:12px">
            <input type="submit" value="计算"/>
            <input type="reset" value="重置"/>
        </td>
    </tr>
    <tr>
        <td colspan="3" style="font-size:12px">
            <jsp:include page="/inc/End.jsp"/>
        </td>
    </tr>
    </tr>
</table>
</form>
</body>
</html>
