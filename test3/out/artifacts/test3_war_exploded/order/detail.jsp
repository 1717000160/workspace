<%@ page language="java" import="java.util.*,java.sql.*,com.Dao.FoodDao"
         pageEncoding="UTF-8" %>
<%@ page import="com.Model.Food, com.Dao.FoodDao" %>

<%
    String name = request.getParameter("name");
    String foodId = request.getParameter("foodId");
    //foodName = new String(foodName.getBytes("iso-8859-1"), "UTF-8");
    name = new String(name.getBytes("iso-8859-1"), "UTF-8");
    FoodDao foodDao = new FoodDao();
    List<Food> list = foodDao.qFood(foodId);
    Food f = list.get(0);
    out.print("Welcome:" + name);
%>

<!DOCTYPE html>

<html>
<head>
    <title><%=f.getFoodName()%>介绍</title>
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
            <a href="contact.html">kongkong</a>
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
    <h2><span><%=f.getFoodName()%></span></h2>
    <div id="blogs">
        <div class="sidebar">
            <div class="posts">
                <h3>参考图片</h3>
                <ul>
                    <div>
                        <img src=<%=f.getImg()%>/>
                    </div>
                    <form method="POST"
                          action="/orderFood?userName=<%=name%>&foodId=<%=f.getId()%>&price=<%=f.getPrice()%>">
                        <div class="form-group">
                            <label for="foodName">餐品：</label>

                            <label id="foodName" type="text" class="form-control" name="foodName"
                                   value=<%=f.getFoodName()%>><%=f.getFoodName()%>
                            </label>
                        </div>
                        <div class="form-group">
                            <label for="price">单价：</label>
                            <label id="price" type="text" class="form-control" name="price"
                                   value=<%=f.getPrice()%>>￥<%=f.getPrice()%>
                            </label>
                        </div>

                        <div class="form-group">

                            <label>数量:</label>
                            <label>
                                <input type="text" class="form-control"
                                       id="count" name="count">
                            </label>
                        </div>
                        <div class="form-group">桌号:
                            <select id="table" name="table">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                            </select>
                        </div>
                        <div class="form-group no-margin">
                            <button type="submit" class="btn btn-primary btn-block">
                                点餐
                            </button>
                        </div>
                    </form>
                </ul>
            </div>

        </div>
        <div class="section">
            <p><%=f.getIntroduce()%>
            </p>
        </div>
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
            <li class="selected"><a href="blog.html">Blog</a></li>
            <li><a href="about.html">About</a></li>
            <li class="last"><a href="contact.html">Contact</a></li>
        </ul>
    </div>
</div> <!-- end of footer -->
</body>
</html>