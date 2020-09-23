package br.edu.insper.mvc.model;

import java.sql.Timestamp;

public class Task {
	private Integer id;
	private String user;
	private String task;
	private String tag;
	private Timestamp creDate;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setUser(String user) {
		this.user = user;
	}
	
	public String getTask() {
		return task;
	}
	
	public void setTask(String task) {
		this.task = task;
	}
	
	public Timestamp getCreDate() {
		return creDate;
	}
	
	public void setCreDate(Timestamp creDate) {
		this.creDate = creDate;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	

}
