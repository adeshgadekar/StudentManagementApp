package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class StudentDao {
	 private static List<Student> students = new ArrayList<>();
	public static boolean insertStudentToDB(Student st) {
		
		//jdbc code...
		boolean f= false;
		try {
			Connection con=CP.createC();
			
			String q = " insert into students(sname,sphone,scity) values(?,?,?)";
			PreparedStatement ps= con.prepareStatement(q);
			ps.setString(1, st.getStudentname());
			ps.setString(2, st.getStudentphone());
			ps.setString(3, st.getStudentcity());
			
			
			ps.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f= false;
		try {
			Connection con=CP.createC();
			
			String q = "delete from students where sid = ?";
			PreparedStatement ps= con.prepareStatement(q);
			ps.setInt(1, userId);
			
			
			ps.executeUpdate();
			f=true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
		
	}

	public static void showAllStudent() {
		// TODO Auto-generated method stub

		try {
			Connection con=CP.createC();
			
			String q = "select * from students";
			Statement sm=con.createStatement();
			
			ResultSet rs= sm.executeQuery(q);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String phone=rs.getString(3);
				String city=rs.getString("scity");
				
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("++++++++++++++++++++++++++++++++");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	public static boolean updateStudent(Student st) {
	    boolean f = false;

	    try {
	        Connection con = CP.createC();

	        String q = "UPDATE students SET sname=?, sphone=?, scity=? WHERE sid=?";
	        PreparedStatement ps = con.prepareStatement(q);

	        ps.setString(1, st.getStudentname());
	        ps.setString(2, st.getStudentphone());
	        ps.setString(3, st.getStudentcity());
	        ps.setInt(4, st.getStudentid());

	        ps.executeUpdate();
	        f = true;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return f;
	}

	public static Student getStudentById(int sid) {
	    try {
	        Connection con = CP.createC();

	        String q = "SELECT * FROM students WHERE sid=?";
	        PreparedStatement ps = con.prepareStatement(q);
	        ps.setInt(1, sid);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            int id = rs.getInt("sid");
	            String name = rs.getString("sname");
	            String phone = rs.getString("sphone");
	            String city = rs.getString("scity");

	            return new Student(id, name, phone, city);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return null;
	}
}
