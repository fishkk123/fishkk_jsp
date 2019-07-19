package com.bosssoft.hr.train.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.*;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
public class UserListener implements HttpSessionListener, HttpSessionAttributeListener {


    @Override
    public void sessionCreated(HttpSessionEvent event){

        HttpSession session = event.getSession();
        ServletContext servletContext = session.getServletContext();
        Object object = servletContext.getAttribute("num");
        System.out.println(object.toString());
        if (object == null) {
            servletContext.setAttribute("num", 1);
        } else {
            Object sessionUserNum = servletContext.getAttribute("num");
            int num = (int) sessionUserNum;
            servletContext.setAttribute("num", num + 1);
        }
    };

    @Override
    public void sessionDestroyed(HttpSessionEvent event) {};

    @Override
    public void attributeAdded(HttpSessionBindingEvent event){};

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event){};

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event){};
}
