<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Object isValid = request.getSession().getAttribute("IsValid");
  if(!(isValid != null && isValid.equals(true))){
    request.getRequestDispatcher("login.html").forward(request, response);
  }
%>
<!DOCTYPE html>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  $END$
  </body>
</html>
