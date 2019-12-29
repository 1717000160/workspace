<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object isAdmin = request.getSession().getAttribute("IsAdmin");
    if(!(isAdmin != null && isAdmin.equals(true))){
        request.getRequestDispatcher("login.html").forward(request, response);
    }
%>
<!DOCTYPE html>
<html>
<head>
    <title>管理员</title>
</head>
<body>
管理员
</body>
</html>