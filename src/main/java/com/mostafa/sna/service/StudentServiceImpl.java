package com.mostafa.sna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mostafa.sna.dao.StudentRepository;
import com.mostafa.sna.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudent(int id) {
		
		Optional<Student> result = studentRepository.findById(id);
		
		if(result.isPresent()) {
			return result.get();
		} else {
			throw new RuntimeException("Student id "+id+" not found!");
		}
		
	}

	@Override
	public void saveOrUpdateStudent(Student student) {
		
		studentRepository.save(student);
		
	}

	@Override
	public void deleteStudent(Student student) {
		
		studentRepository.delete(student);
		
	}

	@Override
	public Student findStudentByFirstNameOrLastName(String firstName, String lastName) {
		return studentRepository.findStudentByFirstNameOrLastName(firstName, lastName);
	}

	@Override
	public Student findStudentByFirstNameAndLastName(String lastName, String firstName) {
		return studentRepository.findStudentByFirstNameAndLastName(lastName, firstName);
	}

	@Override
	public Student getStudentByLastName(String lastName) {
		return studentRepository.findByLastName(lastName);
	}
	
	

}
