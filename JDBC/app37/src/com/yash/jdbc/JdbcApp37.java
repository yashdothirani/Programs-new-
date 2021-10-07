package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcApp37 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb" , "root" , "yash");
				PreparedStatement pst = con.prepareStatement("insert into emp1 values(?,?,?,?)");
				
		)
		{
			pst.setInt(1,222 );
			pst.setString(2, "BBB");
			pst.setFloat(3, 2000);
			pst.setString(4, "Hyd");
			pst.addBatch();
			
			pst.setInt(1, 333);
			pst.setString(2, "CCC");
			pst.setFloat(3, 3000);
			pst.setString(4, "Hyd");
			pst.addBatch();

			pst.setInt(1, 666);
			pst.setString(2, "FFF");
			pst.setFloat(3, 6000);
			pst.setString(4, "Hyd");
			pst.addBatch();
			
			int[] rowCounts = pst.executeBatch();
			for(int rowCount : rowCounts)
				System.out.println("Rows Inserted  : " + rowCount);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}

}
