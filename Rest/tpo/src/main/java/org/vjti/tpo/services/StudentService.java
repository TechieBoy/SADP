package org.vjti.tpo.services;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.Path;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Student;
import org.vjti.tpo.model.User;

@Path("/students")
public class StudentService {

	private static Map<String,Student> students=DatabaseClass.getStudents();
	private static Map<String,User> user_login=DatabaseClass.getUsers();
	
	public Student getStudent(String username){
		return students.get(username);
	}
	public ArrayList<Student> getStudents(){
		
		return new ArrayList<Student>(students.values());
		
	}
	
	public ArrayList<Student> getStudentsByBranch(String branch){
		
		
		ArrayList<Student> as= new ArrayList<Student>();
		for(Student s: students.values())
		{
			
			if(s.getBranch().equalsIgnoreCase(branch))
			{
				as.add(s);
			}
				
		}
		return as;
		
		
		
	}
	public boolean addStudent(Student s)
	{
		if(students.containsKey(s.getUserId()))
			return false;
		students.put(s.getUserId(),s);
		user_login.put(s.getUserId(),new User(s.getUserId(),s.getPassword(),s.getName()));
		return true;
	}
	
	public boolean updateStudent(Student s)
	{
		if(students.containsKey(s.getUserId()))
		{
			students.put(s.getUserId(),s);
			user_login.put(s.getUserId(),new User(s.getUserId(),s.getPassword(),s.getName()));
			return true;
		}
		
		return false;
	}
	
	public boolean removeStudent(String username)
	{
		if(students.containsKey(username))
		{
			students.remove(username);
			user_login.remove(username);
			return true;
		}
		
		return false;
	}
}
