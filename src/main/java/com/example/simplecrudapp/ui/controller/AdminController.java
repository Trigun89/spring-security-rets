package com.example.simplecrudapp.ui.controller;

import com.example.simplecrudapp.io.entity.AdminEntity;
import com.example.simplecrudapp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admins")
public class AdminController {

    @Autowired
    AdminService adminService;

    public AdminController(AdminService adminService){
        super();
        this.adminService = adminService;
    }


    //doesn't work
    @PostMapping
    public ResponseEntity<AdminEntity> createAdmin(@RequestBody AdminEntity admin){
        return new ResponseEntity<>(adminService.createAdmin(admin), HttpStatus.CREATED);
    }

    // this works
//    @PostMapping
//    public String createAdmin(){
//        return "create admin was called";
//    }

//    @PostMapping
//    public AdminEntity createUser(@RequestBody AdminEntity admin){
//        AdminEntity createdAdmin = adminService.createAdmin(admin);
//        return createdAdmin;
//    }

//    @PostMapping
//    public

//    @GetMapping
//    public List<AdminEntity> getAllAdmins(){
//        return adminService.getAllAdmins();
//    }

}
