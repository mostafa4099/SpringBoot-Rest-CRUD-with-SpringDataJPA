package com.mostafa.sna.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mostafa.sna.entity.Student;
import com.mostafa.sna.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		
		return studentService.getAllStudents();
		
	}
	
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id){
		
		return studentService.getStudent(id);
		
	}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student){
		
		student.setId(0);
		studentService.saveOrUpdateStudent(student);
		
		return student;
		
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student){
		
		studentService.saveOrUpdateStudent(student);
		
		return student;
		
	}
	
	@DeleteMapping("/students/{id}")
	public String deleteStudent(@PathVariable int id){
		
		Student student = studentService.getStudent(id);
		
		if (student == null) {
			return "Student id "+id+" not found!";
		} else {
			studentService.deleteStudent(student);
			return "Student Removed Successful!";
		}
		
	}
	
	@GetMapping("/students/{firstName}/{lastName}")
	public Student findStudentByFirstNameOrLastName(@PathVariable String firstName, @PathVariable String lastName){
		
		return studentService.findStudentByFirstNameOrLastName(firstName, lastName);
		
	}
	
//	@GetMapping("/students/{lastName}")
//	public Student getStudentByLastName(@PathVariable String lastName){
//		
//		return studentService.getStudentByLastName(lastName);
//		
//	}
	
	@GetMapping("/students/{lastName}/{firstName}")
	public Student findStudentByLastNameAndFirstName(@RequestParam String lastName, @RequestParam String firstName){
		
		return studentService.findStudentByFirstNameAndLastName(lastName, firstName);
		
	}
	
}
