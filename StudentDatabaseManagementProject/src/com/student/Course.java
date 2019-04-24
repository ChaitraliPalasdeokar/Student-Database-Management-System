package com.student;

public class Course {

	private int courseId;
	private CourseName courseName;
	private int duration;
	private int fees;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public CourseName getCourseName() {
		return courseName;
	}
	public void setCourseName(CourseName courseName) {
		this.courseName = courseName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
	}

	
}
