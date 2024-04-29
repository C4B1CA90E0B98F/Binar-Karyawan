package com.example.karyawan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.karyawan.model.Rekening;

public interface RekeningRepository extends JpaRepository<Rekening, UUID>{
    
}
