package com.Dao;

import com.Model.Food;
import com.Util.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class FoodDao {

    public List getFood() throws Exception {
        String sql = "SELECT * FROM food";
        List<Object> list = new ArrayList<>();
        DBUtil db = new DBUtil();

        ResultSet rs = db.Query(sql, list);
        List<Food> list1 = new ArrayList<>();
        while(rs.next()){
            Food food = new Food();
            food.setId(rs.getInt("id"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodType(rs.getInt("foodType_id"));
            food.setIntroduce(rs.getString("introduce"));
            food.setPrice(rs.getFloat("price"));
            list1.add(food);
        }

        db.closeCon();
        return list1;
    }

    public List qFood(String foodName) throws Exception {
        String sql = "SELECT * FROM food where foodName = '"+foodName+"'";
        List<Object> list = new ArrayList<>();
        DBUtil db = new DBUtil();

        ResultSet rs = db.Query(sql, list);
        List<Food> list1 = new ArrayList<>();
        while(rs.next()){
            Food food = new Food();
            food.setId(rs.getInt("id"));
            food.setFoodName(rs.getString("foodName"));
            food.setFoodType(rs.getInt("foodType_id"));
            food.setIntroduce(rs.getString("introduce"));
            food.setPrice(rs.getFloat("price"));
            food.setImg(rs.getString("img"));
            list1.add(food);
        }

        db.closeCon();
        return list1;
    }

    public void setFood(Food food) throws Exception {
        String sql = "INSERT INTO food(foodName,foodType_id,price,introduce) VALUES(?,?,?,?)";
        Connection con = null;
        DBUtil db = new DBUtil();
        List<Object> list = new ArrayList<>();
        list.add(food.getFoodName());
        list.add(food.getFoodType());
        list.add(food.getPrice());
        list.add(food.getIntroduce());
        db.Update(sql, list);

    }

}

