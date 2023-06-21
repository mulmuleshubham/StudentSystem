package com.bita.dao;

import java.util.List;

import com.bita.entity.Student;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class StudentDao {
	
	@Autowired
	SessionFactory sf;

	public List<Student> insertStudentData() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Student.class);
		
		List<Student> list= criteria.list();
		return list;
	}

	public String getStudentById(List<Student> al) {
		Session session = sf.openSession();
		Transaction tr=session.beginTransaction();
		for (Student student : al) {
			session.save(student);
		}
		tr.commit();
		return "student save successfully...";
	}

	public List<Student> getStudentById(int id) {
		Session session=sf.openSession();
		Criteria cr=session.createCriteria(Student.class);
		cr.add(Restrictions.eq("id", id));
		List<Student> list=cr.list();
		return list;
	}

	public String deleteStudent(int id) {
		Session session=sf.openSession();
		Student st=session.load(Student.class,id);
		Transaction tr=session.beginTransaction();
		session.delete(st);
		tr.commit();
		return "delete emp sucessfully";
	}

	public String updateStudent(Student st) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		session.update(st);
		tr.commit();
		return "update customer data...";
	}

}
