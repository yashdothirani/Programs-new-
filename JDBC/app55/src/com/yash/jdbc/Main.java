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
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
            con.setAutoCommit(false);
            st = con.createStatement();

            int rowCount1 = st.executeUpdate("update account set balance = balance - 10000 where acno = 'abc123'");
            int rowCount2 = st.executeUpdate("update account set balance = balance + 10000 where acno = 'xyz789'");

            if(rowCount1 == 1 && rowCount2 == 1){
                con.commit();
                System.out.println("balance of 10k transferred from abc123 to xyz789");
            }
        } catch (SQLException e) {
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

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
