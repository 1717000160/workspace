package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 数据库工具类
 * @author Administrator
 *
 */
public class db_util {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private String dbUser = "root";
	private String dbpassword = "991024";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * 建立数据库链接
	 * @return
	 * @throws Exception
	 */
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbpassword);
		return con;
	}
	
	/**
	 * 关闭数据库链接
	 */
	public void closeCon(Connection con)throws Exception {
		if(con != null)
			con.close();
	}
	
	public static void main(String[] args) {
		db_util dbutil = new db_util();
		try {
			dbutil.getCon();
			System.out.println("数据库链接成功！");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库链接失败！");
		}
	}
}
