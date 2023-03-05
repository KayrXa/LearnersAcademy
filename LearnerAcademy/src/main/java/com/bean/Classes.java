package com.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity (name= "Classes")
@Table(name="classes", uniqueConstraints = {
	@UniqueConstraint(columnNames= "cid"),
	@UniqueConstraint(columnNames= "name")})
public class Classes {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid", unique= true, nullable=false)
	private String cid;
	
	@Column(name = "name", unique= true, nullable=false)
	private String name;
		
	@OneToMany
	@JoinColumn(name="cid")
	private List<Students> students;

	
	
	
	public Classes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Classes(String name) {
		super();
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public Classes(String cid,String name) {
		super();
		this.cid = cid;
		this.name = name;
	
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Classes [cid=" + cid + ", name=" + name + ", students=" + students + "]";
	}
		
	
}
