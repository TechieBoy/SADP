package org.vjti.tpo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Feedback {
	
	private String content;
	private String branch;
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}


	public Feedback(String content, String branch) {
		
		this.content = content;
		this.branch = branch;
	}

	public Feedback(){}
	

}
