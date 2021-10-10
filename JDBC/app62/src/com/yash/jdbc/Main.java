package com.yash.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            BasicDataSource ds = new BasicDataSource();
            ds.setDriverClassName("oracle.jdbc.OracleDriver");
            ds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUsername("system");
            ds.setPassword("yash");
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");

            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }
}
