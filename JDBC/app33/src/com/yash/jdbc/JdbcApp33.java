package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp33 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
				PreparedStatement pst = con.prepareStatement("insert into emp1 values(?,?,?,?)");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));)

		{

			while (true) {
				System.out.print("enter eno : ");
				int eno = Integer.parseInt(br.readLine());
				System.out.print("enter ename : ");
				String ename = br.readLine();
				System.out.print("enter esal : ");
				float esal = Float.parseFloat(br.readLine());
				System.out.print("enter eaddr : ");
				String eaddr = br.readLine();
				pst.setInt(1, eno);
				pst.setString(2, ename);
				pst.setFloat(3, esal);
				pst.setString(4, eaddr);
				int rowCount = pst.executeUpdate();
				if(rowCount == 1)
					System.out.println("inserted successfully");
				else {
					System.out.println("insertion failure");
					break;
				}
				System.out.print("add more[y/n] : ");

				if (br.readLine().equalsIgnoreCase("n"))
					break;
				else {
					System.out.println("--------------------------------------");
					continue;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
