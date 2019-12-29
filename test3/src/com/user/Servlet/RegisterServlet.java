package com.user.Servlet;

import com.sun.xml.internal.bind.v2.model.core.RegistryInfo;

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

@WebServlet(name = "RegisterServlet", urlPatterns = {"/Register"})
public class RegisterServlet extends HttpServlet {
    protected  void Register(String userName, String password, String  email){
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO users(UserName,PASSWORD,email) VALUES(?,?,?)";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/orderfood?useUnicode=true&characterEncoding=utf8";
            String user = "root";
            String pwd = "991024";
            con = DriverManager.getConnection(url, user, pwd);
            ps = con.prepareStatement(sql);
            ps.setObject(1, userName);
            ps.setObject(2, password);
            ps.setObject(3,email);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) con.close();
                if (ps != null) ps.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        //用户资料填写不完整时
        if (userName == null || password == null || email == null) {
            request.getRequestDispatcher("register.html").forward(request, response);
        }
        else {
            Register(userName, password, email);
            request.getRequestDispatcher("login.html").forward(request, response);
        }
       int a = 6;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
