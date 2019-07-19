package com.bosssoft.hr.train.until;

/**
 * 描述
 *
 * @author fishkk
 * @since
 */
import javax.servlet.ServletRequest;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTaglib extends SimpleTagSupport {
    /**
      * 重新实现SimpleTagSupport的方法
      * @author fishkk
      * @date  2019/4/25
      */

    @Override
    public void doTag() throws IOException{

            PageContext pageContext = (PageContext) this.getJspContext();
            //获取request对
            ServletRequest request = pageContext.getRequest();
            String userName = request.getAttribute("code").toString();
            this.getJspContext().getOut().print(userName);
    }
}
