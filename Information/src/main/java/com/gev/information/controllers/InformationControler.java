package com.gev.information.controllers;

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

import com.gev.information.models.Information;
import com.gev.information.services.InformationService;

@RestController
@RequestMapping("/information")
@CrossOrigin("*")
public class InformationControler {
	
	@Autowired
	InformationService infoService;
	
	@GetMapping("/all")
	public Iterable<Information> getAllInformations() {
		
		return infoService.getAllInformation();
	}
	
	@GetMapping("/{id}")
	public Optional<Information> getInformation(@PathVariable("id") long id){
		
		return infoService.getInformation(id);
	}
	
	@DeleteMapping("/{id}/delete")
	public void deleteInformation(@PathVariable("id") long id) {
		
		infoService.deleteInformation(id);
	}
	
	@PostMapping(path = "/save", 
			consumes =  MediaType.MULTIPART_FORM_DATA_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Information saveInformation(@Valid @RequestParam("level") String level, @RequestParam("image") MultipartFile imageFile) throws IllegalStateException, IOException {
		
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh:mm:ss");
		
		String date = dateFormat.format(new Date());
		
		String imageName = "INFO-"+(date).toString()+".jpg";
		
		File file = new File("/home/g3v/Documents/Enastic/Information/src/main/resources/static/"+imageName);
		
		if(!file.exists()) file.mkdirs();
		
		imageFile.transferTo(file);
		
		Information information = new Information(new Date(), level, "http://192.168.43.136:10006/INFORMATION-MICROSERVICE/"+imageName);
		
		
		return infoService.saveInformation(information);
	}
	
	@PutMapping("/update")
	public Information updateInformation(@Valid @RequestBody Information information) {
		
		return (getInformation(information.getId()).isPresent()?infoService.saveInformation(information):null );
	}
}
