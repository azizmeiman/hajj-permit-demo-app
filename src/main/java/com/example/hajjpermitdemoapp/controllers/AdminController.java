package com.example.hajjpermitdemoapp.controllers;


import com.example.hajjpermitdemoapp.entities.Admin;
import com.example.hajjpermitdemoapp.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AdminController {

    @Autowired
    AdminService adminService;


    @GetMapping("/admin")
    public Page<Admin> getAdmin (Pageable pageable){
        return adminService.getAdmin(pageable);
    }

    @PostMapping("/admin")
    public Admin createAdmin (@Valid @RequestBody Admin admin){
        return adminService.createAdmin(admin);
    }

    @DeleteMapping("/admin")
    public void deleteAdmin (){
        adminService.deleteAdmin();
    }


}
