package com.yash.jdbc;

import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcApp44 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
				PreparedStatement pst = con.prepareStatement("select * from emp4");
				ResultSet rs = pst.executeQuery();
		)
		{
			rs.next();
			System.out.println("file name = " + rs.getString(1));
			FileWriter fw = new FileWriter("generated_file.txt");
			Reader r = rs.getCharacterStream(2);
			int val = r.read();
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
