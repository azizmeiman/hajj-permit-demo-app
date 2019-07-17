package com.example.hajjpermitdemoapp.services;



import com.example.hajjpermitdemoapp.entities.Permit;
import com.example.hajjpermitdemoapp.repositories.PermitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PermitService {

    @Autowired
    PermitRepository permitRepository;


    @Transactional
    public Permit createPermit(Permit permit){
        return permitRepository.save(permit);
    }

    @Transactional
    public Page<Permit> getPermit(Pageable pageable){
       return permitRepository.findAll(pageable);
    }

    @Transactional
    public void deletePermit(){
         permitRepository.deleteAll();
    }

}
