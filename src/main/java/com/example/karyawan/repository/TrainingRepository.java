package com.example.karyawan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.karyawan.model.Training;

public interface TrainingRepository extends JpaRepository<Training, UUID> {
    
}
