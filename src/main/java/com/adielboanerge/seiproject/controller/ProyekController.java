package com.adielboanerge.seiproject.controller;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.dto.RequestProyekLokasi;
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
    public List<Proyek> getProyeks() {
        return proyekService.getProyeks();
    }

    @PutMapping("")
    public Proyek putProyek(@RequestBody Proyek proyek) {
        return proyekService.update(proyek);
    }

    @DeleteMapping("")
    public Proyek deleteProyek(@RequestBody RequestBodyID requestBodyID) {
        return  proyekService.deleteProyek(requestBodyID);
    }
}
