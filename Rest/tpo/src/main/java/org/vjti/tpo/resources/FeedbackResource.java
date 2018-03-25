package org.vjti.tpo.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.vjti.tpo.model.Feedback;
import org.vjti.tpo.services.FeedbackService;

@Path("/feedback")
public class FeedbackResource {
	
	FeedbackService fs=new FeedbackService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Feedback> getFeedBack(@QueryParam("branch") String branch)
	{
		if(branch==null)
			return fs.getAllFeedback();
		return fs.getFeedbackByBranch(branch);
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String addFeedBack(Feedback f)
	{
		if(fs.addFeedback(f))
			return "Success";
		return "Failure";
	}
}
