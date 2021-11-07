package com.gev.admin.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gev.admin.models.Admin;
import com.gev.admin.repositories.AdminRepository;

@Service
public class AdminService {
	
	@Autowired
	AdminRepository adminRepo;
	
	public List<Admin> getAllAdmins() {
		return adminRepo.findAll();
	}

	public Optional<Admin> getAdmin(long id){
		return adminRepo.findById(id);
	}
	
	public Admin saveAdmin(Admin admin) {
		return adminRepo.save(admin);
	}
	
	public void deleteAdminWhereIdEqualTo(long id) {
		adminRepo.deleteById(id);
	}
	
	public Admin updateAdmin(Admin admin) {
		
		if(getAdmin(admin.getId_admin()).isEmpty()) return null;
		
		return saveAdmin(admin);
	}
}
