package com.yash.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;


import java.sql.SQLException;


public class Main {

    public static void main(String[] args) {
        JdbcRowSet rowSet = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/yashdb");
            rowSet.setUsername("root");
            rowSet.setPassword("yash");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();
            while (rowSet.next()) {
                System.out.println(rowSet.getInt(1) + "\t" + rowSet.getString(2) + "\t" + rowSet.getFloat(3) + "\t" + rowSet.getString(4));
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rowSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}


