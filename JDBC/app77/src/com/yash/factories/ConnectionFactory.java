package com.yash.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static Connection con;
    static {

        try {
            Class.forName("oracle.jdbc:OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        public static Connection getConnection(){
            return con;
        }

}
