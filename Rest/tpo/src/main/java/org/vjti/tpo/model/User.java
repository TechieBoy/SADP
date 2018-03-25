package org.vjti.tpo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	protected  String userId;
	protected  String password;
	protected String name;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	public User(){}
	public User(String userId,String password,String name){
		
		this.userId=userId;
		this.password=password;
		this.name=name;
		
		
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
