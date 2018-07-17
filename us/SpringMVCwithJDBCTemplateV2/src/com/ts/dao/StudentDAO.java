package com.ts.dao;

import java.util.List;

import com.ts.dto.Student;

public interface StudentDAO {

		public int studentRegistration(Student student);
		
		public List<Student> listStudents();
		
		public Student listStudent(int id);
}
