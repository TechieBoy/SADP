package org.vjti.tpo.model;

import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Company extends User {
	
	private int cTC;
	private Date date_of_process;
	private String[] branches;
	private int year;
	public Company(){
		
	}
	public int getcTC() {
		return cTC;
	}

	public void setcTC(int cTC) {
		this.cTC = cTC;
	}

	public Date getDate_of_process() {
		return date_of_process;
	}

	public void setDate_of_process(Date date_of_process) {
		this.date_of_process = date_of_process;
	}

	public String[] getBranches() {
		return branches;
	}

	public void setBranches(String[] branches) {
		this.branches = branches;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Company(String userId,String password,String name,int cTC, Date date_of_process, String[] branches, int year) {
		super(userId,password,name);
		this.cTC = cTC;
		this.date_of_process = date_of_process;
		this.branches = branches;
		this.year = year;
	}

}
