package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Date;

public class JdbcApp38 {

	public static void main(String[] args) {
		try (
				
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
				PreparedStatement pst = con.prepareStatement("insert into emp2 values(?,?,?,?)");
		)
		{
			pst.setInt(1, 111);
			pst.setString(2, "AAA");
			
			java.util.Date date1 = new java.util.Date();
			long doj = date1.getTime();
			java.sql.Date date = new java.sql.Date(doj);
			pst.setDate(3, date);
			
			java.sql.Date date2 = java.sql.Date.valueOf("2000-08-10");
			pst.setDate(4, date2);
			
			int rowCount = pst.executeUpdate();
			System.out.println("Rows Updated : " + rowCount);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
