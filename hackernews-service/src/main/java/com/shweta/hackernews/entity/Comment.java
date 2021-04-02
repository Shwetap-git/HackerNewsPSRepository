package com.shweta.hackernews.entity;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties(value={"deleted","title","url","score","dead","parent","poll","parts","descendants","type"})
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String text;
	private String by;
	private Number time;
	@ElementCollection(targetClass=Integer.class)
	private List<Integer> kids;
	private String userTime;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getBy() {
		return by;
	}
	public void setBy(String by) {
		this.by = by;
	}
	public Number getTime() {
		return time;
	}
	public void setTime(Number time) {
		this.time = time;
	}
	
	public List<Integer> getKids() {
		return kids;
	}
	public void setKids(List<Integer> kids) {
		this.kids = kids;
	}
	
	public String getUserTime() {
		return userTime;
	}
	public void setUserTime(String string) {
		this.userTime = string;
	}
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", text=" + text + ", by=" + by + ", time=" + time + "]";
	}
	
	
}
