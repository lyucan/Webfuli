package com.yu.Filter;

import com.yu.model.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by lenovo on 2016/4/9.
 */
public class incFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest Request, ServletResponse Response, FilterChain Chain) throws IOException, ServletException {

        HttpServletRequest rs=(HttpServletRequest)Request;
        HttpServletResponse rp=(HttpServletResponse)Response;
        HttpSession session=rs.getSession();
        User u= (User)session.getAttribute("loginuser");
        if(u==null){
            rp.sendRedirect(((HttpServletRequest) Request).getContextPath()+"/Logininput.jsp");
            return;
        }
        Chain.doFilter(Request,Response);

    }

    @Override
    public void destroy() {

    }
}
