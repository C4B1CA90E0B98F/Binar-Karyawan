package com.example.karyawan.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "training")
public class Training extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "pengajar")
    private String pengajar;

    @Column(name = "tema")
    private String tema;
}
