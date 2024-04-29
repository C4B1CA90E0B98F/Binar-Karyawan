package com.example.karyawan.model;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "karyawan")
public class Karyawan extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "id_detail_karyawan", columnDefinition = "UUID")
    private UUID detailKaryawanId;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_detail_karyawan", referencedColumnName = "id", insertable = false, updatable = false)
    private DetailKaryawan detailKaryawan;

    @Column(name = "nama")
    private String nama;

    @Column(name = "status")
    private String status;
}
