package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.service.ILogin;
import com.bosssoft.hr.train.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
@WebServlet("/user")
public class LoginController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    /**
     *COOKIE保存时间
     */
    private static final int COOKIELIFETIME = 60;
    /**
     * 单选按钮的触发状态
     */
    private static final String CHECKVALUE = "on";

    /**
     *User Service
     */
    private static final  ILogin userService = new UserService();

    /**
      * 构造方法
      * @author fishkk
      * @since 2019/7/18
      */
    public LoginController(){
        super();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("userCode");
        String checkValue = request.getParameter("isRemember");
        String password = request.getParameter("password");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        code = java.net.URLDecoder.decode(code, "UTF-8");
        if(userService.isRight(code,password)) {
            if(checkValue != null && CHECKVALUE.equals(checkValue)) {
                Cookie nameCookie = new Cookie("userCode", code);
                Cookie passWordCookie = new Cookie("password", password);
                nameCookie.setMaxAge(COOKIELIFETIME);
                response.addCookie(nameCookie);
                response.addCookie(passWordCookie);
                System.out.println("进来了");
            }
            request.setAttribute("code", code);
            System.out.println(code);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        else {
            response.getWriter().println("登入失败！！！");
        }
    }

}



