package org.vjti.tpo.services;

import java.util.ArrayList;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Feedback;

public class FeedbackService {
	
	private static ArrayList<Feedback> f=DatabaseClass.getfeedback();
	
	public ArrayList<Feedback> getAllFeedback(){
		
		return f;
	}
	public ArrayList<Feedback> getFeedbackByBranch(String branch){
		
		ArrayList<Feedback> fs= new ArrayList<Feedback>();
		for(Feedback feedback: f)
		{
			
			if(feedback.getBranch().equalsIgnoreCase(branch))
				fs.add(feedback);
				
		}
		return fs;
		
	}
	
	public boolean addFeedback(Feedback fb)
	{
		f.add(fb);
		return true;
	}
}
