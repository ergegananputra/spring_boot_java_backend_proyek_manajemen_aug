package com.adielboanerge.seiproject.controller;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.entity.Lokasi;
import com.adielboanerge.seiproject.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping("")
    public Lokasi postLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.createLokasi(lokasi);
    }

    @GetMapping("")
    public List<Lokasi> getLokasis() {
        return lokasiService.getLokasis();
    }

    @PutMapping("")
    public Lokasi putLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.update(lokasi);
    }

    @DeleteMapping("")
    public Lokasi deleteLokasi(@RequestBody RequestBodyID requestBodyID) {
        return lokasiService.delete(requestBodyID);
    }
}
