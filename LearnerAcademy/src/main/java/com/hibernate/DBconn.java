package com.hibernate;


import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.bean.Classes;
import com.bean.ClassesSubjectsTeacherLink;
import com.bean.Students;
import com.bean.Subjects;
import com.bean.Teachers;

public class DBconn {

	private static SessionFactory factory = HibernateConfig.getSessionFactory();
	
	public boolean addStudent(Students st){
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(st);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
   }
	
	
	public boolean addClass(Classes cls){
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(cls);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
   }
	
	
	
	public boolean addTeacher(Teachers teacher){
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(teacher);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
   }
	
	
	
	public boolean addSubject(Subjects sub){
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(sub);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
   }
	
	
	public boolean addRelation(ClassesSubjectsTeacherLink rel){
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.save(rel);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
   }
	
	public List<Students> getAllStudents() {
		Session session = factory.openSession();
		CriteriaQuery<Students> cq = session.getCriteriaBuilder().createQuery(Students.class);
		cq.from(Students.class);
		List<Students> studentList = session.createQuery(cq).getResultList();
		session.close();
		return studentList;
	}
	
	// LAclass methods
	
	public List<Classes> getAllClasses() {
		Session session = factory.openSession();
		CriteriaQuery<Classes> cq = session.getCriteriaBuilder().createQuery(Classes.class);
		cq.from(Classes.class);
		List<Classes> classList = session.createQuery(cq).getResultList();
		session.close();
		return classList;
	}
	
	
	public List<Teachers> getAllTeachers() {
		Session session = factory.openSession();
		CriteriaQuery<Teachers> cq = session.getCriteriaBuilder().createQuery(Teachers.class);
		cq.from(Teachers.class);
		List<Teachers> teacherList = session.createQuery(cq).getResultList();
		for(Teachers teacher: teacherList) {
			System.out.println(teacher);
		}
		return teacherList;
	}
	
	public List<Subjects> getAllSubjects() {
		Session session = factory.openSession();
		CriteriaQuery<Subjects> cq = session.getCriteriaBuilder().createQuery(Subjects.class);
		cq.from(Subjects.class);
		List<Subjects>subjectList = session.createQuery(cq).getResultList();
		for(Subjects subject: subjectList) {
			System.out.println(subject);
		}
		return subjectList;
	}
	
	public List<ClassesSubjectsTeacherLink> getAllRelations() {
		Session session = factory.openSession();
		CriteriaQuery<ClassesSubjectsTeacherLink> cq = session.getCriteriaBuilder().createQuery(ClassesSubjectsTeacherLink.class);
		cq.from(ClassesSubjectsTeacherLink.class);
		List<ClassesSubjectsTeacherLink> relList = session.createQuery(cq).getResultList();
		for(ClassesSubjectsTeacherLink rel: relList) {
			System.out.println(rel);
		}
		return relList;
	}
	
	
	
	public boolean updateStudent(Students st) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(st);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	
	public boolean updateTeacher(Teachers teach) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(teach);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean updateClass(Classes cls) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(cls);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean updateSubject(Subjects sub) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(sub);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean updateRelation(ClassesSubjectsTeacherLink rel) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			session.update(rel);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean deleteStudentById(int stid) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Students st = session.get(Students.class, stid);
			if (st!=null)
				session.delete(st);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	
	public boolean deleteClassById(String cid) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Classes cls = session.get(Classes.class, cid);
			if (cls!=null)
				session.delete(cls);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean deleteTeacherById(int tid) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Teachers teach = session.get(Teachers.class, tid);
			if (teach!=null)
				session.delete(teach);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean deleteSubjectById(int sid) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			Subjects sub = session.get(Subjects.class, sid);
			if (sub!=null)
				session.delete(sub);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	public boolean deleteRelationById(int id) {
		boolean success = true;
		Session session = factory.openSession();
		Transaction transaction = null;
		try{
			transaction = session.beginTransaction();
			ClassesSubjectsTeacherLink rel = session.get(ClassesSubjectsTeacherLink.class, id);
			if (rel!=null)
				session.delete(rel);
			transaction.commit();
		}catch (HibernateException e) {
			if (transaction!=null)
				transaction.rollback();
			success = false;
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
		return success;
	}
	
	
	
}