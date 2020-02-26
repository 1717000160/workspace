package com.Dao;

import com.Model.Admin;
import com.Model.Order;
import com.Model.Users;
import com.Util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class AdminDao {

    public boolean login(Admin admin) throws Exception {
        String sql = "SELECT * FROM admin WHERE UserName = ? AND PASSWORD = ?";
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();
        list.add(admin.getUserName());
        list.add(admin.getPassword());

        ResultSet rs = db.Query(sql, list);
        boolean flag = false;
        if (rs.next()) {
            flag = true;
        }
        db.closeCon();
        return flag;
    }

    public List<Users> getUser() throws Exception{
        String sql = "SELECT * FROM users";
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();

        ResultSet rs = db.Query(sql, list);
        List<Users> list1 = new ArrayList<>();
        while(rs.next())
        {
            Users s = new Users();
            s.setId(rs.getInt("id"));
        s.setUserName(rs.getString("UserName"));
        s.setEmail(rs.getString("email"));
        s.setPassword(rs.getString("password"));
        list1.add(s);
    }

        return list1;

    }

}

