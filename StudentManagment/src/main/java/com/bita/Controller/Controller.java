package com.bita.Controller;

		import java.util.List;

import org.hibernate.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bita.entity.Student;
import com.bita.service.StudentService;

@RestController
public class Controller {
	@Autowired
	StudentService ser;

	Student ee;

	@GetMapping("/all")
	public List<Student> insertStudentData() {
		List<Student> list = ser.insertStudentData();
		return list;
	}

	@PostMapping("/add")
	public String insertStudent(@RequestBody List<Student> al) {
		System.out.println("coming employees.." + al);
		String msg = ser.insertStudent(al);
		return msg;

	}

	@GetMapping("/byid/{id}")
	public List<Student> getStudentById(@PathVariable int id) {
		List<Student> list = ser.getStudentById(id);
		return list;
	}

	@PutMapping("/update/{id}")
	public String updateStudent(@RequestBody Student ee) {
		return ser.updateStudent(ee);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
		return ser.deleteStudent(id);

	}
}
