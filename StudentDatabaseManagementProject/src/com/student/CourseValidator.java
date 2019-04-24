package com.student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CourseValidator {

	
	DBconnect db=new DBconnect();
    Connection con=null;
    
    Statement smt=null;
    Boolean status=false;
    public boolean validate(int courseId)
   {
    try {
    	 con=db.dbconnect();
         String query="SELECT * from course where courseid="+courseId;
         smt=con.createStatement();
         ResultSet rs=smt.executeQuery(query);
         if(rs.next())
         {
        	 status=true;
         }
         else
        	 System.out.println("Enter Valid Course Id");
    }
    
    catch(SQLException e)
    {
    	String s="Please enter valid course Id";
    	System.out.println(s);
    }
    return status;
 }	

}
