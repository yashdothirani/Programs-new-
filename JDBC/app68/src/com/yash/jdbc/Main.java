package com.yash.jdbc;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            Class.forName("com.mysql.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/yashdb");
            rowSet.setUsername("root");
            rowSet.setPassword("yash");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();

            System.out.println("enter bonus: ");
            float bonus = Float.parseFloat(br.readLine());
            System.out.println("enter range : ");
            float range = Float.parseFloat(br.readLine());

            while (rowSet.next()){
                float sal = rowSet.getFloat("esal");
                if (sal < range) {
                    rowSet.updateFloat("ESAL",sal+bonus);
                    rowSet.updateRow();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
