package com.hibernate;


import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Students;

public class TestStudents {
	
private static SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public static void main(String[]args) {
		
		//check config load
		System.out.println("config loaded");	
		System.out.print("Students java manage loaded");
		System.out.print("Students java manage loaded");

	}

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
	
	public static List<Students> getAllStudens(){
		Session session = factory.openSession();
		CriteriaQuery<Students> cq = session.getCriteriaBuilder().createQuery(Students.class);
		cq.from(Students.class);
		List<Students> studlist = session.createQuery(cq).getResultList();
		session.close();
		return studlist;
		
		
	}
	

	
	
}




