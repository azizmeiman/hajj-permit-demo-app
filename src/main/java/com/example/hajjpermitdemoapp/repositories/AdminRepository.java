package com.example.hajjpermitdemoapp.repositories;


import com.example.hajjpermitdemoapp.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {
}
