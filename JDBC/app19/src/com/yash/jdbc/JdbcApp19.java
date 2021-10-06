package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp19 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		BufferedReader br = null;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
			st = con.createStatement();
			br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter SQL Query : ");
			String query = br.readLine();
			boolean b = st.execute(query);
			if(b == false) {
				int rowCount = st.getUpdateCount();
				System.out.println(rowCount+" rows updated.");
			}
			else {
				rs = st.getResultSet();
				while(rs.next()) {
					System.out.print("\t" + rs.getInt(1));
					System.out.print("\t" + rs.getString(2));
					System.out.print("\t" + rs.getFloat(3));
					System.out.println("\t" + rs.getString(4));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
				st.close();
				con.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
