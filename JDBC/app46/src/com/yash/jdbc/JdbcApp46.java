package com.yash.jdbc;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp46 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				PreparedStatement pst = con.prepareStatement("select * from adv_java");
				ResultSet rs = pst.executeQuery();
		)
		{
			rs.next();
			System.out.println("course name :: " + rs.getString(1));
			FileOutputStream fos = new FileOutputStream("generated_img.png");
			InputStream is = rs.getBinaryStream(2);
			int val = is.read();
			while(val != -1) {
				fos.write(val);
				val = is.read();
			}
			is.close();
			fos.close();
			
			FileWriter fw = new FileWriter("generated_file.txt");
			Reader r = rs.getCharacterStream(3);
			val = r.read();
			while(val != -1) {
				fw.write(val);
				val = r.read();
			}
		
			
			r.close();
			fw.close();

		} catch (Exception e) {
e.printStackTrace();
		}
	}

}
