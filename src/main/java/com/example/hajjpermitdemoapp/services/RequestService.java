package com.example.hajjpermitdemoapp.services;




import com.example.hajjpermitdemoapp.entities.Request;
import com.example.hajjpermitdemoapp.repositories.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class RequestService {

    @Autowired
    RequestRepository requestRepository;

    @Transactional
    public Request createRequest(Request request){
        request.setStatus(0);
        return requestRepository.save(request);
    }

    @Transactional
    public Page<Request> getRequest(Pageable pageable){
        return requestRepository.findAll(pageable);
    }

    @Transactional
    public void deleteRequest(){
        requestRepository.deleteAll();
    }


}
