package com.yash.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/yashdb");
            rowSet.setUsername("root");
            rowSet.setPassword("yash");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();

            System.out.println("enter range : ");
            float range = Float.parseFloat(br.readLine());
            while (rowSet.next()) {
                if (rowSet.getFloat(3) < range)
rowSet.deleteRow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
