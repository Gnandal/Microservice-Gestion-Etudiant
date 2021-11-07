package com.gev.information.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.information.models.Information;
import com.gev.information.repositories.InformationRepository;

@Service
public class InformationService {

	@Autowired
	InformationRepository infoRepo;
	
	public Iterable<Information> getAllInformation(){
		return infoRepo.findAll();
	}
	
	public Optional<Information> getInformation(long id){
		return infoRepo.findById(id);
	}
	
	public void deleteInformation(long id) {
		infoRepo.deleteById(id);
	}
	
	public Information saveInformation(Information information) {
		return infoRepo.save(information);
	}
	
	public Information updateInformation(Information information) {
		if(getInformation(information.getId()).isPresent())return saveInformation(information);
		return null;
	}

}
