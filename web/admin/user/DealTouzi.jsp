<%@ page import="com.yu.Dao.DaoFactory" %>
<%@ page import="com.yu.Dao.Icompany" %>
<%@ page import="com.yu.Dao.Inumberdao" %>
<%@ page import="com.yu.model.Company" %>
<%@ page import="com.yu.model.Number" %>
<%@ page import="com.yu.model.User" %><%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2016/4/14
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
          double Nonmoney=Double.valueOf(request.getParameter("NonMoney"));
          int Year=Integer.parseInt(request.getParameter("Year"));

          Company  com;double allRate=0;   Number num=new Number();
          Icompany comdao=DaoFactory.getcompanydao();
          Inumberdao numdao= DaoFactory.getnumberdao();
                    for(int j=1;j<100;j++){
                        numdao.delete(j);
                    }
          int select=0;
          User lu=(User)session.getAttribute("loginuser");
          String[] SkillALL=request.getParameterValues("item");
          if(SkillALL !=null&&SkillALL.length>0) {
              for (String skills : SkillALL) {
                  String item= "";
                  item = item + skills + "";
                  select = Integer.parseInt(item);
                 com=comdao.load(select);
                allRate=allRate+com.getRate();
            for(int i=0;i<Year;i++){
                num.setRate(allRate);num.setId(select);
                num.setNonMoney(Nonmoney);num.setYear(i);
                num.setFuterMoney(Nonmoney*Math.pow((1+allRate ),i ));
                num.setId(i);
                numdao.add(num,lu.getId());
            }

        }
    }
    response.sendRedirect(request.getContextPath()+"/admin/user/UserList.jsp?year="+Year);


%>
