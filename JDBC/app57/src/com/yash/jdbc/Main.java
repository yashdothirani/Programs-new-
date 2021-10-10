package com.yash.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
            con.setAutoCommit(false);
            pst = con.prepareCall("insert into emp10 values(?,?,?)");

            pst.setInt(1,111);
            pst.setString(2,"AAA");
            pst.setFloat(3,1000);
            pst.executeUpdate();

            Savepoint sp = con.setSavepoint();
            pst.setInt(1,222);
            pst.setString(2,"BBB");
            pst.setFloat(3,2000);
            pst.executeUpdate();
//            con.rollback(sp);
            con.releaseSavepoint(sp);

            pst.setInt(1,333);
            pst.setString(2,"CCC");
            pst.setFloat(3,3000);
            pst.executeUpdate();

            con.commit();


        }catch (Exception e){

            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }finally {
            try {
                pst.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
