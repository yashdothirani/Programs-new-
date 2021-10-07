package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp36 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
				PreparedStatement pst = con.prepareStatement("select * from emp1");
				ResultSet rs = pst.executeQuery();
		)
		{
			while(rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getFloat(3) + "\t");
				System.out.println(rs.getString(4) + "\t");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
