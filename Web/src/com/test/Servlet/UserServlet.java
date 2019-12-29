package com.test.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "UserServlet", urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //用户名或密码为空时
        if (userName == null || password == null) {
            request.getRequestDispatcher("login.html").forward(request, response);
        }

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jc.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/orderfood?useUnicode" +
                    "=true&characterEncoding=utf8";
            String user = "root";
            String pwd = "991024";
            con = DriverManager.getConnection(url, user, pwd);
            String sql = "SELECT * FROM users WHERE UserName = '" + userName + "' AND PASSWORD = '" + password + "'";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("sucess");
            //用户名密码正确
            if (rs.next()) {
                request.getRequestDispatcher("forgot.html").forward(request, response);
            }

            //用户名密码错误
            request.getRequestDispatcher("login.html").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
                if (rs != null) rs.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
