package com.gev.program.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.program.models.Program;
import com.gev.program.repositories.ProgramRepository;

@Service
public class ProgramService {
	
	@Autowired
	ProgramRepository programRepo;
	
	public Iterable<Program> getAllPrograms(){
		
		return programRepo.findAll();
		
	}
	
	public Optional<Program> getProgram(long id) {
		
		return programRepo.findById(id);
		
	}
	
	public void deleteProgram(long id) {
		
		programRepo.deleteById(id);
		
	}
	
	public Program saveProgram(Program program) {
		
		return programRepo.save(program);
		
	}
	
	public Program updateProgram(Program program) {
		
		return (getProgram(program.getId_program()).isPresent()?saveProgram(program):null);
		
	}
}
