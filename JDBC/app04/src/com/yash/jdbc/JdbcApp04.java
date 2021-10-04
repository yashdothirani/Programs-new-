package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcApp04 {

	public static void main(String[] args) {
		BufferedReader br = null; Connection con = null; Statement st = null;
		try  {

			br = new BufferedReader(new InputStreamReader(System.in));
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
			st = con.createStatement();

			String query = "create table ";
			System.out.print("Enter Table name to create : ");
			query += br.readLine() + "(";
			System.out.println("------------------------------------------");

			String primaryKeys = "primary key(";
			int colCount = 1;

			while (true) {

				System.out.print("enter column name : ");
				String colName = br.readLine();
				query += colName + " ";

				System.out.print("enter data type : ");
				query += br.readLine() + "(";

				System.out.print("enter size of the column : ");
				query += br.readLine() + ") ,";

				System.out.print("is it primary key? (yes/no) : ");
				if (br.readLine().equalsIgnoreCase("yes")) {
					if (colCount == 1)
						primaryKeys += colName;
					else
						primaryKeys += "," + colName;
				}

				System.out.print("do u want to add more(yes/no) : ");
				if (br.readLine().equalsIgnoreCase("no")) {
					System.out.println("------------------------------------------");
					primaryKeys += ")";
					query += primaryKeys + ")";
					break;
				}
				colCount++;
				System.out.println("------------------------------------------");
			}
			
			int rowCount = st.executeUpdate(query);
			if(rowCount == 0)
				System.out.println("table created successfully");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
