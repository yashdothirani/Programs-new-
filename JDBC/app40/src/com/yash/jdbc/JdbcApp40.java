package com.yash.jdbc;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcApp40 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
				PreparedStatement pst = con.prepareStatement("insert into emp3 values(?,?)");

		) {
			File f = new File("D:/Shiva-Wallpaper-metallic.jpg");
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
