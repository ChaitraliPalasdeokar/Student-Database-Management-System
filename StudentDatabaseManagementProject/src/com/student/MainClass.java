package com.student;

//This project is created under package com.student and the constraints are mentioned in README



import java.util.Date;
//import java.util.Iterator;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int courseid,duration,fees;
		String coursename;
		int count=0;
		StudentManager smanager=new StudentManager();
		Scanner sc=new Scanner(System.in);
		int option;
		do {
			System.out.println("\t\t*************MENU******************");
			System.out.println("\t\tPLEASE SELECT ONE OF THE FOLLOWING:"
					+ "\n\t\t1. Launch Course \n\t\t2.Fetch all Courses\n"
					+ "\t\t3.Get course details by courseid\n"
					+ "\t\t4.enroll student\n\t\t5.View Student details by courseid\n\t\t6.View student details by regid"+"\n\t\t7.exit");
			option=sc.nextInt();
			
			
			switch(option) 
			
			{			
				case 1:  
					StudentCourseService obj=new StudentCourseService();
					Boolean status=false;
					 count = 1;
					 do {
					System.out.println("Enter course name");
					//courseid=sc.nextInt();
					coursename=sc.next();
					CourseName[] course=CourseName.values();
					
					for(CourseName c : course)
			        {
			        	String s=c.toString();
			        	if(s.equalsIgnoreCase(coursename)) 
			        	{  
			        		status=true;
			        		break;
			        	}
			        	
			        }
					if(status==false) {
						count++;
						 System.out.println("INVALID COURSE PLEASE INSERT ONE OF THE FOLLOWING:\nC++,JAVA,J2EE,SPRING,HIBERNATE");
					}
					 }while(!status && count==2);
					 if(count>2) {
						 break;
					 }
				  
				 
					System.out.println("duration and fees");
					duration=sc.nextInt();
					fees=sc.nextInt();
					obj.launchCourse(coursename, duration, fees);
					  break;
					  
					  
				case 2:
					StudentCourseService obj1=new StudentCourseService();
					
					ArrayList<Course>list=obj1.fetchAllCourseDetails();
					
					for(Course c:list) {
						System.out.println("Courseid : "+c.getCourseId());
						System.out.println("Course name : "+c.getCourseName());
						System.out.println("Course fees : "+c.getFees());
						System.out.println("Course duration : "+c.getDuration());
						System.out.println("------------------------------------------------------------");
					}
				
					
					break;
					
					
				case 3:
					StudentCourseService obj3=new StudentCourseService();
				
					System.out.println("Enter courseid ");
					Scanner s=new Scanner(System.in);
					
					int fetchcourseid=s.nextInt();
					Course ob=obj3.fetchCourseDetails(fetchcourseid);
					/*if(ob.getCourseName().equals(null)) {
						System.out.println("no such course id exists.Try Again");
						count++;
					}
					*/
					//else {
					System.out.println("*************************COURSE DETAILS*******************");
					System.out.println(" ID :"+ob.getCourseId());
					System.out.println(" NAME :"+ob.getCourseName());
					
					System.out.println(" DURATION :"+ob.getDuration());
					
					System.out.println(" FEES :"+ob.getFees());
					System.out.println("-------------------------------------------------------------");
					//}
					break;
				case 4:System.out.println("Enter Student name");
					Date dateofadmission=null,enddate=null;
					Date startdate=null;
					//int rid=sc.nextInt();
				  String name=sc.next();
				  System.out.println("Enter address");
				  String addr=sc.next(); 
				  System.out.println("Enter contactnumber");
				  Long number=sc.nextLong(); 
				  System.out.println("Enter courseid ");
				  int studentcourseid=sc.nextInt();
				  System.out.println("Enter fees ");
				  int feespaid=sc.nextInt();
				 
				 DateFormat datetoformat=new SimpleDateFormat("dd-MM-yyyy");
				 //whenever you create new object of type date , it gets initialized with todays date
				 Date date=new Date();
				 //dateofa=dateofadmission 
				//convert todays date to proper format of dd-MM-yyyy
				 String dateofa=datetoformat.format(date);
				 System.out.println("Admission date is "+dateofa);
				 System.out.println("Enter startdate (dd-mm-yyyy)");
				 String sdate=sc.next();
				 SimpleDateFormat df1 = new SimpleDateFormat("dd-MM-yyyy");
				try {
					startdate=df1.parse(sdate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Enter enddate (dd-mm-yyyy)");
				String edate=sc.next();
				 SimpleDateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
				try {
					enddate=df2.parse(edate);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 if(startdate.after(enddate)||enddate.before(startdate)||startdate.before(date)) {	
					 System.out.println("Enter proper dates");
				 }
				 else {
					 StudentManager student=new StudentManager();
					 student.EnrollStudent(name, addr, number, studentcourseid, feespaid, date, startdate, enddate);
				 }
				
					break;
				
					
					
				case 5:System.out.println("Enter courseId");
						int studentcourse=sc.nextInt();
						Student student=new Student();
						StudentManager object=new StudentManager();
						ArrayList<Student >list1=object.viewStudentbycourseid(studentcourse);
						DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
						for(Student c:list1) {
							System.out.println("Courseid: "+c.getCourseId());
							System.out.println("Course name: "+c.getStudentName());
							System.out.println("Course fees paid "+c.getFeesPaid());
							
							 Date correctdate=c.getDateOfAdmission();
							 String datetodisplay=df.format(correctdate);
							 
							 Date sdate1=c.getStartDate();
							 String starttodisplay=df.format(sdate1);
							 
							 Date edate1=c.getEndDate();
							 String endtodisplay=df.format(sdate1);
							
						System.out.println("Date of admission: "+datetodisplay);
						System.out.println("Starting date :"+starttodisplay);
						System.out.println("Ending date :"+starttodisplay);
							System.out.println("------------------------------------------------------------");
						}
						
						
						
					
					break;
				case 6:
					System.out.println("Enter regid");
					int rid=sc.nextInt();
					
					smanager.viewStudentDetails(rid);
					break;
					
				case 7:System.exit(0);
					  

			}
 
			
			
			
			
		}while(option!=7);
		
	
				

	}
	
	
	

}
