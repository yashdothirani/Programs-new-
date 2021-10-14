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
        BufferedReader br;
        CachedRowSet rowSet = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.jdbc.Driver");
            rowSet = RowSetProvider.newFactory().createCachedRowSet();
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb", "root", "yash");
            con.setAutoCommit(false);
            rowSet.setCommand("select * from emp");
            rowSet.execute(con);

            rowSet.moveToInsertRow();
            while (true) {
                System.out.println("enter no : ");
                int eno = Integer.parseInt(br.readLine());
                System.out.println("enter name : ");
                String ename = br.readLine();
                System.out.println("enter sal : ");
                float esal = Float.parseFloat(br.readLine());
                System.out.println("enter addr : ");
                String eaddr = br.readLine();

                rowSet.updateInt(1,eno);
                rowSet.updateString(2,ename);
                rowSet.updateFloat(3,esal);
                rowSet.updateString(4,eaddr);

                rowSet.insertRow();
                System.out.println("add more? : ");
                if (br.readLine().equals("no"))
                    break;

            }


            rowSet.moveToCurrentRow();
            rowSet.acceptChanges();

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
