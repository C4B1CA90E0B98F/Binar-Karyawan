package com.example.karyawan.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.karyawan.model.DetailKaryawan;
import com.example.karyawan.service.DetailKaryawanService;

@RestController
@RequestMapping("/karyawan")
public class DetailKaryawanController {

    @Autowired
    private DetailKaryawanService detailKaryawanService;

    @GetMapping("/{id}/detail")
    public ResponseEntity<DetailKaryawan> getDetailKaryawanById(@PathVariable UUID id) {
        DetailKaryawan detailKaryawan = detailKaryawanService.getDetailKaryawanById(id);
        if (detailKaryawan != null) {
            return new ResponseEntity<>(detailKaryawan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/detail")
    public ResponseEntity<DetailKaryawan> createDetailKaryawan(@PathVariable UUID id, @RequestBody DetailKaryawan detailKaryawan) {
        DetailKaryawan createdDetailKaryawan = detailKaryawanService.createDetailKaryawan(id, detailKaryawan);
        return new ResponseEntity<>(createdDetailKaryawan, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/detail")
    public ResponseEntity<DetailKaryawan> updateDetailKaryawan(@PathVariable UUID id, @RequestBody DetailKaryawan detailKaryawan) {
        DetailKaryawan updatedDetailKaryawan = detailKaryawanService.updateDetailKaryawan(id, detailKaryawan);
        if (updatedDetailKaryawan != null) {
            return new ResponseEntity<>(updatedDetailKaryawan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}/detail")
    public ResponseEntity<Void> deleteDetailKaryawan(@PathVariable UUID id) {
        detailKaryawanService.deleteDetailKaryawan(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
