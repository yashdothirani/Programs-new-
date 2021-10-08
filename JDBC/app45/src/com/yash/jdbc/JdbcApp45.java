package com.yash.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp45 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				PreparedStatement pst = con.prepareStatement("insert into adv_java values(?,?,?)");
		)
		{
			pst.setString(1, "adv java");
			File f1 = new File("D:/DURGASOFT/ADV JAVA/Programs-new-/Sample Files/Blank diagram.png");
			FileInputStream fis = new FileInputStream(f1);
			pst.setBinaryStream(2, fis , f1.length());
			f1 = new File("sample.txt");
			FileReader fr = new FileReader(f1);
			pst.setCharacterStream(3, fr , f1.length());
			int rowCount = pst.executeUpdate();
			if (rowCount == 1)
					System.out.println("inserted successfully");
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
