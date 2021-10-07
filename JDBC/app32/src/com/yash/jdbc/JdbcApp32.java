package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JdbcApp32 {

	public static void main(String[] args) {
		try(
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
				Statement st = con.createStatement();
				
				) 
		
		{
			st.addBatch("insert into emp1 values(666 , 'FFF' , 9000 , 'Hyd')");
			st.addBatch("insert into emp1 values(777 , 'GGG' , 10000 , 'Hyd')");
			st.addBatch("insert into emp1 values(888 , 'HHH' , 11000 , 'Hyd')");
			st.addBatch("update emp1 set esal = esal + 1000");
			st.addBatch("delete from emp1 where esal > 10000");
			int[] rowCounts = st.executeBatch();
			for(int rowCount : rowCounts)
				System.out.println("Row Count : " + rowCount);
} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
