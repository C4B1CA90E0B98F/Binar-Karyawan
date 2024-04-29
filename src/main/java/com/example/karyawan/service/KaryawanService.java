package com.example.karyawan.service;

import java.util.List;
import java.util.UUID;

import com.example.karyawan.model.Karyawan;

public interface KaryawanService {
    List<Karyawan> getAllKaryawan();

    Karyawan getKaryawanById(UUID id);

    Karyawan createKaryawan(Karyawan karyawan);

    Karyawan updateKaryawan(UUID id, Karyawan karyawan);

    void deleteKaryawan(UUID id);
}
