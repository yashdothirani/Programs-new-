package com.yash.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        try {

            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "yash");
            st = con.createStatement();
            con.setAutoCommit(false);
            st.executeUpdate("insert into student values('s1' , 'AAA' , 123)");
            st.executeUpdate("insert into student values('s2' , 'BBB' , 456)");
            st.executeUpdate("insert into student values('s3' , 'CCC' , 678)");
            con.commit();

        } catch (Exception e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
