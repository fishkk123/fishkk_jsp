package com.bosssoft.hr.train.controller;

import com.bosssoft.hr.train.dao.UserDaoImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * 描述
 *
 * @author fishkk
 * @since
 */

@WebServlet("/userCode")
 public class IsExistServlet extends HttpServlet {
    /**
      *
      * @author fishk
      * @date  2019/4/25
      * @param request
      * @param response
      * @exception
      */
        private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
            try {
                 UserDaoImpl userDao = new UserDaoImpl();
                 response.setContentType("text/html");
                 response.setHeader("Cache-Control", "no-store");
                 response.setHeader("Pragma", "no-cache");
                 response.setDateHeader("Expires", 0);
                 String name = request.getParameter("id");
                 Boolean isExistName = userDao.isExist(name);
                 if(isExistName) {
                     out.write("OK");
                 }
                 else {
                     out.write("NO");
                 }
            } finally {
                out.close();
            }
          }

          @Override
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                processRequest(request, response);
           }

          @Override
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                processRequest(request, response);
            }
          @Override
         public String getServletInfo() {
               return "Short description";
          }
       }

