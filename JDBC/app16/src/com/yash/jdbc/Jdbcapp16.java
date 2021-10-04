package com.yash.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Jdbcapp16 {

	public static void main(String[] args) {
		
		Connection con = null;
		Statement st = null;
		FileOutputStream fos = null;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
			st = con.createStatement();
			
			String data = "<html><body><table align = 'center' border = '1'>";
			data += "<tr><th>ENO</th><th>ENAME</th><th>ESAL</th><th>EADDR</th>";
			
			ResultSet rs = st.executeQuery("select * from emp1");
			
			while(rs.next()) {
				data += "<tr><td>"+ rs.getInt(1) +"</td>";
				data += "<td>"+ rs.getString(2) +"</td>";
				data += "<td>"+ rs.getFloat(3) +"</td>";
				data += "<td>"+ rs.getString(4) +"</td></tr>";
			}
			
			data += "</html></body></table>";
			
			fos = new FileOutputStream("index.html");
			byte[] b = data.getBytes();
			fos.write(b);
			System.out.println("file created successfully.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
