package com.example.demo.services;

import com.example.demo.domain.entities.Pirata;
import com.example.demo.repositories.PirateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PirateServiceImp implements PirateService {
    private final PirateRepository pirateRepository;

    @Override
    public void createPirate(Pirata pirata){
        pirateRepository.save(pirata);
    }

    @Override
    public List<Pirata> getAllPirates(){
        return pirateRepository.findAll();
    }

    @Override
    public Pirata getPirateById(UUID id) {
        return pirateRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pirata no encontrado"));
    }

    @Override
    public Pirata updatePirate(UUID id, Pirata pirata) {
        Pirata existingPirata = pirateRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pirata no encontrado"));

        existingPirata.setName(pirata.getName());
        existingPirata.setBounty(pirata.getBounty());
        existingPirata.setCrew(pirata.getCrew());
        existingPirata.setIsAlive(pirata.getIsAlive());

        return pirateRepository.save(existingPirata);
    }

    @Override
    public Pirata deletePirate(UUID id) {
        Pirata pirata = pirateRepository.findById(id)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Pirata no encontrado"));

        pirateRepository.deleteById(id);

        return pirata;
    }


}
