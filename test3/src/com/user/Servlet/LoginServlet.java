package com.user.Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    protected  boolean login(String userName, String password){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM users WHERE UserName = ? AND PASSWORD = ?";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/orderfood?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pwd = "991024";
            con = DriverManager.getConnection(url, user, pwd);
            ps = con.prepareStatement(sql);
            ps.setObject(1, userName);
            ps.setObject(2, password);
            rs = ps.executeQuery();

            //用户名密码正确
            if (rs.next()) {
                return true;
            }

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
        return false;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        //用户名或密码为空时
        if (userName == null || password == null) {
            request.getRequestDispatcher("login.html").forward(request, response);
        }
        else {
            boolean a = login(userName, password);
            request.getSession().setAttribute("IsValid",a);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        int a = 6;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
