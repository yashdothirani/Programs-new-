package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp35 {

	public static void main(String[] args) {
		try
(
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root" , "yash");
				PreparedStatement pst = con.prepareStatement("delete from emp1 where esal > ?");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		)

		{
			
			System.out.print("enter range : ");
			float range = Float.parseFloat(br.readLine());
			pst.setFloat(1, range);
			int rowCount = pst.executeUpdate();
			System.out.println(rowCount + " rows deleted.");
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
