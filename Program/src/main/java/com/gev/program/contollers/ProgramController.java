package com.gev.program.contollers;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gev.program.models.Program;
import com.gev.program.services.ProgramService;

@RestController
@RequestMapping("/program")
@CrossOrigin("*")
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
	
	@PostMapping(path = "/save",
			consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Program saveProgram(@RequestParam("image") MultipartFile imageFile, 
			@Valid @RequestParam("level") String level) throws IOException {
		
		
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		
		String date = dateFormat.format(new Date());
		
		String imageName = "EDT-"+(date).toString()+".jpg";
		
		File file = new File("/home/g3v/Documents/Enastic/Program/src/main/resources/static/"+imageName);
		
		if(!file.exists()) file.mkdirs();
		
		imageFile.transferTo(file);
		
		Program program = new Program( 0, level, new Date(), "http://192.168.43.136:10006/PROGRAM-MICROSERVICE/"+imageName);
		
		
		return programService.saveProgram(program);
	}
	
	@PutMapping("/update")
	public Program updateProgram(@RequestParam("image") MultipartFile imageFile, 
			@RequestParam("level") String level) throws IOException {
		
		Program program = new Program( 0, level, new Date(), imageFile.getOriginalFilename());
		
		return programService.updateProgram(program);
	}
}
