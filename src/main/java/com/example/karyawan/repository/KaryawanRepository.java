package com.example.karyawan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.karyawan.model.Karyawan;

@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, UUID>{

}