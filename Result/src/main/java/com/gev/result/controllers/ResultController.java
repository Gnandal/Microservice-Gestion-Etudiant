package com.gev.result.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.gev.result.models.Result;
import com.gev.result.services.ResultService;

@RestController
@RequestMapping("/result")
@CrossOrigin("*")
public class ResultController {

	@Autowired
	ResultService resultService;
	
	@GetMapping("/all")
	public Iterable<Result> getAllResults(){
		
		return resultService.getAllResults();
	}
	
	@GetMapping("/{id}")
	public Optional<Result> getResult(@PathVariable("id") long id){
		
		return resultService.getResult(id);
	}
	
	@DeleteMapping("/{id}/delete")
	@CrossOrigin("*")
	public void deleteResult(@PathVariable("id") long id) {
		
		resultService.deleteResult(id);
	}
	
	@PostMapping(path = "/save", 
			 consumes =  MediaType.MULTIPART_FORM_DATA_VALUE,
			 produces = MediaType.APPLICATION_JSON_VALUE)
	public Result saveInformation(@RequestParam("module") String module, @RequestParam("level") String level,
			@RequestParam("image") MultipartFile imageFile) throws IllegalStateException, IOException {
		
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		
		String date = dateFormat.format(new Date());
		
		String imageName = "RESULT-"+(date).toString()+".jpg";
		
		File file = new File("/home/g3v/Documents/Enastic/Result/src/main/resources/static/"+imageName);
		
		if(!file.exists()) file.mkdirs();
		
		imageFile.transferTo(file);
		
		Result result = new Result(module ,level, new Date(), "http://193.168.43.136:10006/RESULT-MICROSERVICE/"+imageName);
		
		return resultService.saveResult(result);
	}
	
	@PutMapping("/update")
	public Result updateResult(@Valid @RequestBody Result result) {
		
		return resultService.updateResult(result);
	}
}
