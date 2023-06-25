package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vote implements Serializable{
	private static final long serialVersionUID = 6;
	
	@Id
	@GeneratedValue
	private int id;
	private String date, content ;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Vote() {
		super();
	}
	public Vote(String content) {
		super();
		this.content = content;
	}
	public Vote( String content, String date) {
		super();
		
		this.content = content;
		this.date = date;
		
	}
	
	
	
	
	
	

	
	
	
	
	
	
}
