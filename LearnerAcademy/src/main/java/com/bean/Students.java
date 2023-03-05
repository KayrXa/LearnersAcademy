package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity (name= "Students")
@Table (name="students", uniqueConstraints= {
		@UniqueConstraint(columnNames= "stid"),
		@UniqueConstraint(columnNames= "Birth_number"),
		@UniqueConstraint(columnNames= "Phone_number"),
		@UniqueConstraint(columnNames= "Email")
		})
public class Students  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stid", unique= true, nullable=false)
	private int stid;
	
	@Column(name = "name", unique= false, nullable=false)
	private String name;
	
	@Column(name = "Surname", unique= false, nullable=false)
	private String sur;
	
	@Column(name = "Birth_number", unique= true, nullable=false)
	private String brthno;
	
	@Column(name = "Phone_number", unique= true, nullable=true)
	private String phone;
	
	@Column(name = "Email", unique= true, nullable=true)
	private String email;
	
	@Column(name = "cid", unique= true, nullable=true)
	private int cid;	
	
	
	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Students(int stid, String name, String sur, String brthno, String phone, String email, int cid) {
		super();
		this.stid = stid;
		this.name = name;
		this.sur = sur;
		this.brthno = brthno;
		this.phone = phone;
		this.email = email;
		this.cid = cid;
	}
		
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}


	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSur() {
		return sur;
	}
	public void setSur(String sur) {
		this.sur = sur;
	}
	public String getBrthno() {
		return brthno;
	}
	public void setBrthno(String brthno) {
		this.brthno = brthno;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Students [stid=" + stid + ", name=" + name + ", sur=" + sur + ", brthno=" + brthno + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	

	
	
}	

