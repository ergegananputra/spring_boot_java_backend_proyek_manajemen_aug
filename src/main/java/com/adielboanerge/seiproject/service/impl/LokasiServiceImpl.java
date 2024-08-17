package com.adielboanerge.seiproject.service.impl;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.entity.Lokasi;
import com.adielboanerge.seiproject.repository.LokasiRepository;
import com.adielboanerge.seiproject.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LokasiServiceImpl implements LokasiService {

    @Autowired
    private LokasiRepository lokasiRepository;

    @Override
    public Lokasi createLokasi(Lokasi lokasi) {
        return lokasiRepository.save(lokasi);
    }

    @Override
    public List<Lokasi> getLokasis() {
        return lokasiRepository.findAll();
    }

    @Override
    public Lokasi update(Lokasi lokasi) {
        if (lokasi.getId() == null) {
            throw new RuntimeException("ID Lokasi tidak boleh kosong");
        }

        Lokasi lokasiToUpdate = lokasiRepository
                .findById(lokasi.getId())
                .orElseThrow(
                        () -> new RuntimeException("Lokasi tidak ditemukan")
                );

        lokasiToUpdate.setNamaLokasi(lokasi.getNamaLokasi());
        lokasiToUpdate.setNamaLokasi(lokasi.getNamaLokasi());
        lokasiToUpdate.setNegara(lokasi.getNegara());
        lokasiToUpdate.setProvinsi(lokasi.getProvinsi());
        lokasiToUpdate.setKota(lokasi.getKota());

        lokasiRepository.save(lokasiToUpdate);
        return lokasiToUpdate;
    }

    @Override
    public Lokasi delete(RequestBodyID requestBodyID) {
        if (requestBodyID.getId() == null) {
            throw new RuntimeException("ID Lokasi tidak boleh kosong");
        }

        Lokasi lokasi = lokasiRepository
                .findById(requestBodyID.getId())
                .orElseThrow(
                        () -> new RuntimeException("Lokasi tidak ditemukan")
                );

        lokasiRepository.delete(lokasi);

        return lokasi;
    }

    @Override
    public Lokasi getLokasi(Integer id) {
        if (id == null) {
            throw new RuntimeException("ID Lokasi tidak boleh kosong");
        }

        Lokasi lokasi = lokasiRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException("Lokasi tidak ditemukan")
                );

        return lokasi;
    }


}
