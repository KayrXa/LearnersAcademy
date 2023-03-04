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
	private Integer cid;
	
	@Column(name = "name", unique= true, nullable=false)
	private String name;
		
	@OneToMany
	@JoinColumn(name="cid")
	private List<Students> students;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
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
		
	
}