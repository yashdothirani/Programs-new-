package com.yash.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.yash.beans.Student;

public class StudentAction {
Connection con = null;
Statement st = null;
Student student ;
String status = "";

	public StudentAction()throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" , "system" , "yash");
		st = con.createStatement();
		
	}
	
	public String addStudent(String sid,String sname , String saddr) {
		return status;
	}
	
	public Student searchStudent(String sid) throws Exception {
		ResultSet rs = st.executeQuery("select * from student");
		while(rs.next()) {
			if(rs.getString(1).equals(sid)) {
				student.setSid(rs.getString(1));
				student.setSname(rs.getString(2));
				student.setSaddr(rs.getString(3));
				return student;
			}
		}
		return null;
	}
	
	public String updateStudent(String sid,String sname,String saddr) {
		return status;
	}
	
	public String deleteStudent(String sid) {
		return status;
	}
	
}
