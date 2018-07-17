package com.ts.daoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.ts.dao.StudentDAO;
import com.ts.dto.Student;

@Component
public class StudentDAOImpl implements StudentDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT_STUDENT = "insert into student(id, sname, fees) values(?,?,?)";
	private final String SELECT_QUERY = "SELECT * FROM STUDENT";
	private final String SELECT_QUERY_BY_ID = "select * from student where id = ?";

	public int studentRegistration(Student student) {

		/*String sql="insert into student values('"+student.getId()+"','"+student.getSname()+"','"+student.getFees()+"')";			
		jdbcTemplate.update(sql);*/

		return (jdbcTemplate.update(SQL_INSERT_STUDENT,
				student.getId(),student.getSname(),student.getFees()));
	}
	
	public List<Student> listStudents(){
		List<Student> studentsList  = jdbcTemplate.query(SELECT_QUERY,
				new BeanPropertyRowMapper(Student.class));
		return studentsList;
	}
	
	public Student listStudent(int id){
		Student student = jdbcTemplate.queryForObject(SELECT_QUERY_BY_ID, new Object[] {id}, new BeanPropertyRowMapper(Student.class));
		return student;
			}
}
