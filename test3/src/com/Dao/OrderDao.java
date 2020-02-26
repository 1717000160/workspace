package com.Dao;

import com.Model.Food;
import com.Model.Order;
import com.Util.DBUtil;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class OrderDao {

    public List getOrder() throws Exception {
        String sql = "SELECT * FROM `order`";
        List<Object> list = new ArrayList<>();
        DBUtil db = new DBUtil();

        ResultSet rs = db.Query(sql, list);
        List<Order> list1 = new ArrayList<>();
        while(rs.next()){
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setFoodName(rs.getString("foodName"));
            order.setTableId(rs.getInt("table_id"));
            order.setCount(rs.getInt("count"));
            order.setTime(rs.getString("orderTime"));
            order.setTotalPrice(rs.getFloat("totalPrice"));
            order.setStatus(rs.getInt("orderStatus"));
            list1.add(order);
        }

        db.closeCon();
        return list1;
    }

    public List qOrder(String tableId) throws Exception {
        String sql = "SELECT * FROM order where table_id = '"+tableId+"'";
        List<Object> list = new ArrayList<>();
        DBUtil db = new DBUtil();

        ResultSet rs = db.Query(sql, list);
        List<Order> list1 = new ArrayList<>();
        while(rs.next()){
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setFoodName(rs.getString("foodName"));
            order.setTableId(rs.getInt("table_id"));
            order.setCount(rs.getInt("count"));
            order.setTime(rs.getString("orderTime"));
            order.setTotalPrice(rs.getFloat("totalPrice"));
            order.setStatus(rs.getInt("orderStatus"));
            list1.add(order);
        }

        db.closeCon();
        return list1;
    }

    public void setOrder(Order order) throws Exception {
        String sql = "INSERT INTO `order`(foodName,table_id, count, orderTime,totalPrice,orderStatus) VALUES(?,?,?,?,?,?)";
        Connection con = null;
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();
        list.add(order.getFoodName());
        list.add(order.getTableId());
        list.add(order.getCount());
        list.add(order.getTime());
        list.add(order.getTotalPrice());
        list.add(order.getStatus());
        db.Update(sql, list);

    }

}

