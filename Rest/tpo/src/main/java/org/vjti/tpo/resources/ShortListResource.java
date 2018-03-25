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
import org.vjti.tpo.services.ShortListService;

@Path("/shortlist")
public class ShortListResource {
	
	ShortListService ss=new ShortListService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{company_username}")
	
		public HashSet<Student> getShortListed(@PathParam("company_username") String username){
			return ss.getShortListed(username);
		}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{company_username}")
	public String addShortList(@PathParam("company_username") String username,HashSet<Student> s)
	{
		if(ss.addShortListed(username,s))
			return "Success";
		return "Failure";
	}
	
	@DELETE
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePlaced(@PathParam("username") String username,Student s)
	{
		if(ss.deleteShortlisted(username,s))
			return "Success";
		return "Failure";
	}
}
