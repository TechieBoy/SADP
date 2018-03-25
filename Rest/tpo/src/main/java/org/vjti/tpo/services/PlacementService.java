package org.vjti.tpo.services;

import java.util.HashSet;
import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Student;

public class PlacementService {
	
	private static Map<String,HashSet<Student>> placed=DatabaseClass.getPlaced();
	
	public HashSet<Student> getPlaced(String username)
	{
		return placed.get(username);
	}
	
	public  boolean addPlaced(String company_username,HashSet<Student> s){
		
	
		
		if(placed.containsKey(company_username))
		{
			
			HashSet<Student> ls=placed.get(company_username);
			ls.addAll(s);
			placed.put(company_username,ls);
			return true;
		}
		else if (DatabaseClass.getCompanies().containsKey(company_username))
		{
			placed.put(company_username,s);
			return true;
		}
		
		return false;
	}
	
	/*public boolean updatePlaced(String company_username,Student s)
	{
		if(placed.containsKey(company_username))
		{
			Student temp2 = null;
			HashSet<Student> ls=placed.get(company_username);
			for(Student temp : ls)
			{
				if(temp.equals(s)){
					temp2=temp;
					break;
				}
					
			}
			ls.remove(temp2);
			ls.add(s);
			return true;
		}
		return false;
	}*/
	
	public boolean deletePlaced(String company_username,Student s)
	{
		if(placed.containsKey(company_username))
		{
			
			HashSet<Student> ls=placed.get(company_username);
			if(ls.remove(s))
			{
				placed.put(company_username,ls);
				return true;
			}
		
		}
		return false;
		
	}
}
