package com.yash.jdbc;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp42 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				PreparedStatement pst = con.prepareStatement("select * from emp3");
				ResultSet rs = pst.executeQuery();
				FileOutputStream fos = new FileOutputStream("generated_img.jpg");
				
				)
		{
			rs.next();
			System.out.println("Employye number : " + rs.getInt(1));
			InputStream is = rs.getBinaryStream(2);
			int val = is.read();
			while(val != -1) {
				fos.write(val);
				val = is.read();
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
