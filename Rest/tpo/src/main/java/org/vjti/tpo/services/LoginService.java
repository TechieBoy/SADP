package org.vjti.tpo.services;

import java.util.Map;

import org.vjti.tpo.database.DatabaseClass;
import org.vjti.tpo.model.User;

public class LoginService {
	
	private static Map<String,User> users=DatabaseClass.getUsers();
	
	public boolean verify(User u){
		String user_id=u.getUserId();
		if(users.containsKey(user_id))
		{
			User p=users.get(user_id);
			if(p.getPassword().equals(u.getPassword()))
				return true;
		}
		return false;
		
		
	}
}
