package com.yash.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.jboss.C3P0PooledDataSource;

import javax.sql.PooledConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {

        try{
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("oracle.jdbc.OracleDriver");
            ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
            ds.setUser("system");
            ds.setPassword("yash");
            ds.setMinPoolSize(5);
            ds.setMaxPoolSize(10);
            Connection con = ds.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp1");
            while(rs.next()){
                System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getFloat(3) + "\t" + rs.getString(4));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
