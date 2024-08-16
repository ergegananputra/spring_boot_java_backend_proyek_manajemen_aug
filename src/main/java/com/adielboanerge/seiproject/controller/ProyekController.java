package com.adielboanerge.seiproject.controller;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.dto.RequestProyekLokasi;
import com.adielboanerge.seiproject.dto.ResponseJSON;
import com.adielboanerge.seiproject.entity.Proyek;
import com.adielboanerge.seiproject.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping("")
    public Proyek postProyek(@RequestBody RequestProyekLokasi requestProyekLokasi) {
        return proyekService.createProyek(requestProyekLokasi);
    }

    @GetMapping("")
    public ResponseJSON<List<Proyek>> getProyeks() {
        ResponseJSON<List<Proyek>> responseJSON = new ResponseJSON<>();

        try {
            List<Proyek> proyeks = proyekService.getProyeks();
            if (proyeks.isEmpty()) {
                responseJSON.setMessage("Data Proyek Kosong");
                responseJSON.setData(null);
            } else {
                responseJSON.setMessage("Data Proyek Ditemukan");
                responseJSON.setData(proyeks);
            }
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }

    @PutMapping("")
    public ResponseJSON<Proyek> putProyek(@RequestBody Proyek proyek) {
        ResponseJSON<Proyek> responseJSON = new ResponseJSON<>();

        try {
            Proyek proyekUpdated = proyekService.update(proyek);
            responseJSON.setMessage("Data Proyek Berhasil Diupdate");
            responseJSON.setData(proyekUpdated);
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }

    @DeleteMapping("")
    public ResponseJSON<Proyek> deleteProyek(@RequestBody RequestBodyID requestBodyID) {
        ResponseJSON<Proyek> responseJSON = new ResponseJSON<>();

        try {
            Proyek proyekDeleted = proyekService.deleteProyek(requestBodyID);
            responseJSON.setMessage("Data Proyek Berhasil Dihapus");
            responseJSON.setData(proyekDeleted);
            return responseJSON;
        } catch (Exception e) {
            responseJSON.setMessage("Terjadi Kesalahan");
            responseJSON.setData(null);
            return responseJSON;
        }
    }
}
