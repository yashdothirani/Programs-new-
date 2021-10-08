package com.yash.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {


        try (
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
                CallableStatement cst = con.prepareCall("{call getSal(?,?)}")
        ) {
            cst.setInt(1, 111);
            cst.registerOutParameter(2, Types.FLOAT);
            cst.execute();
            System.out.println("employee salary : " + cst.getFloat(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
