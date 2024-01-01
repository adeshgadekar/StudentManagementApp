package com.student.manage;

public class Student {
	private int studentid;
	private String studentname;
	private String studentphone;
	private String studentcity;
	
	
	public Student(int studentid, String studentname, String studentphone, String studentcity) {
		super();
		this.studentid = studentid;
		this.studentname = studentname;
		this.studentphone = studentphone;
		this.studentcity = studentcity;
	}


	public Student(String studentname, String studentphone, String studentcity) {
		super();
		this.studentname = studentname;
		this.studentphone = studentphone;
		this.studentcity = studentcity;
	}


	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getStudentid() {
		return studentid;
	}
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}


	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	public String getStudentphone() {
		return studentphone;
	}
	public void setStudentphone(String studentphone) {
		this.studentphone = studentphone;
	}


	public String getStudentcity() {
		return studentcity;
	}
	public void setStudentcity(String studentcity) {
		this.studentcity = studentcity;
	}


	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", studentname=" + studentname + ", studentphone=" + studentphone
				+ ", studentcity=" + studentcity + "]";
	}
	
	
}
