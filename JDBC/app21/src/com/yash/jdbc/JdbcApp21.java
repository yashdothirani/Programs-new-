package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class JdbcApp21 {

	public static void main(String[] args) {
		try (
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
				
				)
		
		{
			 DatabaseMetaData md = con.getMetaData();
			 System.out.println("Database name : " + md.getDatabaseProductName());
			 System.out.println("Database version : " + md.getDatabaseProductVersion());
			 System.out.println("Driver name : " + md.getDriverName());
			 System.out.println("Driver version : " + md.getDriverVersion());
			 System.out.println("Driver major version : " + md.getDriverMajorVersion());
			 System.out.println("Driver minor versin : " + md.getDriverMinorVersion());
			 System.out.println("SQL keywords : " + md.getSQLKeywords());
			 System.out.println("String functions : " + md.getStringFunctions());
			 System.out.println("Numeric functions : " + md.getNumericFunctions());
			 System.out.println("Supports batch update : " + md.supportsBatchUpdates());
			 System.out.println("Supports stored procedures : " + md.supportsStoredFunctionsUsingCallSyntax());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
