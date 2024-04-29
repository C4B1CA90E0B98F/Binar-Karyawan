package com.example.karyawan.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.karyawan.model.DetailKaryawan;

@Repository
public interface DetailKaryawanRepository extends JpaRepository<DetailKaryawan, UUID> {

}