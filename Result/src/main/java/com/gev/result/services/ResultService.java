package com.gev.result.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.result.models.Result;
import com.gev.result.repositories.ResultRepository;

@Service
public class ResultService {

	@Autowired
	ResultRepository resultRepo;
	
	public Iterable<Result> getAllResults(){
		
		return resultRepo.findAll();
	}
	
	public Optional<Result> getResult(long id){
		
		return resultRepo.findById(id);
	}
	
	public void deleteResult(long id) {
		
		 resultRepo.deleteById(id);
	}
	
	public Result saveResult(Result result) {
		
		return resultRepo.save(result);
	}
	
	public Result updateResult(Result result) {
		
		return (getResult(result.getId_result()).isPresent()?saveResult(result):null);
	}
	
}
