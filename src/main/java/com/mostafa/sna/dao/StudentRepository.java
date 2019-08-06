package com.mostafa.sna.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mostafa.sna.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	
	public Student findStudentByFirstNameOrLastName(String firstName, String lastName);

	public Student findStudentByFirstNameAndLastName(String lastName, String firstName);

	public Student findByLastName(String lastName);
	
}
