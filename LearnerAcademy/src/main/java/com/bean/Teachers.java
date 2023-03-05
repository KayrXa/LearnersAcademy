package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity (name= "Teachers")
@Table (name="teachers", uniqueConstraints= {
		@UniqueConstraint(columnNames= "tid"),
		@UniqueConstraint(columnNames= "email"),
		@UniqueConstraint(columnNames= "phone")
		})
public class Teachers{
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "tid", unique= true, nullable=false)
	private int tid;
	
	@Column(name = "name", unique= false, nullable=false)
	private String name;
	
	@Column(name = "surname", unique= false, nullable=false)
	private String surname;
	
	@Column(name = "email", unique= true, nullable=true)
	private String email;
	
	@Column(name = "phone", unique= true, nullable=true)
	private String phone;

	@Column(name = "Birth_number", unique= true, nullable=false)
	private String brthno;

	
	
	
	public Teachers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Teachers(int tid, String brthno, String email, String name, String phone, String surname) {
		super();
		this.tid = tid;
		this.name = name;
		this.brthno = brthno;
		this.email = email;
		this.phone = phone;
		this.surname = surname;
			
		
	}

	public int getTid() {
		return tid;
	}


	public void setTid(int tid) {
		this.tid = tid;
	}

	
	public String getBrthno() {
		return brthno;
	}


	public void setBrthno(String brthno) {
		this.brthno = brthno;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSurname() {
		return surname;
	}


	public void setSurname(String surname) {
		this.surname = surname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	

	@Override
	public String toString() {
		return "Teachers [tid=" + tid + ", name=" + name + ", surname=" + surname + ", email=" + email + ", phone="
				+ phone + ", brthno=" + brthno + "]";
	}
	

	
	
	
	
	
	
	
}
