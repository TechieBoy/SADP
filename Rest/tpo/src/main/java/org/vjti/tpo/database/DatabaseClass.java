package org.vjti.tpo.database;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.vjti.tpo.model.Company;
import org.vjti.tpo.model.Feedback;
import org.vjti.tpo.model.Notice;
import org.vjti.tpo.model.Student;
import org.vjti.tpo.model.TPOStaff;
import org.vjti.tpo.model.User;
public class DatabaseClass {

		private static Map<String,User> user_login=new  HashMap<>();
		private static Map<String,Student> students = new HashMap<>();
		private static Map<String,TPOStaff> tpostaff = new HashMap<>();
		private static Map<String,Company> companies = new HashMap<>();
		private static Map<String,HashSet<Student>> applied=new HashMap<>();
		private static Map<String,HashSet<Student>> shortlist=new HashMap<>();
		private static Map<String,HashSet<Student>> placed=new HashMap<>();
		private static Map<Long,Notice> notices=new HashMap<>();
		private static ArrayList<Feedback> f=new ArrayList<Feedback>();
	
		static{
		
			//Students
			students.put("s1",new Student("s1","s1pass","name","mechanical",4,(float)8.19));
			students.put("s2",new Student("s2","s2pass","name","mechanical",4,(float)8.19));
			
			students.put("s3",new Student("s3","s3pass","name","it",4,(float)8.19));
			students.put("s4",new Student("s4","s4pass","name","it",4,(float)8.19));
			
			students.put("s5",new Student("s5","s5pass","name","comps",4,(float)8.19));
			students.put("s6",new Student("s6","s6pass","name","comps",4,(float)8.19));
			
			
			
			user_login.put("s1",new User("s1","s1pass","name"));
			user_login.put("s2",new User("s2","s2pass","name"));
			user_login.put("s3",new User("s3","s3pass","name"));
			user_login.put("s4",new User("s4","s4pass","name"));
			user_login.put("s5",new User("s5","s5pass","name"));
			user_login.put("s6",new User("s6","s6pass","name"));
			
			//TPO Staff
			tpostaff.put("t1",new TPOStaff("t1","t1pass","name","tpo_head"));
			
			user_login.put("t1",new User("t1","t1pass","name"));
			
			//Company
			
			companies.put("c1",new Company("c1","c1pass","name",1000,new Date(),new String[]{"it","comps"},4));
			companies.put("c2",new Company("c2","c2pass","name",1000,new Date(),new String[]{"it","comps","mechanical"},4));
			companies.put("c3",new Company("c3","c3pass","name",1000,new Date(),new String[]{"mechanical"},4));
			
			user_login.put("c1",new User("c1","c1pass","name"));
			user_login.put("c2",new User("c2","c2pass","name"));
			user_login.put("c3",new User("c3","c3pass","name"));
			
		
		}
		public static Map<String, User> getUsers() {
			
			return user_login;
		}
		
		public static Map<String,Student> getStudents() {
			
			return students;
		}
		
		public static Map<String,Company> getCompanies() {
			
			return companies;
		}
		public static Map<String,TPOStaff> getTPOStaff() {
			
			return tpostaff;
		}
		public static Map<String,HashSet<Student>> getApplied() {
			
			return applied;
		}
		public static Map<String,HashSet<Student>> getShortList() {
	
			return shortlist;
		}	
		public static Map<String,HashSet<Student>> getPlaced() {
	
			return placed;
		}
		public static Map<Long,Notice> getNotices() {
			
			return notices;
		}
		public static ArrayList<Feedback> getfeedback() {
			
			return f;
		}
		



		

}
