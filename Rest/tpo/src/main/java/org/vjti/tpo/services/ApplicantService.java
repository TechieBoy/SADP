package org.vjti.tpo.services;

import java.util.HashSet;
import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Student;

public class ApplicantService {
	
	private static Map<String,HashSet<Student>> applied=DatabaseClass.getApplied();

	public HashSet<Student> getApplied(String username)
	{
		return applied.get(username);
	}
	
	public boolean addApplied(String company_username,Student s){
		
		
		
		if(applied.containsKey(company_username))
		{
			
			HashSet<Student> ls=applied.get(company_username);
			ls.add(s);
			applied.put(company_username,ls);
			return true;
		}
		else if (DatabaseClass.getCompanies().containsKey(company_username))
		{
			HashSet<Student> d=new HashSet<Student>();
			d.add(s);
			applied.put(company_username,d);
			return true;
		}
		
		return false;
	}
	
	public boolean deleteApplied(String company_username,Student s)
	{
		if(applied.containsKey(company_username))
		{
			
			HashSet<Student> ls=applied.get(company_username);
			if(ls.remove(s))
			{
				applied.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}

}
