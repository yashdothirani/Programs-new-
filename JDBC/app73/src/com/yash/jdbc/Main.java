package com.yash.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        CachedRowSet rowSet = null;
        BufferedReader br;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.cj.jdbc.Driver");
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
            con.setAutoCommit(false);
            rowSet.setCommand("select * from emp1");
            rowSet.execute(con);

            System.out.println("enter range : ");
            float range = Float.parseFloat(br.readLine());

            while(rowSet.next()){
                if(rowSet.getFloat(3) >= range)
                    rowSet.deleteRow();
            }
            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rowSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
