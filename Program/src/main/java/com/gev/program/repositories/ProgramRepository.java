package com.gev.program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gev.program.models.Program;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long>{
}
