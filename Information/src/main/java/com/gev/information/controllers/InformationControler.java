package com.gev.information.controllers;

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

import com.gev.information.models.Information;
import com.gev.information.services.InformationService;

@RestController
@RequestMapping("/information")
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
	
	@PostMapping("/save")
	public Information saveInformation(@Valid @RequestBody Information information) {
		
		return infoService.saveInformation(information);
	}
	
	@PutMapping("/update")
	public Information updateInformation(@Valid @RequestBody Information information) {
		
		return (getInformation(information.getId()).isPresent()?infoService.saveInformation(information):null );
	}
}
