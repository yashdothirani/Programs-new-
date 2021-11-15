package com.yash.jdbc;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;
import java.io.FileReader;

import java.sql.Connection;
import java.sql.DriverManager;


public class Main {

    public static void main(String[] args) {
        WebRowSet rowSet = null;
        FileReader fileReader = null;
    try{

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
        con.setAutoCommit(false);
        rowSet = RowSetProvider.newFactory().createWebRowSet();
        fileReader = new FileReader("D:/DURGASOFT/ADV JAVA/Programs-new-/JDBC/app75/emp1.xml");
        rowSet.setCommand("select * from emp1");
        rowSet.execute(con);
        rowSet.readXml(fileReader);
        rowSet.moveToCurrentRow();
        rowSet.acceptChanges();
        con.close();
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
