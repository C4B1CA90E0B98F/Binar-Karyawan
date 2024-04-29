package com.example.karyawan.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.karyawan.model.Karyawan;
import com.example.karyawan.repository.KaryawanRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KaryawanServiceImpl implements KaryawanService {

    private final KaryawanRepository karyawanRepository;

    @Autowired
    public KaryawanServiceImpl(KaryawanRepository karyawanRepository) {
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @Override
    public Karyawan getKaryawanById(UUID id) {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findById(id);
        return optionalKaryawan.orElse(null);
    }

    @Override
    public Karyawan createKaryawan(Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    @Override
    public Karyawan updateKaryawan(UUID id, Karyawan karyawan) {
        Optional<Karyawan> optionalExistingKaryawan = karyawanRepository.findById(id);
        if (optionalExistingKaryawan.isPresent()) {
            Karyawan existingKaryawan = optionalExistingKaryawan.get();
            existingKaryawan.setNama(karyawan.getNama());
            existingKaryawan.setStatus(karyawan.getStatus());
            return karyawanRepository.save(existingKaryawan);
        }
        return null;
    }

    @Override
    public void deleteKaryawan(UUID id) {
        karyawanRepository.deleteById(id);
    }
}
