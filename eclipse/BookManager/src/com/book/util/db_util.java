package com.book.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ���ݿ⹤����
 * @author Administrator
 *
 */
public class db_util {
	private String dbUrl = "jdbc:mysql://localhost:3306/db_book";
	private String dbUser = "root";
	private String dbpassword = "991024";
	private String jdbcName = "com.mysql.jdbc.Driver";
	
	/**
	 * �������ݿ�����
	 * @return
	 * @throws Exception
	 */
	
	public Connection getCon() throws Exception{
		Class.forName(jdbcName);
		Connection con=DriverManager.getConnection(dbUrl,dbUser,dbpassword);
		return con;
	}
	
	/**
	 * �ر����ݿ�����
	 */
	public void closeCon(Connection con)throws Exception {
		if(con != null)
			con.close();
	}
	
	public static void main(String[] args) {
		db_util dbutil = new db_util();
		try {
			dbutil.getCon();
			System.out.println("���ݿ����ӳɹ���");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("���ݿ�����ʧ�ܣ�");
		}
	}
}
