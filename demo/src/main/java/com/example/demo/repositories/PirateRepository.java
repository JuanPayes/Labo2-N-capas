package com.example.demo.repositories;

import com.example.demo.domain.entities.Pirata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PirateRepository extends JpaRepository<Pirata, UUID> {
    Pirata findByName(String name);
}
