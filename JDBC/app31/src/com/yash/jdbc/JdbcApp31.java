package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp31 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");//supports updatable resultset
//				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash"); //type4 by oracle does not support updatable resultset
				Statement st =con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from emp1");
				)
		
		{
			
			while(rs.next()) {
				if(rs.getInt(1) > 555)
					rs.deleteRow();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
