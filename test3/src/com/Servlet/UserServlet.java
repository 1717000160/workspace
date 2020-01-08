package com.Servlet;

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

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("Type");

        if (type.equals("Login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String isAdmin = request.getParameter("isAdmin");
            if (isAdmin == null) isAdmin = "user";

            //用户名或密码为空时
            if (userName == null || password == null) {
                request.getRequestDispatcher("login.html").forward(request, response);
            }

            if (isAdmin.equals("admin")) {
                Admin user = new Admin(userName, password);
                AdminDao Dao = new AdminDao();
                boolean flag = false;
                try {
                    if (Dao.login(user)) flag = true;
                    else flag = false;
                    int a = 0;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.getSession().setAttribute("IsAdmin", flag);
                request.getRequestDispatcher("admin.jsp").forward(request, response);
            }

            Users user = new Users(userName, password, "0");
            UserDao Dao = new UserDao();
            boolean flag = false;
            try {
                if (Dao.login(user)) flag = true;
                else flag = false;
                int a = 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (flag == true)
                request.getSession().setAttribute("IsValid", userName);
            response.sendRedirect("/order/menu.jsp");

        }
        if (type.equals("Register")) {
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
                request.getRequestDispatcher("login.html").forward(request, response);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
