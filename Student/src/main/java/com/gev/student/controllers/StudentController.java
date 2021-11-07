package com.gev.student.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gev.student.models.Student;
import com.gev.student.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/all")
	public Iterable<Student> getAllStudents(){
		
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{matricule}")
	public Optional<Student> getStudent(@PathVariable("matricule") String matricule){
		
		return studentService.getStudent(matricule);
	}
	
	@DeleteMapping("/{matricule}/delete")
	public void deleteStudent(@PathVariable("matricule") String matricule) {
		
		studentService.deleteStudent(matricule);
	}
	
	@PostMapping("/save")
	public Student saveStudent(@Valid @RequestBody Student student) {
		
		return studentService.saveStudent(student);
	}
	
	@PutMapping("/update")
	public Student updateStudent(@Valid @RequestBody Student student) {
		
		return studentService.updateStudent(student);
	}
	
}
