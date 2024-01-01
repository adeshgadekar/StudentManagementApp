import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to StudentManagemntApp");
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("Press 1 to Add Student");
			System.out.println("Press 2 to Delete Student");
			System.out.println("Press 3 to Display Student");
			System.out.println("Press 4 to Update Student");
			System.out.println("Press 5 to Exit App");
			
			int c= Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add student
				System.out.println("Enter Student name :");
				String name = br.readLine();
				
				System.out.println("Enter Student phone :");
				String phone = br.readLine();
				
				System.out.println("Enter Student city :");
				String city = br.readLine();
				
				//create student object to store student
				Student st = new Student(name,phone,city);
				boolean answer=StudentDao.insertStudentToDB(st);
				if(answer) {
					System.out.println("Student is Added Successfully....");
				}
				else {
					System.out.println("Something Went wrong try again...");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//delete student
				System.out.println("Enter Student Id : ");
				int userId = Integer.parseInt(br.readLine());
				boolean f=StudentDao.deleteStudent(userId);
				if(f) {
					System.out.println("Student Deleted Successfully...");
				}
				else {
					System.out.println("Something went wrong...");
				}
			}
			else if(c==3) {
				//display student
				StudentDao.showAllStudent();	
			}
			else if(c==4) {
				//update student
//				System.out.println("Enter Student Id : ");
//				
//				Student st = new Student(name,phone,city);
//				StudentDao.updateStudent(st);
				
				System.out.print("Enter the student ID to update: ");
                int updateId = Integer.parseInt(br.readLine());
                
                Student existingStudent = StudentDao.getStudentById(updateId);
                
                if (existingStudent != null) {
                    System.out.print("Enter the new student name: ");
                    String newName = br.readLine();
                    System.out.print("Enter the new phone: ");
                    String newPhone = br.readLine();
                    System.out.println("Enter the new city");
                    String newCity = br.readLine();

                    existingStudent.setStudentname(newName);
                    existingStudent.setStudentphone(newPhone);
                    existingStudent.setStudentcity(newCity);

                    boolean success = StudentDao.updateStudent(existingStudent);

                    if (success) {
                        System.out.println("Student record updated successfully.");
                    } else {
                        System.out.println("Failed to update student record.");
                    }
                } else {
                    System.out.println("Student with ID " + updateId + " not found.");
                }
			}
			else if(c==5) {
				//exit app
				break;
			}
			else {
				;
			} 
		}
		System.out.println("Thank You for Using My Application.....");
		System.out.println("See You Soon.....Bye Bye");
	}

}
