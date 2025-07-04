'''
package com.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnection {
	
	private static final  String url="jdbc:mysql://localhost:3306/student_db";
	private static final  String name="root";
	 private static final  String password="Dkukka@21";
	 private static Connection connection;
	 public static  Connection getConnection()throws SQLException {
		 try {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 connection=DriverManager.getConnection(url,name,password);
	 }
	 catch(ClassNotFoundException e) {
		 e.printStackTrace();
	 }
	 return connection;
	 } 
		 
	 }
	'''
