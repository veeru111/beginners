package com.ts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ts.dao.StudentDAO;
import com.ts.dto.Student;


@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public int studentRegistration(Student student) {
		return studentDAO.studentRegistration(student);
	}

	public List<Student> listStudents(){
		return studentDAO.listStudents();
	}

	public Student listStudent(int id){
		return studentDAO.listStudent(id);
	}
}
