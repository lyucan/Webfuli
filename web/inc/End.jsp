<%@ page import="jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
         double result=0;
    try {
        result=(Double)session.getAttribute("result");
    }catch (NullPointerException e){
        result=0;
    }

%>
<div  style="align-content: center" >
    <h1 style="color: azure">最终的结果为:</h1>
    <p></p>
    <%if(result!=0) { %>
          <h1 style="color: darkblue"><%=result%></h1>
    <% }%>


</div>