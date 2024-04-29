package com.example.karyawan.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "karyawan_training")
public class KaryawanTraining extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "id_karyawan", columnDefinition = "UUID")
    private UUID karyawanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id", insertable = false, updatable = false)
    private Karyawan karyawan;

    @Column(name = "id_training", columnDefinition = "UUID")
    private UUID trainingId;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_training", referencedColumnName = "id", insertable = false, updatable = false)
    private Training training;

    @Column(name = "tanggal")
    private String tanggal;
}
