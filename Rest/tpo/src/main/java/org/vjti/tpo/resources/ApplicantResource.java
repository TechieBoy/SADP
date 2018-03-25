package org.vjti.tpo.resources;

import java.util.HashSet;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vjti.tpo.model.Student;
import org.vjti.tpo.services.ApplicantService;

@Path("/applicants")
public class ApplicantResource {
	
	ApplicantService as=new ApplicantService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{company_username}")
	
		public HashSet<Student> getApplied(@PathParam("company_username") String username){
			return as.getApplied(username);
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{company_username}")
	public String apply(@PathParam("company_username") String username,Student s)
	{
		if(as.addApplied(username,s))
			return "Success";
		return "Failure";
	}
	
	@DELETE
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteApplied(@PathParam("username") String username,Student s)
	{
		if(as.deleteApplied(username,s))
			return "Success";
		return "Failure";
	}
	
}
