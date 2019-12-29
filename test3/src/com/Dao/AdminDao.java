package com.Dao;

import com.Model.Admin;
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

}

