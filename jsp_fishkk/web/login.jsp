<%@ page import="java.net.URLDecoder" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"  %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
</head>
<body>
<center>
    <%
        String userCode = null;
        String password = null;
        Cookie cookieArr[] = request.getCookies();
        if(cookieArr!=null && cookieArr.length>0){
            for(Cookie c:cookieArr){
                if(c.getName().equals("userCode")){
                    userCode = URLDecoder.decode(c.getValue(),"UTF-8");
                }
                if(c.getName().equals("password")){
                    password = URLDecoder.decode(c.getValue(),"UTF-8");
                }
            }
        }
    %>

    <form  method="post" action="user?type=login">
            <label>用户名</label>
                <input type="text" value="<%if(userCode!=null){out.print(userCode);}%>"id="userCode" name="userCode" onblur="validate()" placeholder="请输登入名">
    <br/>
            <label>密码</label>
            <input type="password" value="<%if(userCode!=null){out.print(password);}%>" name="password" id="password" placeholder="请输密码">
        <br/>
                <button type="submit" >登录</button>
    </br>
        <input type="radio" name="isRemember" >记住密码<br>
    </form>
    <span id="info"></span>
</center>
</body>
</html>


<script>
    var req;
    function validate(){
    //获取表单提交的内容
    var userCode = document.getElementById("userCode");
    //访问servlet，同时把获取的表单内容idField加入url字符串
    var url = "userCode?id=" + escape(userCode.value);
   //创建一个XMLHttpRequest对象req
        if(window.XMLHttpRequest) {
            req = new XMLHttpRequest();
        }else if(window.ActiveXObject) {
            req = new ActiveXObject("Microsoft.XMLHTTP");
        }

       req.open("GET", url, true);
           //onreadystatechange属性存有处理服务器响应的函数,有5个取值分别代表不同状态
             req.onreadystatechange = callback;
          //send函数发送请求
          req.send(null);
       }

  function callback() {
        // 200表示服务器已经成功响应。 4：请求已经完成（可以访问服务器响应并使用它）
          if(req.readyState == 4 && req.status == 200) {
                   var check = req.responseText;
                    show (check);
               }
        }
    function show(str) {
           if(str == "OK") {
                   var show = "<font color='green'>账号存在！</font>";
                     document.getElementById("info").innerHTML = show;
                }
           else if( str == "NO") {
                    var show = "<font color='red'>账号不存在！！请重新输入！</font>";
                   document.getElementById("info").innerHTML = show;
                }
         }

</script>
