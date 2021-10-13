package com.yash.jdbc;

import org.logicalcobwebs.proxool.ProxoolDataSource;
import org.logicalcobwebs.proxool.ProxoolDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
	// write your code here
Connection con = null;
try {

            ProxoolDataSource ds = new ProxoolDataSource();
            ds.setDriver("com.mysql.cj.jdbc.Driver");
            ds.setDriverUrl("jdbc:mysql://localhost:3306/yashdb");
            ds.setUser("root");
            ds.setPassword("yash");
            ds.setMinimumConnectionCount(5);
            ds.setMaximumConnectionCount(10);
            con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp1");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4));
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
