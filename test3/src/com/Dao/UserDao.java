package com.Dao;

import com.Model.Users;
import com.Util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class UserDao {

    public boolean login(Users user) throws Exception {
        String sql = "SELECT * FROM users WHERE UserName = ? AND PASSWORD = ?";
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();
        list.add(user.getUserName());
        list.add(user.getPassword());

        ResultSet rs = db.Query(sql, list);
        boolean flag = false;
        if (rs.next()) {
            flag = true;
        }
        db.closeCon();
        return flag;
    }

    public void register(Users user) throws Exception {
        String sql = "INSERT INTO users(UserName,PASSWORD,email) VALUES(?,?,?)";
        Connection con = null;
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();
        list.add(user.getUserName());
        list.add(user.getPassword());
        list.add(user.getEmail());
        db.Update(sql, list);

    }

}

