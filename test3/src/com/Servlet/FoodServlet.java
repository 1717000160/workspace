package com.Servlet;

import com.Dao.FoodDao;
import com.Model.Food;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;

@WebServlet(name = "FoodServlet", urlPatterns = {"/Food"})
public class FoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String foodName = request.getParameter("foodName");
        foodName = URLDecoder.decode(foodName,"UTF-8");
        int foodType = Integer.parseInt(request.getParameter("foodType"));
        float price = Float.parseFloat(request.getParameter("price")) ;
        String introduce = request.getParameter("introduce");
        introduce = URLDecoder.decode(introduce,"UTF-8");
        String img = request.getParameter("img");
        Food f = new Food(foodName,foodType,price,introduce,img);
        FoodDao fd = new FoodDao();
        try {
            fd.setFood(f);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getSession().setAttribute("IsAdmin", "true");
        response.sendRedirect("/admin/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
