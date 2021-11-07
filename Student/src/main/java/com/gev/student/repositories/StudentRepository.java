package com.gev.student.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gev.student.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String>{

}
