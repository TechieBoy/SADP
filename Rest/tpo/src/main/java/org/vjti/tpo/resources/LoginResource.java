package org.vjti.tpo.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.vjti.tpo.model.User;
import org.vjti.tpo.services.LoginService;

@Path("/login")
public class LoginResource {
	
	LoginService ls=new LoginService();
	

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes({"application/json"})
	public String verify(User u){
		
		System.out.println(u.getPassword()+" "+u.getUserId());
		if(ls.verify(u))
			return "Success";
		return "Failure";
	}
}
