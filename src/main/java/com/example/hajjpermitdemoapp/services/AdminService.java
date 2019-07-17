package com.example.hajjpermitdemoapp.services;



import com.example.hajjpermitdemoapp.entities.Admin;
import com.example.hajjpermitdemoapp.entities.Permit;
import com.example.hajjpermitdemoapp.entities.Request;
import com.example.hajjpermitdemoapp.entities.User;
import com.example.hajjpermitdemoapp.exception.ResourceNotFoundException;
import com.example.hajjpermitdemoapp.repositories.AdminRepository;
import com.example.hajjpermitdemoapp.repositories.PermitRepository;
import com.example.hajjpermitdemoapp.repositories.RequestRepository;
import com.example.hajjpermitdemoapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RequestRepository requestRepository;

    @Autowired
    PermitRepository permitRepository;

    @Transactional
    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    @Transactional
    public Page<Admin> getAdmin(Pageable pageable){
        return adminRepository.findAll(pageable);
    }

    @Transactional
    public void deleteAdmin(){
        adminRepository.deleteAll();
    }

    @Transactional
    public void activateUser(long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            userRepository.save(user.get());
       }else throw new ResourceNotFoundException("There is no User with this ID: "+userId);
    }

    @Transactional
    public void acceptRequest(long requestId){
       // Optional<Request> request = requestRepository.findById(requestId);
        Request request1;
        if(requestRepository.findById(requestId).isPresent()){
            request1 = requestRepository.findById(requestId).get();
        }else
            throw new ResourceNotFoundException("There is no Request with this ID: "+requestId);

        request1.setStatus(1);
        Date startDate = new Date();
        Date endDate =new Date();                                                                       //+3 months ****

        Permit permit = new Permit(request1.getUser());
        permitRepository.save(permit);
    }


    @Transactional
    public void rejectRequest(long requestId){
        Request request1;
        if(requestRepository.findById(requestId).isPresent()){
            request1 = requestRepository.findById(requestId).get();
        }else
            throw new ResourceNotFoundException("There is no Request with this ID: "+requestId);

        request1.setStatus(2);
    }

    @Transactional
    public List<Request> getAllRequest(){
        return requestRepository.findAllByStatus(0);
    }

    @Transactional
    public List<User> getNewUsers(){
        return userRepository.findAllByVerified(false);
    }
}
