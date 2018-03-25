package org.vjti.tpo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TPOStaff extends User {

	private String designation;
	
	public TPOStaff(){}
	

	public TPOStaff(String userId,String password,String name,String designation)
	{
		super(userId,password,name);
		this.designation=designation;
		
	}
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
}
