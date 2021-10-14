package com.yash.jdbc;



import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;
import java.io.BufferedReader;

public class Main {

    public static void main(String[] args) {
//        JdbcRowSet rowSet = null;
        BufferedReader br = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();
            rowSet.setUrl("jdbc:mysql://localhost:3306/yashdb");
            rowSet.setUsername("root");
            rowSet.setPassword("yash");
            rowSet.setCommand("select * from emp1");
            rowSet.execute();
            rowSet.moveToInsertRow();
            while(true){
                System.out.println("enter eno : ");
                int eno = Integer.parseInt(br.readLine());
                System.out.println("enter ename : ");
                String ename = br.readLine();
                System.out.println("enter esal : ");
                float esal = Float.parseFloat(br.readLine());
                System.out.println("enter eaddr : ");
                String eaddr = br.readLine();
                rowSet.updateInt(1,eno);
                rowSet.updateString(2,ename);
                rowSet.updateFloat(3,esal);
                rowSet.updateString(4,eaddr);
                rowSet.insertRow();
                System.out.println("do u want to add more : ");
                if (br.readLine().equals("no"))
                    break;

            }
            rowSet.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
