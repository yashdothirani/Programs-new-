package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp05 {

	public static void main(String[] args) {
		BufferedReader br = null;
		Connection con = null;
		Statement st = null;
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
			st = con.createStatement();
//			string query = "insert into emp1 values(";
			
			while (true) {
				System.out.println("-----------------------------------------");
				
				String query = "insert into emp1 values(";
				
				System.out.print("enter eno : ");
				query += Integer.parseInt(br.readLine());
				
				System.out.print("enter ename : ");
				query += ",'" + br.readLine() + "',";
				
				System.out.print("enter esal : ");
				query += Float.parseFloat(br.readLine());
				
				System.out.print("enter eaddr : ");
				query += ",'" + br.readLine() + "')";
				
				int RowCount = st.executeUpdate(query);
				if(RowCount == 1)
					System.out.println("Inserted Successfully");
				
				System.out.print("do you want to add more? (y/n) : ");
				if(br.readLine().equalsIgnoreCase("n"))
					break;
				
			}
			
			System.out.println("-----------------------------------------");
			
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
