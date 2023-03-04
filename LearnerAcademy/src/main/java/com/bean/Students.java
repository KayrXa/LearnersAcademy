package com.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.HibernateConfig;

@Entity (name= "Students")
@Table (name="students", uniqueConstraints= {
		@UniqueConstraint(columnNames= "stid"),
		@UniqueConstraint(columnNames= "Birth_number"),
		@UniqueConstraint(columnNames= "Phone_number"),
		@UniqueConstraint(columnNames= "Email")
		})
public class Students implements Serializable {
	

	private static final long serialVersionUID = -7773020814888663384L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stid", unique= true, nullable=false)
	private int stid;
	
	@Column(name = "Name", unique= false, nullable=false)
	private String name;
	
	@Column(name = "Surname", unique= false, nullable=false)
	private String sur;
	
	@Column(name = "Birth_number", unique= true, nullable=false)
	private int brthno;
	
	@Column(name = "Phone_number", unique= true, nullable=true)
	private int phone;
	
	@Column(name = "Email", unique= true, nullable=true)
	private String email;

	
		
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

	public int getBrthno() {
		return brthno;
	}

	public void setBrthno(int brthno) {
		this.brthno = brthno;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public static Integer saveStudents(Students stud) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Integer id = (Integer) session.save(stud);
		tr.commit();
		session.close();
		return id;
	}
	
	public static Students getStudentsById(int id) {
		Session session = factory.openSession();
		Students stud = session.get(Students.class, id);
		session.close();
		return stud;
		
	}
	
	public static void updateStudents(Students stud) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(stud);
		tr.commit();
		session.close();
		
	}
		
	public static void deleteStudents(Students stud) {
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(stud);
		tr.commit();
		session.close();
	}
	
	public List<Students> getAllStudents(){
		Session session = factory.openSession();
		CriteriaQuery<Students> cq = session.getCriteriaBuilder().createQuery(Students.class);
		cq.from(Students.class);
		List<Students> studlist = session.createQuery(cq).getResultList();
		session.close();
		return studlist;
	}

	@Override
	public String toString() {
		return "Students [stid=" + stid + ", name=" + name + ", sur=" + sur + ", brthno=" + brthno + ", phone=" + phone
				+ ", email=" + email + "]";
	}
	
	
	
	
}	

