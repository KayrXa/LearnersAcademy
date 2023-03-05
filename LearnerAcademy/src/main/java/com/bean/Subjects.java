package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity (name= "Subjects")
@Table (name="subjects")

public class Subjects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sid", unique= false, nullable=false)
	private int  sid;
	
	@Column(name = "Name_of_subject", unique= false, nullable=false)
	private String name;
	
	@Column(name = "Shortcut", unique= false, nullable=false)
	private String shortcut;
	
	
	
	
	
	
	public Subjects() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subjects(int sid, String name, String shortcut) {
		super();
		this.sid = sid;
		this.name = name;
		this.shortcut = shortcut;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortcut() {
		return shortcut;
	}

	public void setShortcut(String shortcut) {
		this.shortcut = shortcut;
	}

	@Override
	public String toString() {
		return "Subjects [sid=" + sid + ", name=" + name + ", shortcut=" + shortcut + "]";
	}
	
	
}
