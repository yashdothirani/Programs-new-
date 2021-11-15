package com.yash.jdbc;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {

    public static void main(String[] args) {
	try{
        JoinRowSet rowSet = RowSetProvider.newFactory().createJoinRowSet();
        CachedRowSet rowSet1 = RowSetProvider.newFactory().createCachedRowSet();
        CachedRowSet rowSet2 = RowSetProvider.newFactory().createCachedRowSet();
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");
        con.setAutoCommit(false);
        rowSet1.setCommand("select * from student");
        rowSet2.setCommand("select * from course");
        rowSet1.execute(con);
        rowSet2.execute(con);
        rowSet.addRowSet(rowSet1,4);
        rowSet.addRowSet(rowSet2,1);

        while(rowSet.next()){
            System.out.println(rowSet.getString(1) + "\t" + rowSet.getString(2) + "\t" + rowSet.getString(3) + "\t" + rowSet.getString(4) + "\t" + rowSet.getString(5) + "\t" + rowSet.getInt(6));
        }


    }catch(Exception e){
        e.printStackTrace();
        }
    }
}
