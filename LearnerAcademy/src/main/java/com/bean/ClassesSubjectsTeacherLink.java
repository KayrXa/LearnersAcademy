package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity (name= "ClassesSubjectsTeacherLink")
@Table(name="classesSubjectsTeacherLink")
public class ClassesSubjectsTeacherLink {
			
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private int id;

	  @ManyToOne
	  @JoinColumn(name = "classes_cid")
	  private Classes classes;

	  @ManyToOne
	  @JoinColumn(name = "teachers_tid")
	  private Teachers teachers;

	  @ManyToOne
	  @JoinColumn(name = "subjects_sid")
	  private Subjects subjects;
	 
    
    public ClassesSubjectsTeacherLink(int id, Classes classes, Teachers teachers, Subjects subjects) {
		super();
		this.id = id;
		this.classes = classes;
		this.teachers = teachers;
		this.subjects = subjects;
	}


	public ClassesSubjectsTeacherLink() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Classes getClasses() {
		return classes;
	}


	public void setClasses(Classes classes) {
		this.classes = classes;
	}


	public Teachers getTeachers() {
		return teachers;
	}


	public void setTeachers(Teachers teachers) {
		this.teachers = teachers;
	}


	public Subjects getSubjects() {
		return subjects;
	}


	public void setSubjects(Subjects subjects) {
		this.subjects = subjects;
	}


	@Override
	public String toString() {
		return "ClassesSubjectsTeacherLink [id=" + id + ", classes=" + classes + ", teachers=" + teachers
				+ ", subjects=" + subjects + "]";
	}



	
    
    
}
