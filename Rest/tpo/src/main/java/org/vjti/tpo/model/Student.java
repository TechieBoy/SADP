package org.vjti.tpo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student extends User {
	
	private String branch;
	private int year;
	private float cgpa;
	
	public Student(){}
	
	public Student(String userId,String password,String name,String branch,int year,float cgpa){
		
		super(userId,password,name);
		this.branch=branch;
		this.year=year;
		this.cgpa=cgpa;
		
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public float getCgpa() {
		return cgpa;
	}

	public void setCgpa(float cgpa) {
		this.cgpa = cgpa;
	}
}
