package com.example.hajjpermitdemoapp.controllers;



import com.example.hajjpermitdemoapp.entities.Permit;
import com.example.hajjpermitdemoapp.services.PermitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class PermitController {


    @Autowired
    PermitService permitService;


    @GetMapping("/permit")
    public Page<Permit> getPermit (Pageable pageable){
        return permitService.getPermit(pageable);
    }

    @PostMapping("/permit")
    public Permit createPermit (@Valid @RequestBody Permit permit){
        return permitService.createPermit(permit);
    }

    @DeleteMapping("/permit")
    public void deletePermit (){
        permitService.deletePermit();
    }
}
