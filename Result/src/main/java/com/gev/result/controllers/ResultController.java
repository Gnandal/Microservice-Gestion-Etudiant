package com.gev.result.controllers;

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

import com.gev.result.models.Result;
import com.gev.result.services.ResultService;

@RestController
@RequestMapping("/result")
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
	public void deleteResult(@PathVariable("id") long id) {
		
		resultService.deleteResult(id);
	}
	
	@PostMapping("/save")
	public Result saveResult(@Valid @RequestBody Result result) {
		
		return resultService.saveResult(result);
	}
	
	@PutMapping("/update")
	public Result updateResult(@Valid @RequestBody Result result) {
		
		return resultService.updateResult(result);
	}
}
