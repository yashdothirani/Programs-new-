package com.yash.jdbc;

import com.mysql.cj.protocol.Resultset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
            st = con.createStatement();
            rs = st.executeQuery("select * from emp1");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
