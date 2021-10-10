package com.yash.jdbc;

import org.logicalcobwebs.proxool.ProxoolDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try {

            ProxoolDataSource ds = new ProxoolDataSource();
            ds.setDriver("oracle.jdbc.OracleDriver");
            ds.setDriverUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUser("system");
            ds.setPassword("yash");
            ds.setMinimumConnectionCount(5);
            ds.setMaximumConnectionCount(10);
            Connection con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp1");
            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4));
            }
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
