<%@ page language="java" import="java.util.*,java.sql.*,com.Dao.FoodDao"
         pageEncoding="UTF-8" %>
<%@ page import="com.Model.Food" %>

<%
    //获取session信息
    Object isValid = request.getSession().getAttribute("IsValid");
    if (isValid == null) {
        request.getRequestDispatcher("login.html").forward(request, response);
    }
    String userName = isValid.toString();
    out.print("<h1>Welcome: " + userName + "</h1>");



%>


<!DOCTYPE html>

<html>
<head>
    <title>点餐</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <!--[if IE 7]>
    <link rel="stylesheet" type="text/css" href="css/ie7.css">
    <![endif]-->
    <!--[if IE 6]>
    <link rel="stylesheet" type="text/css" href="css/ie6.css">
    <![endif]-->
</head>
<body>
<div id="header"> <!-- start of header -->
    <span class="signboard"></span>
    <ul id="infos">
        <li class="home">
            <a href="index.html">主页</a>
        </li>
        <li class="phone">
            <a href="contact.html">233666</a>
        </li>
        <li class="address">
            <a href="contact.html">空空</a>
        </li>
    </ul>

    <a href="index.html" id="logo"></a>
    <ul id="navigation">
        <li><a href="menu.jsp"><span>推荐</span></a></li>
        <li class="main"><a href="menu.jsp"><span>主菜</span></a></li>
        <li><a href="menu.jsp"><span>小吃</span></a></li>
        <li><a href="menu.jsp"><span>饮品</span></a></li>
    </ul> <!-- /#navigation -->
</div> <!-- end of header -->
<div id="contents"> <!-- start of contents -->
    <h2 class="main-course"><span>菜单</span></h2>
    <div id="menus">
        <ul class="main">
            <li>
                <h3>推荐</h3>
                <ul>
                    <%
                        //获取食物信息并显示
                        FoodDao foodDao = new FoodDao();
                        List<Food> list = foodDao.getFood();
                        for(Food f : list){
                            if(f.getPrice() >= 20){
                    %>
                    <li>
                        <span class="price">¥<%=f.getPrice()%></span>
                        <a href="detail.jsp?name=<%=userName%>&foodName=<%=f.getFoodName()%>"><%=f.getFoodName()%></a>
                        <p><%=f.getIntroduce()%></p>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
            <li>
                <h3>主菜</h3>
                <ul>
                    <%
                        for(Food f : list){
                            if(f.getFoodType() == 1){
                    %>
                    <li>
                        <span class="price">¥<%=f.getPrice()%></span>
                        <a href="detail.jsp?name=<%=userName%>&foodName=<%=f.getFoodName()%>"><%=f.getFoodName()%></a>
                        <p><%=f.getIntroduce()%></p>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
            <li>
                <h3>小吃</h3>
                <ul>
                    <%
                        for(Food f : list){
                            if(f.getFoodType() == 2){
                    %>
                    <li>
                        <span class="price">¥<%=f.getPrice()%></span>
                        <a href="detail.jsp?name=<%=userName%>&foodName=<%=f.getFoodName()%>"><%=f.getFoodName()%></a>
                        <p><%=f.getIntroduce()%></p>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
            <li>
                <h3>饮品</h3>
                <ul>
                    <%
                        for(Food f : list){
                            if(f.getFoodType() == 3){
                    %>
                    <li>
                        <span class="price">¥<%=f.getPrice()%></span>
                        <a href="detail.jsp?name=<%=userName%>&foodName=<%=f.getFoodName()%>"><%=f.getFoodName()%></a>
                        <p><%=f.getIntroduce()%></p>
                    </li>
                    <%
                            }
                        }
                    %>
                </ul>
            </li>
        </ul>
    </div>
</div> <!-- end of contents -->

<div id="footer"> <!-- start of footer -->
    <ul class="advertise">
        <li class="delivery">
            <h2>Hungry? We Deliver</h2>
            <a href="menu.jsp">Download our Menu</a>
        </li>
        <li class="event">
            <h2>Party! Party!</h2>
            <p>Celebrate your</p>
            <p>Special Events with Us</p>
        </li>
        <li class="connect">
            <h2>Let's Keep in Touch</h2>
            <a href="#" target="_blank" class="fb" title="Facebook"></a>
            <a href="#" target="_blank" class="twitr" title="Twitter"></a>
        </li>
    </ul>
    <div>
        <ul class="navigation">
            <li><a href="index.html">Home</a></li>
            <li><a href="booking.html">Book an event</a></li>
            <li><a href="blog.html">Blog</a></li>
            <li><a href="about.html">About</a></li>
            <li class="last"><a href="contact.html">Contact</a></li>
        </ul>
    </div>
</div> <!-- end of footer -->
</body>
</html>