/* create or replace function getAVGSal(sal1 IN float,sal2 IN float) return FLOAT
as
avgSal float;
BEGIN
    select avg(ESAL) into avgSal from emp1 where sal1 < ESAL and ESAL < sal2;
    return avgSal;
END getAVGSal;
/
 */

package com.yash.jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(
                Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
                CallableStatement cst = con.prepareCall("{? = call getAVGSal(?,?)}")
                )
        {
            cst.setFloat(2,1000);
            cst.setFloat(3,10000);
            cst.registerOutParameter(1, Types.FLOAT);
            cst.execute();
            System.out.println("AVG Sal = " + cst.getFloat(1));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
