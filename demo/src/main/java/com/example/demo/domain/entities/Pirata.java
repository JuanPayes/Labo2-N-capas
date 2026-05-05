package com.example.demo.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "Pirata")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Pirata {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "PirateName")
    private String name;

    @Column(name = "Bounty")
    private Double bounty;

    @Column(name = "Crew")
    private String crew;

    @Column(name = "Alive")
    private Boolean isAlive;
}
