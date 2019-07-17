package com.example.hajjpermitdemoapp.controllers;



import com.example.hajjpermitdemoapp.entities.Request;
import com.example.hajjpermitdemoapp.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class RequestController {

    @Autowired
    RequestService requestService;


    @GetMapping("/request")
    public Page<Request> getRequest (Pageable pageable){
        return requestService.getRequest(pageable);
    }

    @PostMapping("/request")
    public Request createRequest (@Valid @RequestBody Request request){
        return requestService.createRequest(request);
    }

    @DeleteMapping("/request")
    public void deleteRequest (){
      requestService.deleteRequest();
    }

}
