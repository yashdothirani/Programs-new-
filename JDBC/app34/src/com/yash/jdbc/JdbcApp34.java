package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp34 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
				PreparedStatement pst = con.prepareStatement("update emp1 set esal = esal + ? where esal < ? ");
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		) {

			System.out.print("enter bonus : ");
			float bonus = Float.parseFloat(br.readLine());
			System.out.print("enter range : ");
			float range = Float.parseFloat(br.readLine());
			pst.setFloat(1, bonus);
			pst.setFloat(2, range);
			int rowCount = pst.executeUpdate();
			System.out.println("RowCount : " + rowCount);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
