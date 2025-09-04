package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    // CREATE admin
    @PostMapping
    public Admin createAdmin(@RequestBody Admin admin) {
        return adminService.createAdmin(admin);
    }

    // READ all admins
    @GetMapping
    public List<Admin> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    // READ single admin
    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return adminService.getAdminById(id);
    }

    // UPDATE admin
    @PutMapping("/{id}")
    public Admin updateAdmin(@PathVariable Long id, @RequestBody Admin adminDetails) {
        return adminService.updateAdmin(id, adminDetails);
    }

    // DELETE admin
    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin deleted with id: " + id;
    }
}
