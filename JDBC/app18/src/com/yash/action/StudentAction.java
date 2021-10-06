package com.yash.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yash.beans.Student;

public class StudentAction {
Connection con;
Statement st;
ResultSet rs;
Student std ;
String status = "";

	public StudentAction()throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
		st = con.createStatement();
		
	}
	
	public String addStudent(String sid,String sname , String saddr) throws Exception {
		int rowCount = st.executeUpdate("insert into student values('"+sid+"','"+sname+"','"+saddr+"')");
		if(rowCount == 1)
			status = "existed";
		else
			status = "not existed";
		return status;
	}
	
	public Student searchStudent(String sid) throws Exception {
		rs = st.executeQuery("select * from student where sid = '"+ sid + "'");
		boolean b = rs.next();
		if(b == true) {
			std = new Student();
			
				std.setSid(rs.getString(1));
				std.setSname(rs.getString(2));
				std.setSaddr(rs.getString(3));
		}
		else {
			std = null;
		}
		return std;
		}
	
	public String updateStudent(String sid,String sname,String saddr) throws Exception {
		int rowCount = st.executeUpdate("update student set sname = '"+sname+"',saddr = '"+saddr+"' where sid = '"+sid+"'");
		if(rowCount == 1)
			status = "updated";
		else
			status = "not updated";
		
		
		return status;
	}
	
	public String deleteStudent(String sid) throws Exception {
		int rowCount = st.executeUpdate("delete student where sid = '" +sid+"'");
		if(rowCount == 1)
			status = "deleted";
		else
			status = "not deleted";
		return status;
	}
	
}
