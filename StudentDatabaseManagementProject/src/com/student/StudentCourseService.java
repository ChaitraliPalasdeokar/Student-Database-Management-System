package com.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentCourseService {

	
	public void launchCourse(String coursename,int duration,int fees) {
		try {
			
			
			DBconnect db=new DBconnect();
			Connection con=db.dbconnect();
			Statement st=con.createStatement();
			int count=0;
			
			String query="Select max(courseid) from course";
			ResultSet rs=st.executeQuery(query);
			if(!rs.next()) {
			count=1;	
			}
			else {
			
			count=rs.getInt(1);
			++count;
			}
			String sql="INSERT INTO course VALUES (" +count+ ",'" +coursename+ "'," +duration+ "," +fees+ ")";
			
			
			st.executeUpdate(sql);
			System.out.println("COURSE INSERTED SUCCESSFULLY!!");
			con.close();
			
			
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		
		}
		//System.out.println("end of application");

		
		
	}
	
	
	
	
public ArrayList<Course> fetchAllCourseDetails(){
	ArrayList<Course> list=new ArrayList<Course>();	
	try {
		
		DBconnect db=new DBconnect();
		Connection con=db.dbconnect();
		Statement st=con.createStatement();
		String sql="SELECT * from course";
		ResultSet rs=st.executeQuery(sql);
		
		CourseName[] cname = CourseName.values();
		while(rs.next()) {
			
			Course obj=new Course();
			obj.setCourseId(rs.getInt(1));
			String name = rs.getString(2);
			for(CourseName c : cname) {
				if(c.toString().equalsIgnoreCase(name)) {
					obj.setCourseName(c);
				}
			}
			//obj.setCourseName((CourseName)(rs.getObject(2)));
			obj.setDuration(rs.getInt(3));
			obj.setFees(rs.getInt(4));
			list.add(obj);		
		}		
	}
	catch(SQLException e) {
		e.printStackTrace();
		} 
		
	return list;
	
	
}


public Course fetchCourseDetails(int courseid) {
	
Course obj=new Course();
CourseValidator cv=new CourseValidator();
Boolean flag=cv.validate(courseid);
if(flag) {
	try {
		
		DBconnect db=new DBconnect();
		Connection con=db.dbconnect();
		Statement st=con.createStatement();
		String sql="SELECT * from course where courseid="+courseid+"";
		ResultSet rs=st.executeQuery(sql);
		
		
			CourseName[] cname = CourseName.values();
		while(rs.next()) {
		obj.setCourseId(rs.getInt(1));
		String name = rs.getString(2);
		for(CourseName c : cname) {
			if(c.toString().equalsIgnoreCase(name)) {
				obj.setCourseName(c);
			}
		}
		
		
		obj.setDuration(rs.getInt(3));
		obj.setFees(rs.getInt(4));
		
		}
		
	
		
		
	}
	catch(SQLException e) {
		e.printStackTrace();
		} 
}else {
	System.out.println("Enter valid course id");
}
	return obj;
	
	
}
	
	


public ArrayList<Student> fetchStudentDetails(int courseid){
	DBconnect db=new DBconnect();
	Connection conn=db.dbconnect();
	ArrayList<Student> list=new ArrayList<Student>();
	
	try {
		Statement smt=conn.createStatement();
		
		String sql2="SELECT * from student where courseid="+courseid;
		smt=conn.createStatement();
		ResultSet rs=smt.executeQuery(sql2);
		//System.out.println("QUERY EXECUTED !");
		while(rs.next())
		{
		 Student objstudent=new Student();
		 objstudent.setRegId(rs.getInt(1));
		 objstudent.setStudentName(rs.getString(2));
		 objstudent.setAddress(rs.getString(3));
		 objstudent.setContactNumber(rs.getLong(4));
		 objstudent.setCourseId(rs.getInt(5));
		 objstudent.setFeesPaid(rs.getInt(6));
		 String doa=rs.getString(7);
		 String sdate=rs.getString(8);
		 String edate=rs.getString(9);
		 
		 
		 DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
		 Date doadmission=df1.parse(doa);
		 Date startdate=df1.parse(sdate);
		 Date enddate=df1.parse(edate);
		 
		 
		 
		 objstudent.setDateOfAdmission(doadmission);
		 objstudent.setStartDate(startdate);
		 objstudent.setEndDate(enddate);
		 
		 list.add(objstudent);
		// System.out.println("added successfully");
		 
		 
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
   
	return list;
 }
   	
	










}
