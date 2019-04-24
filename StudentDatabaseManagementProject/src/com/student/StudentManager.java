package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class StudentManager {

	
	public void EnrollStudent(String name,String address,long number,int courseid,int fees,Date date,Date startdate,Date enddate) {
		
			DBconnect db=new DBconnect();
			Connection con=db.dbconnect();
			CourseValidator cv=new CourseValidator();
		    Boolean flag=cv.validate(courseid);
		    
		    if(flag) {
			DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
			String doa=df.format(date);
			
			String sdate=df.format(startdate);
			String edate=df.format(enddate);
			
			
			
			
			
			int count=0;
			
			
			try {
			Statement st;
			st=con.createStatement();
		String queryforcoursevalidation="SELECT courseid from course where courseid="+courseid;
			ResultSet rs=st.executeQuery(queryforcoursevalidation);
			if(!rs.next()) {
				System.out.println("no courses present of the courseid mentioned !please enter proper details");
			}
			
			else 
			{
				String queryforcount="Select max(regid) from student";
				ResultSet rs1=st.executeQuery(queryforcount);
				if(!rs1.next()) {
				count=1;	
				}
				else {
				
				count=rs1.getInt(1);
				++count;
				}
				Statement st1=con.createStatement();
				String insertquery="INSERT INTO student VALUES (" +count+ ",'" +name+ "','" +address+ "'," +number+ ","+courseid+","+fees+ ",'"+doa+ "','"+sdate+ "','"+edate+"')";
				int rows=st1.executeUpdate(insertquery);
				if(rows>0) {
					System.out.println("STUDENT ENROLLMENT SUCCESS");
				}
			
			}
		
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		    }
		    else {
		    	System.out.println("COURSE ID INVALID");
		    }
		
		
	}
	
	
	public void viewStudentDetails(int rid) {
		Student obj=new Student();
	
		try {
			DBconnect db=new DBconnect();
			Connection con=db.dbconnect();
			Statement st=con.createStatement();
			String query="Select * from student where regid="+rid;
			ResultSet rs=st.executeQuery(query);
			
			if(!rs.next()) {
				System.out.println("no such regid exists ");
			}
			
			else {
				obj.setStudentName(rs.getString(2));
				obj.setAddress(rs.getString(3));
				obj.setContactNumber(rs.getLong(4));
				obj.setCourseId(rs.getInt(5));
				obj.setFeesPaid(rs.getInt(6));
				int rd=rs.getInt(1);
				
				 String doa=rs.getString(7);
				 String sdate=rs.getString(8);
				 String edate=rs.getString(9);
				 
				 
				 DateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				 Date doadmission=df1.parse(doa);
				 Date startdate=df1.parse(sdate);
				 Date enddate=df1.parse(edate);
				 
				 DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
				 obj.setStartDate(startdate);
				 obj.setEndDate(enddate);
				 obj.setDateOfAdmission(doadmission);
				 Date correctdate=obj.getDateOfAdmission();
				 String datetodisplay=df.format(correctdate);
				 Date correctsdate=obj.getStartDate();
				 String sdatetodisplay=df.format(correctsdate);
				 Date correctedate=obj.getEndDate();
				 String edatetodisplay=df.format(correctedate);
				 
				 System.out.println("Student registration id "+rd);
				System.out.println("Student name "+obj.getStudentName());
				System.out.println("Student addr "+obj.getAddress());
				System.out.println("Student contactnumber "+obj.getContactNumber());
				System.out.println("Student course id "+obj.getCourseId());
				
				System.out.println("Student dateofadmission "+datetodisplay);
				System.out.println("Date of starting "+sdatetodisplay);
				System.out.println("Date of ending "+edatetodisplay);
			
			
			
			
			}
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public ArrayList<Student> viewStudentbycourseid(int courseid){
		
		ArrayList<Student> list=new ArrayList<Student>();
		
		CourseValidator cv=new CourseValidator();
	    Boolean flag=cv.validate(courseid);
	   if(flag)
	   {
		
		StudentCourseService scs=new StudentCourseService();
		list=scs.fetchStudentDetails(courseid);
		   
		
	   }
	   
	   
	   else {
		   
		   System.out.println("INVALID COURSE ID");
		   
	   }
	   
	   return list;
	}
	
	
}
