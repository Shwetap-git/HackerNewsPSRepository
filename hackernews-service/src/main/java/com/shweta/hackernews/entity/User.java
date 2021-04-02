package com.shweta.hackernews.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	@Id
	private String id;
	private Number created;
	private String about;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Number getCreated() {
		return created;
	}
	public void setCreated(Number created) {
		this.created = created;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	

}
