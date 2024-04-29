package com.example.karyawan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.karyawan.model.KaryawanTraining;

public interface KaryawanTrainingRepository extends JpaRepository<KaryawanTraining, UUID> {
    
}
