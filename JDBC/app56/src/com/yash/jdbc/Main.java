package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class Main {

    public static void main(String[] args) {
        Connection conOracle = null;
        Connection conMySQL = null;
        PreparedStatement pstOracle = null;
        PreparedStatement pstMySQL = null;
        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            conOracle = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","yash");
            conMySQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/yashdb","root","yash");

            conOracle.setAutoCommit(false);
            conMySQL.setAutoCommit(false);

            pstOracle = conOracle.prepareStatement("update account set balance = balance - ? where acno = ?");
            pstMySQL = conMySQL.prepareStatement("update account set balance = balance + ? where acno = ?");

            System.out.print("Enter Source Account : ");
            String sourceAcc = br.readLine();

            System.out.print("Enter Target Account : ");
            String targetAcc = br.readLine();

            System.out.print("Enter Transfer Amount : ");
            int transferAmt = Integer.parseInt(br.readLine());

            pstOracle.setInt(1,transferAmt);
            pstMySQL.setInt(1,transferAmt);

            pstOracle.setString(2,sourceAcc);
            pstMySQL.setString(2,targetAcc);

            int oracleCount = pstOracle.executeUpdate();
            int mysqlCount = pstMySQL.executeUpdate();
            System.out.println("--------------------------------");
            if(oracleCount == 1 && mysqlCount == 1) {
                System.out.println("Amount transferred Successfully.");
                conOracle.commit();
                conMySQL.commit();
            }
            else{
                System.out.println("Amount transfer Failed.");
                conOracle.rollback();
                conMySQL.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
                pstMySQL.close();
                pstOracle.close();
                conMySQL.close();
                conOracle.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
