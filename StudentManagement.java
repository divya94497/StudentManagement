'''


package com.student;
import java.util.ArrayList;

public class StudentManagement {
	
	private ArrayList<Student> ar=new ArrayList<>();
	public void addStudent(Student s) {
		ar.add(s);
	
	}
	public ArrayList<Student> getAllStudent(){
		return ar;
	}
	public Student getById(int id)
	{
		for(Student s:ar) {
		if(s.getId()==id) {
		
			return s;
			}
		}return null;
	}
	public boolean updateStudent(int id,String name,int age,String course) {
		Student s=getById(id);
		if(s != null) {
			s.setName(name);
			s.setAge(age);
			s.setCourse(course);
			return true;
			}return false;
		
	}
	public boolean deleteStudent(int id) {
		Student s=getById(id);
		if(s!=null) {
			ar.remove(s);
			return true;
		}return false;
	}

}
'''
