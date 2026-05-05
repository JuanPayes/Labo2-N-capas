package com.example.demo.controllers;


import com.example.demo.domain.entities.Pirata;
import com.example.demo.services.PirateService;
import com.example.demo.services.PirateServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/pirate")
@AllArgsConstructor
public class PirateController {
    private final PirateService pirateService;

    @PostMapping("/create")
    public ResponseEntity<Pirata> createPirate(@RequestBody Pirata pirata) {
        pirateService.createPirate(pirata);
        return ResponseEntity.status(HttpStatus.CREATED).body(pirata);
    }

    @GetMapping
    public ResponseEntity<List<Pirata>> getAllPirates() {
        return ResponseEntity.ok(pirateService.getAllPirates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pirata> getPirateById(@PathVariable UUID id) {
        return ResponseEntity.ok(pirateService.getPirateById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pirata> updatePirate(
            @PathVariable UUID id,
            @RequestBody Pirata pirata
    ) {
        return ResponseEntity.ok(pirateService.updatePirate(id, pirata));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Pirata> deletePirate(@PathVariable UUID id) {
        return ResponseEntity.ok(pirateService.deletePirate(id));
    }

}
