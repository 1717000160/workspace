package com.Servlet;

import com.Dao.FoodDao;
import com.Dao.OrderDao;
import com.Model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

@WebServlet(name = "orderServlet", urlPatterns = {"/orderFood"})
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String foodId = request.getParameter("foodId");
        FoodDao foodDao = new FoodDao();
        String foodName = null;
        try {
            foodName = foodDao.id2name(foodId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = Integer.parseInt(request.getParameter("count"));
        int tableId = Integer.parseInt(request.getParameter("table"));
        float price = Float.parseFloat(request.getParameter("price"));
        float totalPrice = price * count;
        int status = 0;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = df.format(date);
        Order order = new Order(foodName, tableId, count, time, totalPrice, status);
        OrderDao Dao = new OrderDao();
        try {
            Dao.setOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getSession().setAttribute("IsValid", userName);
        response.sendRedirect("/order/menu.jsp");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
