package org.vjti.tpo.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Notice {

	private Long id;
	private String content;
	
	public Notice(){
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Notice(Long id, String content) {
		
		this.id = id;
		this.content = content;
	}
}
