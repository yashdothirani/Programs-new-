package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp07 {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
			st = con.createStatement();
			
			String query = "delete emp1 where esal < ";
			
			System.out.print("enter salary range : ");
			query += br.readLine();
			
			int rowCount = st.executeUpdate(query);
			if (rowCount != 0)
				System.out.println(rowCount + " rows deleted");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				br.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
