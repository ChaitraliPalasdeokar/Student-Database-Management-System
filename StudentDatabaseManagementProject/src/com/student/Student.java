package com.student;

import java.util.Date;

public class Student {
	public int regId;
	private String studentName;
	private String address;
    private long contactNumber;
    private int courseId;
    private int feesPaid;
    private Date dateOfAdmission;
    private Date startDate;
    private Date endDate;
	public int getRegId() {
		return regId;
	}
	Student()
	{
	
	}
	public Student(int regId, String studentName, String address, long contactNumber, int courseId, int feesPaid,
			Date dateOfAdmission, Date startDate, Date endDate) {
		super();
		this.regId = regId;
		this.studentName = studentName;
		this.address = address;
		this.contactNumber = contactNumber;
		this.courseId = courseId;
		this.feesPaid = feesPaid;
		this.dateOfAdmission = dateOfAdmission;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public void setRegId(int regId) {
		this.regId = regId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public int getFeesPaid() {
		return feesPaid;
	}
	public void setFeesPaid(int feesPaid) {
		this.feesPaid = feesPaid;
	}
	public Date getDateOfAdmission() {
		return dateOfAdmission;
	}
	public void setDateOfAdmission(Date dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    


}
