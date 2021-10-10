package com.yash.jdbc;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
Connection con = null;
Statement st = null;
ResultSet rs = null;
        try {
            OracleDataSource ds = new OracleDataSource();
            ds.setURL("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUser("system");
            ds.setPassword("yash");
            con = ds.getConnection();
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            System.out.println("-----------------------------");
            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
