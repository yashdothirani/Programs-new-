package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp29 {

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
				Statement st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
				ResultSet rs = st.executeQuery("select * from emp1");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));)

		{
			while (true) {
				System.out.println("----------------------------");
				rs.moveToInsertRow();
				System.out.print("Enter eno : ");
				rs.updateInt(1, Integer.parseInt(br.readLine()));
				System.out.print("Enter ename : ");
				rs.updateString(2, br.readLine());
				System.out.print("Enter esal : ");
				rs.updateFloat(3, Float.parseFloat(br.readLine()));
				System.out.print("Enter eaddr : ");
				rs.updateString(4, br.readLine());
				rs.insertRow();
				System.out.print("add more[y/n] : ");
				if ((br.readLine()).equalsIgnoreCase("y"))
					continue;
				else
					break;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
