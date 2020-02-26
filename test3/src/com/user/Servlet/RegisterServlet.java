package com.user.Servlet;

import com.Dao.AdminDao;
import com.Dao.UserDao;
import com.Model.Admin;
import com.Model.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        if (userName == null || password == null || email == null) {
            request.getRequestDispatcher("register.html").forward(request, response);
        }

        Users user = new Users(userName, password, email);
        UserDao userDao = new UserDao();
        boolean flag = false;
        try {
            userDao.register(user);
            request.getSession().setAttribute("IsAdmin", "true");
            response.sendRedirect("/admin/index.jsp");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
