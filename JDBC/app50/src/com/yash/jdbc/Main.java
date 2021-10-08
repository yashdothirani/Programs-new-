package com.yash.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
                CallableStatement cst = con.prepareCall("{? = call sumSAL(?)}")
                ){
            cst.setInt(2 , 5000);
            cst.registerOutParameter(1, Types.FLOAT);
            cst.execute();
            System.out.println("sum of all salaries below 5000 : "+ cst.getFloat(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
