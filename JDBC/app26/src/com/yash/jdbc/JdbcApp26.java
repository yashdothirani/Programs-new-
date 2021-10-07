package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp26 {

	public static void main(String[] args) {
		try{
			Connection con = DriverManager.getConnection("jdbc:odbc:yas" , "system" , "yash");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//Not supported by type 4 driver by oracle
			ResultSet rs = st.executeQuery("select * from emp1");
			
			while(rs.next()) {
			System.out.print(rs.getInt(1) + "\t");
			System.out.print(rs.getString(2) + "\t");
			System.out.print(rs.getFloat(3) + "\t");
			System.out.println(rs.getString(4) + "\t");
			}
			
			System.in.read();
			
			System.out.println("---------------------------------------");
			rs.beforeFirst();
			while(rs.next()) {
				rs.refreshRow();
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
