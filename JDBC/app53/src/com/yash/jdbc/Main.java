/*
create or replace procedure getEMPS(emps OUT SYS_REFCURSOR)
as
BEGIN
    open emps for select * from emp1;
END getEMPS;
/
 */
package com.yash.jdbc;


import oracle.jdbc.OracleTypes;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Main {

    public static void main(String[] args) {
	try (
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
            CallableStatement cst = con.prepareCall("{call getEMPS(?)}")
            ){
        cst.registerOutParameter(1, OracleTypes.CURSOR);
        cst.execute();
        ResultSet rs = (ResultSet) cst.getObject(1);
        while(rs.next()){
            System.out.println(rs.getInt(1) +"\t"+ rs.getString(2)+"\t"+ rs.getFloat(3)+"\t"+ rs.getString(4));
        }
    }catch (Exception e){
        e.printStackTrace();
    }
    }
}
