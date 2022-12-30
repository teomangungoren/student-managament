package com.web.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;




public class StudentDbUtil {

	private DataSource dataSource;
	
	public StudentDbUtil(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	
	public List<Student> getStudents() throws Exception{
		
		List<Student> students=new ArrayList<>();
		
		Connection myConn=null;
		Statement myStmt=null;
		ResultSet myRs=null;
		
		try {
			//bağlantı adresi
			myConn=dataSource.getConnection();
			
			//sql statement
			String sql="select * from student order by last_name";
			myStmt=myConn.createStatement();
			
			//sorgu çalıştırma
			myRs=myStmt.executeQuery(sql);
			
			while(myRs.next()) {
				
				//bilgi alma
				
				int id=myRs.getInt("id");
				String firstName=myRs.getString("first_name");
				String lastName=myRs.getString("last_name");
				String email=myRs.getString("email");
				int no=myRs.getInt("no");
				
				//ogrenci nesnesi olusturma
				
				Student student=new Student(id,firstName,lastName,no,email);
				
				//ogrenci listesine ekleme
				
				students.add(student);
			}
			return students;
		}
	      finally {
	    	  //
	    	  close(myConn,myRs,myStmt);
	      }
		
		
		
		
		
	}

	private void close(Connection myConn, ResultSet myRs, Statement myStmt) {
		try {
			if(myRs!=null) {
				myRs.close();
			}
			if(myStmt!=null) {
				myStmt.close();
			}
			if(myConn!=null) {
				myConn.close();
			}
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
		
	}
	public void addStudent(Student student) throws Exception {
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			myConn=dataSource.getConnection();
			
			String sql="insert into student"+"(first_name,last_name,no,email)"+"values(?,?,?,?)";
			
			myStmt=myConn.prepareStatement(sql);
			myStmt.setString(1, student.getFirstName());
			myStmt.setString(2, student.getLastName());
			myStmt.setInt(3, student.getNo());
			myStmt.setString(4, student.getEmail());
			
			myStmt.execute();
		}
		finally {
			close(myConn, null, myStmt);
		}
	}

	public Student getStudent(String theStudentId) throws Exception {
		
		Student theStudent=null;
		
		Connection myConn=null;
		PreparedStatement myStmt=null;
		ResultSet myRs=null;
		
		int studentId;
		
		try {
		    studentId=Integer.parseInt(theStudentId);
			
		    myConn=dataSource.getConnection();
		    
		    String sql="select * from student where id=?";
		    
		    myStmt=myConn.prepareStatement(sql);
		    
		    myStmt.setInt(1, studentId);
		    
		    myRs=myStmt.executeQuery();
		    
		    if(myRs.next()) {
		    	String firstName=myRs.getString("first_name");
		    	String lastName=myRs.getString("last_name");
		    	int no=myRs.getInt("no");
		    	String email=myRs.getString("email");
		    	
		    	theStudent=new Student(studentId,firstName,lastName,no,email);
		    }
		    else {
		    	throw new Exception(studentId+"numaralı id'ye sahip öğrenciyi bulamadık");
		    }
			
			return theStudent;
		}
		finally {
			close(myConn, myRs, myStmt);
		}
		
		
	}

	public void updateStudent(Student theStudent) throws Exception {
		Connection myConn=null;
		PreparedStatement myStmt=null;
		try {
		myConn=dataSource.getConnection();
		
		String sql= "UPDATE student SET first_name=?, last_name=?, no=?, email=? WHERE id=?";

		              
		
		myStmt=myConn.prepareStatement(sql);
		
	     myStmt.setString(1, theStudent.getFirstName());
	     myStmt.setString(2, theStudent.getLastName());
	     myStmt.setInt(3, theStudent.getNo());
	     myStmt.setString(4, theStudent.getEmail());
	     myStmt.setInt(5, theStudent.getId());
		
		
		myStmt.execute();
		}
		finally{
			close(myConn,null, myStmt);
	
	}
}

	public void deleteStudent(String theStudentId) throws Exception{
		Connection myConn=null;
		PreparedStatement myStmt=null;
		
		try {
			int studentId=Integer.parseInt(theStudentId);
			myConn=dataSource.getConnection();
			String sql="delete from student where id=?";
			myStmt=myConn.prepareStatement(sql);
			myStmt.setInt(1, studentId);
	        myStmt.execute();  		
		}finally {
			close(myConn, null, myStmt);
		}
		
	}

	

	
}