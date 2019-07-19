package com.bosssoft.hr.train.filter;
/**
 * 描述
 *
 * @author fishkk
 * @since
 */

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter{
    private static final String PATH = "login";

  /**
    * @方法名
    * @author fishkk
    * @since 2019/4/25
    *
    * @param
    * @return
    */
    @Override
    public void destroy() {
    }

  /**
    * 过滤器 对所有的页面拦截，对非login.jsp页面进行重定向
    * @author fishkk
    * @since 2019/4/25
    *
    * @param
    */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getServletPath();
        System.out.println(path);
        if(session.getAttribute(PATH ) == null && path.indexOf(PATH ) == -1 ){
            System.out.println("没通过" );
            servletResponse.sendRedirect(servletRequest.getContextPath()+"/login.jsp");
            return;
        }else{
            chain.doFilter(request,response);
            System.out.println("通过了" );
        }
    }

    /**
      * @方法名
      * @author fishkk
      * @since 2019/4/25
      *
      * @param
      * @return
      */
    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}
