package com.yash.jdbc;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.yash.action.StudentAction;
import com.yash.beans.Student;

public class JdbcApp18 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StudentAction std = new StudentAction();
		
		while (true) {
			System.out.println("1.add student\n2.search student\n3.update student\n4.delete student\n5.exit");
			System.out.println("=============================");
			System.out.print("your choice : ");
			String choice = br.readLine();
			String sid = "S-";String sname = "";String saddr = "";String status = "";
			switch(choice) {
			case "1":
				
				break;
			case "2":
				Student student = std.searchStudent(sid);
				System.out.print("Enter student id to search : ");
				sid += br.readLine();
				
				
				if (status.equals("existed")) {
					System.out.println("sid : " + student.getSid());
					System.out.println("sname : " + student.getSname());
					System.out.println("saddr : " + student.getSaddr());
				}else {
					System.out.println("student not existed");
				}
				
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				System.out.println("Thank you for using the application");
				System.exit(0);
			}
			
		}

	}

}
