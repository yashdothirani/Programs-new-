package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp30 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from emp1");
				)
		
		{
			while(rs.next()) {
				if (rs.getFloat(3) < 10000) {
				rs.updateFloat(3, (rs.getFloat(3))-500);
				rs.updateRow();
				}
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
