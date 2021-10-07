package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp28 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("select * from emp1");
				) 
		
		{
			rs.afterLast();
			rs.previous();
			System.out.println(rs.getInt(1));
			rs.beforeFirst();
			rs.next();
			System.out.println(rs.getInt(1));
			rs.first();
			System.out.println(rs.getInt(1));

			rs.last();
			System.out.println(rs.getInt(1));

			rs.absolute(3);
			System.out.println(rs.getInt(1));

			rs.relative(-1);
			System.out.println(rs.getInt(1));

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
