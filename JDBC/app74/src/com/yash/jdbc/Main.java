package com.yash.jdbc;


import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
        WebRowSet rowSet = null;
        FileOutputStream fos = null;
        try {

            rowSet = RowSetProvider.newFactory().createWebRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/yashdb");
            rowSet.setUsername("root");
            rowSet.setPassword("yash");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();

            fos = new FileOutputStream("emp1.xml");

            rowSet.writeXml(fos);
            

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                rowSet.close();
                fos.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
