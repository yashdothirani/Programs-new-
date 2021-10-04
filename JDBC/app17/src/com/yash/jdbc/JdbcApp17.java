package com.yash.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp17 {

	public static void main(String[] args) {
		Connection con = null;
		Statement st = null;
		FileOutputStream fos = null;

		try {

			
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
			st = con.createStatement();
			fos = new FileOutputStream("abc.csv");
			String data = "ENO,ENAME,ESAL,EADDR\n";
			
			ResultSet rs = st.executeQuery("select * from emp1");
			
			while (rs.next()) {
				data += rs.getInt(1) + "," + rs.getString(2) + "," + rs.getFloat(3) + "," + rs.getString(4) + "\n";			
			}
			
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("file created successfully.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				st.close();
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

}
