package com.example.demo.services;

import com.example.demo.domain.entities.Pirata;

import java.util.List;
import java.util.UUID;

public interface PirateService {
    void createPirate(Pirata pirata);
    List<Pirata> getAllPirates();
    Pirata getPirateById(UUID id);
    Pirata updatePirate(UUID id, Pirata pirata);
    Pirata deletePirate(UUID id);
}
