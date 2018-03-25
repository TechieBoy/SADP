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
import org.vjti.tpo.model.Company;
import org.vjti.tpo.services.CompanyService;

@Path("/companies")
public class CompanyResource {
	
	CompanyService cs=new CompanyService();
	
	@GET
	@Path("/{company_username}")
	@Produces(MediaType.APPLICATION_JSON)
	public Company getCompany(@PathParam("company_username") String username){
		
		return cs.getCompany(username);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Company> getCompanies(@QueryParam("branch") String branch){
		if(branch==null)
			return cs.getCompanies();
		return cs.getCompaniesByBranch(branch);
	}
	
	@POST	
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addCompany(Company c){
		
		if( cs.addCompany(c))
			return "Success";
		return "Failure";
		
	}
	
	@PUT	
	@Path("/{username}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCompany(@PathParam("username") String username,Company c){
		
		c.setUserId(username);
		if(cs.updateCompany(c))
			return "Success";
		return "Failure";
		
	}
	
	@DELETE
	@Path("/{username}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCompany(@PathParam("username") String username)
	{
		if(cs.removeCompany(username))
			return "Success";
		return "Failure";
	}
	
}
