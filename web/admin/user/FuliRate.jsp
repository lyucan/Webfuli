<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FuliRate</title>
</head>
<body>
<form action="Fuli" method="post">
<table border="1" align="center" style="background-image: url(background.jpg); width: 600px">
    <input type="hidden" value="3" name="select"/>
    <input type="hidden" value="0" name="Rate"/>
    <tr>
        <td>
            <jsp:include page="Menu.jsp"/>
        </td>
    </tr>
<tr>
    <tr>
    <td colspan="2" style="font-size:12px">
        本金：    <input type="text" name="NonMoney" style="width: 400px"/>
    </td>
</tr>
<tr>

    <td colspan="2" style="font-size:12px">
        收益：      <input type="text" name="FuterMoney" style="width: 400px"/>
    </td>
</tr>
<tr>

    <td colspan="2" style="font-size:12px">
        年限：     <input type="text" name="year" style="width: 400px"/>
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
