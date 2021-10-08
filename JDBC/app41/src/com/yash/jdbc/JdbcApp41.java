package com.yash.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp41 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
				PreparedStatement pst = con.prepareStatement("insert into emp3 values(?,?)");

		) {
			File f = new File("D:/DURGASOFT/ADV JAVA/Programs-new-/Sample Files/Blank diagram.png");//file shize upported is very small..
			FileInputStream fis = new FileInputStream(f);
			pst.setInt(1, 111);
			pst.setBinaryStream(2, fis, f.length());

			int rowCount = pst.executeUpdate();
			System.out.println("Row Count : " + rowCount);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
