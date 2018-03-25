package org.vjti.tpo.services;

import java.util.HashSet;
import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Student;

public class ShortListService {
	 
	private static Map<String,HashSet<Student>> shortlist=DatabaseClass.getShortList();
	
	public HashSet<Student> getShortListed(String username)
	{
		return shortlist.get(username);
	}
	
	public boolean addShortListed(String company_username,HashSet<Student> s){
		
		
		
		if(shortlist.containsKey(company_username))
		{
			
			HashSet<Student> ls=shortlist.get(company_username);
			ls.addAll(s);
			shortlist.put(company_username,ls);
			return true;
		}
		
		else if (DatabaseClass.getCompanies().containsKey(company_username))
		{
			shortlist.put(company_username,s);
			return true;
		}
		return false;
	}
	
	public boolean deleteShortlisted(String company_username,Student s)
	{
		if(shortlist.containsKey(company_username))
		{
			
			HashSet<Student> ls=shortlist.get(company_username);
			if(ls.remove(s))
			{
				shortlist.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}
}
