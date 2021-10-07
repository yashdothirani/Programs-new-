package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class JdbcApp25 {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		try (
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb" , "root" , "yash");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE , ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = st.executeQuery("select * from emp1");
				
				) 
		{
			ResultSetMetaData md = rs.getMetaData();
			int colCount = md.getColumnCount();
			
			for(int i = 1;i <= colCount;i++) {
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("-------------------------------");
			while(rs.next()) {
				for(int i = 1;i <= colCount;i++) {
				System.out.print(rs.getString(md.getColumnName(i)) + "\t");
				}
				System.out.println();
			}
			System.out.println("-------------------------------");
			for(int i = 1;i <= colCount;i++) {
				System.out.print(md.getColumnName(i)+"\t");
			}
			System.out.println();
			System.out.println("-------------------------------");
			while(rs.previous()) {
				for(int i = 1;i <= colCount;i++) {
				System.out.print(rs.getString(md.getColumnName(i)) + "\t");
				}
				System.out.println();
			}
			System.out.println("-------------------------------");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
