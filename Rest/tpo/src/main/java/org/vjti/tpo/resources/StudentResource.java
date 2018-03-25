package org.vjti.tpo.resources;

import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.vjti.tpo.model.Student;
import org.vjti.tpo.services.StudentService;

@Path("/students")
public class StudentResource {
	
	StudentService s=new StudentService();

	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Student> getStudents(@QueryParam("branch") String branch){
		
		
		if(branch==null){
			return s.getStudents();}
		return s.getStudentsByBranch(branch);
		
	}
	
	@GET	
	@Path("/{username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student getStudent(@PathParam("username") String username){
		
		return s.getStudent(username);
		
	}
	
	@POST	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addStudent(Student sp){
		
		if( s.addStudent(sp))
			return "Success";
		return "Failure";
		
	}
	
	@PUT	
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateStudent(@PathParam("username") String username,Student sp){
		
		sp.setUserId(username);
		if(s.updateStudent(sp))
			return "Success";
		return "Failure";
		
	}
	
	@DELETE
	@Path("/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteStudent(@PathParam("username") String username)
	{
		if(s.removeStudent(username))
			return "Success";
		return "Failure";
	}
	
	
	
}
