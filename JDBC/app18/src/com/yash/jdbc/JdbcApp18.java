package com.yash.jdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.yash.action.StudentAction;
import com.yash.beans.Student;

public class JdbcApp18 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StudentAction stdAction = new StudentAction();
		Student std;

		while (true) {
			System.out.println("=============================");
			System.out.println("1.add student\n2.search student\n3.update student\n4.delete student\n5.exit");
			System.out.println("=============================");
			System.out.print("your choice : ");
			String choice = br.readLine();
			String sid = "S-";
			String sname = "";
			String saddr = "";
			String status = "";
			switch (choice) {
			case "1":
				System.out.println("-----------------------------");
				System.out.print(" enter sid : ");
				sid += br.readLine();
				std = stdAction.searchStudent(sid);
				if (std == null) {
					System.out.print("enter sname : ");
					sname = br.readLine();
					System.out.print("enter saddr : ");
					saddr = br.readLine();
					status = stdAction.addStudent(sid, sname, saddr);
					if (status.equals("existed"))
						System.out.println("student added successfully.");
					else
						System.out.println("student addition failure.");

				} else {
					System.out.println("student already existed");
				}
				System.out.println("-----------------------------");
				break;
			case "2":
				System.out.println("-----------------------------");
				System.out.print("Enter student id to search : ");
				sid += br.readLine();
				std = stdAction.searchStudent(sid);
				;
				if (std != null) {

					System.out.println("sid : " + std.getSid());
					System.out.println("sname : " + std.getSname());
					System.out.println("saddr : " + std.getSaddr());

				} else {
					System.out.println("student not existed");
				}
				System.out.println("-----------------------------");
				break;
			case "3":
				System.out.println("-----------------------------");
				System.out.print("Enter student id to update : ");
				sid += br.readLine();
				std = stdAction.searchStudent(sid);
				if (std != null) {
					System.out.print("sname : OLD: "+std.getSname()+" | NEW: ");
					sname = br.readLine();
					if (sname.equals(""))
						sname = std.getSname();
					System.out.print("saddr : OLD: "+std.getSaddr()+" | NEW: ");
					saddr = br.readLine();
					if (saddr.equals(""))
						saddr = std.getSaddr();
					
					status = stdAction.updateStudent(sid, sname, saddr);
					if (status.equals("updated"))
						System.out.println("student details updated successfully.");
					else
						System.out.println("updation failure");
					
				} else {
					System.out.println("student not existed");
				}
				System.out.println("-----------------------------");
				break;
			case "4":
				System.out.println("-----------------------------");
				System.out.print("Enter student id to delete : ");
				sid += br.readLine();
				std = stdAction.searchStudent(sid);
				if (std != null) {
					status = stdAction.deleteStudent(sid);
					if(status.equals("deleted")) {
						System.out.println("Student deleted successfully.");
			
					}
					else
						System.out.println("deletion failure.");
				}else 
					System.out.println("student not existed");
				
				
				System.out.println("-----------------------------");
				break;
			case "5":
				System.out.println("Thank you for using the application");
				System.exit(0);
			}

		}

	}

}
