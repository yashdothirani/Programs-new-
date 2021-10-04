package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp11 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con = DriverManager.getConnection("jdbc:odbc:yas" , "system" , "yash");
			st = con.createStatement();
			
			int rowCount = st.executeUpdate("select * from emp1");
			
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				ResultSet rs = st.getResultSet();
				
				while(rs.next()) {
					System.out.print("\t" + rs.getInt(1));
					System.out.print("\t" + rs.getString(2));
					System.out.print("\t" + rs.getFloat(3));
					System.out.println("\t" + rs.getString(4));
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		finally {
			try {
				st.close();
				con.close();
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
