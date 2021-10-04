package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp09 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
			st = con.createStatement();
			
			int rowCount = st.executeUpdate("create table emp10(eno number(4) primary key , ename varchar2(10))");
			System.out.println("create sql query rowcount : " + rowCount);
			int rowCount2 = st.executeUpdate("drop table emp10 purge");
			System.out.println("drop sql query rowcount : " + rowCount2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
