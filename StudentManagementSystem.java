'''
package com.student;
import java.util.Scanner;

public class StudentManagementSystem {
	private static  Scanner s=new Scanner(System.in);
	private static StudentManagement sm=new StudentManagement();
	public static void main(String[] args)
	{
		while(true) {
			System.out.println("\n--------- Welcome to  Student Management System------------\n ");
			System.out.println("1.Add Student");
			System.out.println("2.View all Students");
			System.out.println("3.Search student by StudentId");
			System.out.println("4.Update student");
			System.out.println("5.Delete Student");
			System.out.println("6.Exit");
			System.out.println("Choose any option from the above: ");
			int choice=s.nextInt();
			switch(choice) {
			case 1:addStudent();
			break;
			case 2:viewAll();
			break;
			case 3:searchStudent();
			break;
			case 4:updateStudent();
			break;
			case 5:deleteStudent();
			break;
			case 6:System.out.println("Thank You");
			return;
			default:
				System.out.println("Invalid Choice");
				
				
			}
		}
	}
	private static void addStudent() {
		System.out.println("Enter the student Id: ");
		int id=s.nextInt();
		s.nextLine();
		System.out.println("Enter the student Name : ");
		String name=s.nextLine();
		System.out.println("Enter the student age: ");
		int age=s.nextInt();
		s.nextLine();
		System.out.println("Enter the Course enrolled: ");
		String course =s.nextLine();
		Student s=new Student(id,name,age,course);
		sm.addStudent(s);
		System.out.println("Student added successfully!");
		
	}
	private static void viewAll() {
		for(Student student:sm.getAllStudent()) {
			System.out.println(student);
		
		}
	}
	private static void searchStudent() {
		System.out.println("Enter StudentId to search : ");
		int id=s.nextInt();
		sm.getById(id);
		if(s != null) {
			System.out.println(s);
		}else {
			System.out.println("Student not found");
		}
	}
	private static void updateStudent() {
		System.out.println("Enter student Id to update: ");
		int id=s.nextInt();
		System.out.println("Enter the new Name: ");
		String name=s.nextLine();
		System.out.println("Enter the new Age : ");
		int  age=s.nextInt();
		s.nextLine();
		System.out.println("Enter the New Course to enroll: ");
		String course=s.nextLine();
		boolean updated=sm.updateStudent(id,name,age,course);
		if(updated) {
			System.out.println("Student successfully updated!");
			
		}else {
			System.out.println("Student not found");
		}
	}
	private static void deleteStudent() {
		System.out.println("Enter the student Id to delete: ");
		int id=s.nextInt();
		boolean deleted=sm.deleteStudent(id);
		if(deleted) {
			System.out.println("Successfully deleted");
		}else {
			System.out.println("Student not Found");
		}
	}
}
'''
