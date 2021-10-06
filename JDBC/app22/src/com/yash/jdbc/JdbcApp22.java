package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JdbcApp22 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("select * from emp1");

		)

		{
			ResultSetMetaData md = rs.getMetaData();
			System.out.println("column count : " + md.getColumnCount());
			for(int i = 1;i < md.getColumnCount();i++) {
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
