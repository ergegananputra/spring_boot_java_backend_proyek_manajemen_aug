package com.adielboanerge.seiproject.controller;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.dto.ResponseJSON;
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
    public ResponseJSON<Lokasi> postLokasi(@RequestBody Lokasi lokasi) {
        ResponseJSON<Lokasi> responseJSON = new ResponseJSON<>();

        try {
            Lokasi lokasiCreated = lokasiService.createLokasi(lokasi);
            responseJSON.setMessage("Data Lokasi Berhasil Dibuat");
            responseJSON.setData(lokasiCreated);
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }

    @GetMapping("")
    public ResponseJSON<List<Lokasi>> getLokasis() {
        ResponseJSON<List<Lokasi>> responseJSON = new ResponseJSON<>();

        try {
            List<Lokasi> lokasis = lokasiService.getLokasis();
            if (lokasis.isEmpty()) {
                responseJSON.setMessage("Data Lokasi Kosong");
                responseJSON.setData(null);
            } else {
                responseJSON.setMessage("Data Lokasi Ditemukan");
                responseJSON.setData(lokasis);
            }
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }


    }

    @PutMapping("")
    public ResponseJSON<Lokasi> putLokasi(@RequestBody Lokasi lokasi) {
        ResponseJSON<Lokasi> responseJSON = new ResponseJSON<>();

        try {
            Lokasi lokasiUpdated = lokasiService.update(lokasi);
            responseJSON.setMessage("Data Lokasi Berhasil Diupdate");
            responseJSON.setData(lokasiUpdated);
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }

    @DeleteMapping("")
    public ResponseJSON<Lokasi> deleteLokasi(@RequestBody RequestBodyID requestBodyID) {
        ResponseJSON<Lokasi> responseJSON = new ResponseJSON<>();

        try {
            Lokasi lokasiDeleted = lokasiService.delete(requestBodyID);
            responseJSON.setMessage("Data Lokasi Berhasil Dihapus");
            responseJSON.setData(lokasiDeleted);
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }
}
