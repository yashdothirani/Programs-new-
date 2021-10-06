package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Iterator;

public class JdbcApp23 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from emp1");
				
				)
		
		{
			
			ResultSetMetaData md = rs.getMetaData();
			System.out.println("----------------------------------------");
			int colCount = md.getColumnCount();
			for(int i = 1;i <= colCount;i++) {
				System.out.print(md.getColumnName(i) + "\t");
			}
			System.out.println();
			System.out.println("----------------------------------------");
			while(rs.next()) {
				for(int i = 1;i <= colCount;i++) {
					System.out.print(rs.getString(md.getColumnName(i)) + "\t");
				}
				System.out.println();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
