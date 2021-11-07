package com.gev.program.contollers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gev.program.models.Program;
import com.gev.program.services.ProgramService;

@RestController
@RequestMapping("/program")
public class ProgramController {
	
	@Autowired
	ProgramService programService;
	
	@GetMapping("/all")
	public Iterable<Program> getAllprograms(){
		
		return programService.getAllPrograms();
	}
	
	@GetMapping("/{id}")
	public Optional<Program> getProgram(@PathVariable("id") long id){
		
		return programService.getProgram(id);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteProgram(@PathVariable("id") long id) {
		
		programService.deleteProgram(id);
	}
	
	@PostMapping("/save")
	public Program saveProgram(@Validated @RequestBody Program program) {
		
		return programService.saveProgram(program);
	}
	
	@PutMapping("/update")
	public Program updateProgram(@RequestBody Program program) {
		
		return programService.updateProgram(program);
	}

}
