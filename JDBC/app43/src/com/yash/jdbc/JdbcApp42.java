package com.yash.jdbc;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp42 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				PreparedStatement pst = con.prepareStatement("insert into emp4 values(?,?)");
				
		)
		{
			pst.setString(1,"sample file");
			File f = new File("sample.txt");
			FileReader fr = new FileReader(f);
			pst.setCharacterStream(2, fr , f.length());
			int rowCount = pst.executeUpdate();
			System.out.println("row count : " + rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
