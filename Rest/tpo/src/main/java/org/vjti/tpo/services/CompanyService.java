package org.vjti.tpo.services;

import java.util.ArrayList;
import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.Company;
import org.vjti.tpo.model.User;

public class CompanyService {
	
	private static Map<String,Company> companies=DatabaseClass.getCompanies();
	private static Map<String,User> user_login=DatabaseClass.getUsers();

	public Company getCompany(String username){
		
		return companies.get(username);	}



	public ArrayList<Company> getCompanies(){
		
		return new ArrayList<Company>(companies.values());
	
}
public ArrayList<Company> getCompaniesByBranch(String branch){
		
		
		ArrayList<Company> cs= new ArrayList<Company>();
		for(Company c: companies.values())
		{
			
			String[] branches=c.getBranches();
			for(String s : branches)
			{
				if(s.equalsIgnoreCase(branch)){
					cs.add(c);
					break;}
			}
				
		}
		return cs;
		
		
		
	}

public boolean addCompany(Company c)
{
	if(companies.containsKey(c.getUserId()))
		return false;
	companies.put(c.getUserId(),c);
	user_login.put(c.getUserId(),new User(c.getUserId(),c.getPassword(),c.getName()));
	return true;
}

public boolean updateCompany(Company c)
{
	if(companies.containsKey(c.getUserId()))
	{
		companies.put(c.getUserId(),c);
		user_login.put(c.getUserId(),new User(c.getUserId(),c.getPassword(),c.getName()));
		return true;
	}
	
	return false;
}

public boolean removeCompany(String username)
{
	if(companies.containsKey(username))
	{
		companies.remove(username);
		user_login.remove(username);
		return true;
	}
	
	return false;
}

}