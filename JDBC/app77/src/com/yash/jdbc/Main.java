package com.yash.jdbc;

import com.yash.factories.ConnectionFactory;
import oracle.jdbc.OracleDriver;

import java.io.FileInputStream;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        try {
            /*

//            Class.forName("oracle.jdbc.OracleDriver");  //1
//            OracleDriver driver = new OracleDriver();   //2
//            DriverManager.registerDriver(new OracleDriver());   //3
//            //optional to load.

             */


//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");

//            Properties p = new Properties();
//            p.setProperty("user","system");
//            p.setProperty("password","yash");
//            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",p);

//            Properties p = new Properties();
//            p.load(new FileInputStream("db.properties"));
//            Connection con = DriverManager.getConnection(p.getProperty("driverUrl"),p.getProperty("user"),p.getProperty("password"));

            Connection con = ConnectionFactory.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from emp1");

            while (rs.next()){
                System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
