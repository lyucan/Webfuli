package com.yu.Selveter;

import com.yu.Dao.DaoFactory;
import com.yu.Dao.Inumberdao;
import com.yu.model.Number;
import com.yu.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2016/4/13.
 */
public class FuliSelveter extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Number number=new Number();  //获得number变量的值
        int select=0;
        try {
            select= Integer.parseInt(req.getParameter("select"));
            HttpSession session =req.getSession();
            User user= (User)session.getAttribute("loginuser");
            number.setNonMoney(Double.valueOf(req.getParameter("NonMoney")));
            number.setId(user.getId());
            number.setYear(Integer.parseInt(req.getParameter("Year")));
            number.setRate(Double.valueOf(req.getParameter("Rate")));
            number.setFuterMoney(Double.valueOf(req.getParameter("FuterMoney")));
            resp.setContentType("text/html;charset=UTF-8");
            //存进number数据库中
            Inumberdao num= DaoFactory.getnumberdao();
            double FuterMoney=number.getFuterMoney();
            double NonMoney=number.getNonMoney();
            double Rate=number.getRate();
            int Year=number.getYear();
            int userid=number.getUserid();
            double  result=0;
            if(select==1){

                FuterMoney=NonMoney*Math.pow((1+Rate ),Year );
                result=FuterMoney;
                session.setAttribute("result",result);
                resp.sendRedirect(req.getContextPath()+"/admin/user/FuliFuterMoney.jsp");
            }
            else if(select==2){
                NonMoney=FuterMoney/Math.pow((1+Rate ),Year ) ;
                result=NonMoney;
                session.setAttribute("result",result);
                resp.sendRedirect(req.getContextPath()+"/admin/user/FuliNonMoney.jsp");

            }else  if(select==3){
                Rate=Math.pow((FuterMoney/NonMoney),1/Year)-1;
                result=Rate;
                session.setAttribute("result",result);
                resp.sendRedirect(req.getContextPath()+"/admin/user/FuliRate.jsp");
            }else  if(select==4){
                Year= (int) ((Math.log(FuterMoney/NonMoney))/(Math.log(1+Rate)));
                result=Year;
                session.setAttribute("result",result);
                resp.sendRedirect(req.getContextPath()+"/admin/user/FuliYear.jsp");
            }else {
                FuterMoney=NonMoney*(1+Rate*Year );
                result=FuterMoney;
                session.setAttribute("result",result);
                resp.sendRedirect(req.getContextPath()+"/admin/user/DanliFuterMoney.jsp");
            }


        }catch (NumberFormatException e){

        }


    }
}
