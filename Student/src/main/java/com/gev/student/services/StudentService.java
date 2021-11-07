package com.gev.student.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.student.models.Student;
import com.gev.student.repositories.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Iterable<Student> getAllStudents() {
		
		return studentRepository.findAll();
	}
	
	public Optional<Student> getStudent(String matricule){
		
		return studentRepository.findById(matricule);
	}
	
	public void deleteStudent(String matricule) {
		
		studentRepository.deleteById(matricule);
	}
	
	public Student saveStudent(Student student) {
		
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) {
		
		return (getStudent(student.getMatricule()).isPresent()?saveStudent(student):null);
	}
}
