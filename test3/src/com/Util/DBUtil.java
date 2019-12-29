package com.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class DBUtil {
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection con = null;

    /**
     * 连接数据库
     * @return
     * @throws Exception
     */
    public void getCon() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/orderfood?useUnicode=true&characterEncoding=utf8";
        String user = "root";
        String pwd = "991024";
        con = DriverManager.getConnection(url, user, pwd);
    }

    /**
     * 关闭数据库链接
     */
    public void closeCon()throws Exception {
        if(con != null)
            con.close();
    }

    public ResultSet Query(String sql, List<Object> list)throws Exception{
        getCon();
        ps = con.prepareStatement(sql);
        for(int i = 1; i <= list.size(); i++)
        {
            ps.setObject(i, list.get(i-1));
        }
        rs = ps.executeQuery();
        return rs;
    }

    public void Update(String sql, List<Object> list)throws Exception{
        getCon();
        ps = con.prepareStatement(sql);
        for(int i = 1; i <= list.size(); i++)
            ps.setObject(i, list.get(i - 1));
        int a =5;
        ps.executeUpdate();
        closeCon();
    }

}
