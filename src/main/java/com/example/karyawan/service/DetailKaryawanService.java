package com.example.karyawan.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.example.karyawan.model.DetailKaryawan;

public interface DetailKaryawanService {
    List<DetailKaryawan> getAllDetailKaryawan();
    DetailKaryawan getDetailKaryawanById(UUID id);
    DetailKaryawan createDetailKaryawan(UUID karyawanId, DetailKaryawan detailKaryawan);
    DetailKaryawan updateDetailKaryawan(UUID id, DetailKaryawan detailKaryawan);
    ResponseEntity<Object> deleteDetailKaryawan(UUID id);
}
