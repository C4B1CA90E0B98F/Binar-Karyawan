package com.example.karyawan.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "rekening")
public class Rekening extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "UUID")
    private UUID id;

    @Column(name = "id_karyawan", columnDefinition = "UUID")
    private UUID karyawanId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_karyawan", referencedColumnName = "id", insertable = false, updatable = false)
    private Karyawan karyawan;

    @Column(name = "jenis")
    private String jenis;

    @Column(name = "nama")
    private String nama;

    @Column(name = "rekening")
    private String rekening;
}
