package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp12 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:yas" , "system" , "yash");
			st = con.createStatement();
			
			ResultSet rs = st.executeQuery("update emp1 set esal = esal - 500");
			
		} catch (Exception e) {
			try {
				int rowCount = st.getUpdateCount();
				System.out.println("rowCount : " + rowCount);
			} catch (Exception e2) {
			e2.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
