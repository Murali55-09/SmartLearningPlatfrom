package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public Admin createAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin getAdminById(Long id) {
        return adminRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id " + id));
    }

    public Admin updateAdmin(Long id, Admin adminDetails) {
        Admin admin = getAdminById(id);
        admin.setName(adminDetails.getName());
        admin.setEmail(adminDetails.getEmail());
        admin.setPassword(adminDetails.getPassword());
        return adminRepository.save(admin);
    }

    public void deleteAdmin(Long id) {
        Admin admin = getAdminById(id);
        adminRepository.delete(admin);
    }
}
