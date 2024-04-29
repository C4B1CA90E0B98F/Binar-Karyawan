package com.example.karyawan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.karyawan.model.Karyawan;
import com.example.karyawan.service.KaryawanService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {
    @Autowired
    private KaryawanService karyawanService;

    @GetMapping("/all")
    public ResponseEntity<List<Karyawan>> getAllKaryawan() {
        List<Karyawan> karyawanList = karyawanService.getAllKaryawan();
        return new ResponseEntity<>(karyawanList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Karyawan> getKaryawanById(@PathVariable UUID id) {
        Karyawan karyawan = karyawanService.getKaryawanById(id);
        if (karyawan != null) {
            return new ResponseEntity<>(karyawan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping()
    public ResponseEntity<Karyawan> createKaryawan(@RequestBody Karyawan karyawan) {
        Karyawan createdKaryawan = karyawanService.createKaryawan(karyawan);
        return new ResponseEntity<>(createdKaryawan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Karyawan> updateKaryawan(@PathVariable UUID id, @RequestBody Karyawan karyawan) {
        Karyawan updatedKaryawan = karyawanService.updateKaryawan(id, karyawan);
        if (updatedKaryawan != null) {
            return new ResponseEntity<>(updatedKaryawan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKaryawan(@PathVariable UUID id) {
        karyawanService.deleteKaryawan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
