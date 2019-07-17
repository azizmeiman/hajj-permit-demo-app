package com.example.hajjpermitdemoapp.repositories;


import com.example.hajjpermitdemoapp.entities.Permit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermitRepository extends JpaRepository<Permit, Long> {
}
