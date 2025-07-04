'''
package com.student;
import com.pack.Dbconnection;
import java.sql.*;
import java.util.ArrayList;
public class StudentManagement{
	private Connection connection;
	
	public StudentManagement() {
		try {
			connection=Dbconnection.getConnection();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	public void addStudent(Student s) {
		String insert="Insert into student(id,name,age,course) values(?,?,?,?)";
		try(PreparedStatement pst=connection.prepareStatement(insert)){
			pst.setInt(1, s.getId());
			pst.setString(2, s.getName());
			pst.setInt(3, s.getAge());
			pst.setString(4,s.getCourse());
			pst.executeUpdate();
			System.out.println("Student added successfully!");
			
			
		}catch(SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	public ArrayList<Student> getAllStudent(){
		ArrayList<Student> ar=new ArrayList<>();
		String select="Select * from student";
		try(Statement st=connection.createStatement()){
			ResultSet rs=st.executeQuery(select);
			while(rs.next()) {
				Student s=new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("course"));
				ar.add(s);
			}
		}
			
			catch(SQLException e) {
				e.printStackTrace();
				
			}return ar;		
	}
	public Student getById(int id) {
		String select="Select * from student where id=?";
		try(PreparedStatement ps=connection.prepareStatement(select)){
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return new Student(rs.getInt("id"),rs.getString("name"),rs.getInt("age"),rs.getString("course"));
				}
		}
			
			catch(SQLException e) {
				e.printStackTrace();	
		}return null;
	}
	public boolean updateStudent(int id,String name,int age,String course) {
		String update="update student set name=?,age=?,course=? where id=?";
		try{
			
			PreparedStatement st=connection.prepareStatement(update);
			st.setString(1,name);
			st.setInt(2,age);
			st.setString(3,course);
			st.setInt(4,id);
			int i = st.executeUpdate();
			return i>0;
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}return false;
		
	}
	public boolean deleteStudent(int id) {
		String delete="Delete * from student where id=?";
		try(PreparedStatement ps=connection.prepareStatement(delete)){
			ps.setInt(1,id);
			int i =ps.executeUpdate();
			return i>0;
		}catch(SQLException e) {
			e.printStackTrace();
		}return false;
	}	
	
}
'''
