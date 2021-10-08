package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	try {

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb" , "root" , "yash");
        Statement st = con.createStatement();
        int rowCount = st.executeUpdate("insert into emp1 values(123 , 'ABC', 1234 , 'Hyd')");
        System.out.println("rowCount = " + rowCount);
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
