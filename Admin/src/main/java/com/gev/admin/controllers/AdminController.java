package com.gev.admin.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gev.admin.models.Admin;
import com.gev.admin.services.AdminService;
import com.sun.jersey.api.NotFoundException;


@RequestMapping("/admin") 
@RestController
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/all")
	@ResponseStatus(HttpStatus.FOUND)
	public Iterable<Admin> getAllAdmins(){
		return adminService.getAllAdmins();	
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Admin saveAdmin(@Valid @RequestBody Admin admin) {
		return adminService.saveAdmin(admin);	
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.FOUND)
	public Optional<Admin> getAdmin(@PathVariable("id") long id) {
		return adminService.getAdmin(id);	
	}
	
	@DeleteMapping("/{id}/delete")
	@ResponseStatus(HttpStatus.OK)
	public void deleteAdmin(@PathVariable("id") long id) {
		adminService.deleteAdminWhereIdEqualTo(id);	
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	public Admin updateAdmin(@Valid @RequestBody Admin admin) throws Exception {
		
		Admin myAdmin = adminService.updateAdmin(admin);
		
		if(myAdmin == null) {
			throw new NotFoundException("L'admin que vous essayez de mettre à jour n'existe pas !");
		}
		
		return myAdmin;
	}

}
