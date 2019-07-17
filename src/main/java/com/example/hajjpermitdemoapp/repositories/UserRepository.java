package com.example.hajjpermitdemoapp.repositories;


import com.example.hajjpermitdemoapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    List<User> findAllByVerified(boolean isVerified);
}
