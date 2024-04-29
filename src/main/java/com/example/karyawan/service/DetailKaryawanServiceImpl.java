package com.example.karyawan.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.karyawan.model.DetailKaryawan;
import com.example.karyawan.model.Karyawan;
import com.example.karyawan.repository.DetailKaryawanRepository;
import com.example.karyawan.repository.KaryawanRepository;

@Service
public class DetailKaryawanServiceImpl implements DetailKaryawanService {

    private final DetailKaryawanRepository detailKaryawanRepository;
    private final KaryawanRepository karyawanRepository;

    @Autowired
    public DetailKaryawanServiceImpl(DetailKaryawanRepository detailKaryawanRepository,
            KaryawanRepository karyawanRepository) {
        this.detailKaryawanRepository = detailKaryawanRepository;
        this.karyawanRepository = karyawanRepository;
    }

    @Override
    public List<DetailKaryawan> getAllDetailKaryawan() {
        return detailKaryawanRepository.findAll();
    }

    @Override
    public DetailKaryawan getDetailKaryawanById(UUID id) {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findById(id);
        if (optionalKaryawan.isPresent()) {
            Karyawan karyawan = optionalKaryawan.get();
            Optional<DetailKaryawan> optionalDetailKaryawan = detailKaryawanRepository
                    .findById(karyawan.getDetailKaryawanId());
            return optionalDetailKaryawan.orElse(null);
        }
        return null;
    }

    @Override
    public DetailKaryawan createDetailKaryawan(UUID karyawanId, DetailKaryawan detailKaryawan) {
        DetailKaryawan createdDetailKaryawan = detailKaryawanRepository.save(detailKaryawan);
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findById(karyawanId);
        if (optionalKaryawan.isPresent()) {
            Karyawan karyawan = optionalKaryawan.get();
            karyawan.setDetailKaryawanId(createdDetailKaryawan.getId());
            karyawanRepository.save(karyawan);
        }
        return createdDetailKaryawan;
    }

    @Override
    public DetailKaryawan updateDetailKaryawan(UUID id, DetailKaryawan detailKaryawan) {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findById(id);
        if (optionalKaryawan.isPresent()) {
            Karyawan karyawan = optionalKaryawan.get();
            UUID detailKaryawanId = karyawan.getDetailKaryawanId();
            Optional<DetailKaryawan> optionalDetailKaryawan = detailKaryawanRepository.findById(detailKaryawanId);
            if (optionalDetailKaryawan.isPresent()) {
                DetailKaryawan existingDetailKaryawan = optionalDetailKaryawan.get();
                existingDetailKaryawan.setNik(detailKaryawan.getNik());
                existingDetailKaryawan.setNpwp(detailKaryawan.getNpwp());
                return detailKaryawanRepository.save(existingDetailKaryawan);
            }
        }
        return null;
    }

    @Override
    public ResponseEntity<Object> deleteDetailKaryawan(UUID id) {
        Optional<Karyawan> optionalKaryawan = karyawanRepository.findById(id);
        if (optionalKaryawan.isPresent()) {
            Karyawan karyawan = optionalKaryawan.get();
            UUID detailKaryawanId = karyawan.getDetailKaryawanId();

            karyawan.setDetailKaryawanId(null);
            detailKaryawanRepository.deleteById(detailKaryawanId);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
