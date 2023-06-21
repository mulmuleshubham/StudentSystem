package com.bita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bita.dao.StudentDao;
import com.bita.entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;

	public List<Student> insertStudentData() {
		List<Student> list = dao.insertStudentData();
		return list;
	}

	public String insertStudent(List<Student> al) {
		String msg = dao.getStudentById(al);
		return msg;
	}

	public List<Student> getStudentById(int id) {

		return dao.getStudentById(id);
	}

	public String deleteStudent(int id) {

		return dao.deleteStudent(id);
	}

	public String updateStudent(Student ee) {

		return dao.updateStudent(ee);
	}

}
