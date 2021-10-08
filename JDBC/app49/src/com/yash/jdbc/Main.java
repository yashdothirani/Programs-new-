package com.yash.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try (
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
                CallableStatement cst = con.prepareCall("{? = call getAVG(?,?)}");
                ){
            cst.setInt(2,111);
            cst.setInt(3,222);
            cst.registerOutParameter(1, Types.FLOAT);
            cst.execute();
            System.out.println("Avg Sal : "+cst.getFloat(1));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
