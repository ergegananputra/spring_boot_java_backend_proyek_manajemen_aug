package com.adielboanerge.seiproject.service.impl;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.dto.RequestProyekLokasi;
import com.adielboanerge.seiproject.entity.Lokasi;
import com.adielboanerge.seiproject.entity.Proyek;
import com.adielboanerge.seiproject.repository.LokasiRepository;
import com.adielboanerge.seiproject.repository.ProyekRepository;
import com.adielboanerge.seiproject.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProyekServiceImpl implements ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;

    @Autowired
    private LokasiRepository lokasiRepository;

    @Override
    public Proyek createProyek(RequestProyekLokasi request) {
        Proyek proyek = new Proyek();
        Lokasi lokasi = new Lokasi();
        try {
            proyek.setNamaProyek(request.getNamaProyek());
            proyek.setClient(request.getClient());
            proyek.setTglMulai(request.getTglMulai());
            proyek.setTglSelesai(request.getTglSelesai());
            proyek.setPimpinanProyek(request.getPimpinanProyek());
            proyek.setKeterangan(request.getKeterangan());

            if (request.getIdLokasi() == null) {
                if (request.getNamaLokasi() == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nama Lokasi tidak boleh kosong");
                }
                if (request.getNegara() == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Negara tidak boleh kosong");
                }
                if (request.getProvinsi() == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provinsi tidak boleh kosong");
                }
                if (request.getKota() == null) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Kota tidak boleh kosong");
                }

                lokasi.setNamaLokasi(request.getNamaLokasi());
                lokasi.setNegara(request.getNegara());
                lokasi.setProvinsi(request.getProvinsi());
                lokasi.setKota(request.getKota());

                lokasiRepository.save(lokasi);
            } else {
                lokasi = lokasiRepository
                        .findById(request.getIdLokasi())
                        .orElseThrow(
                                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lokasi tidak ditemukan")
                        );
            }

        } catch (ResponseStatusException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Data tidak lengkap : " + e.getMessage());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Terjadi kesalahan Internal");
        }

        proyek.getLokasis().add(lokasi);
        lokasi.getProyeks().add(proyek);

        proyekRepository.save(proyek);

        return proyek;
    }

    @Override
    public List<Proyek> getProyeks() {
        return proyekRepository.findAll();
    }

    @Override
    public Proyek deleteProyek(RequestBodyID requestBodyID) {
        if (requestBodyID.getId() == null) {
            throw new RuntimeException("ID Lokasi tidak boleh kosong");
        }

        Proyek proyek = proyekRepository
                .findById(requestBodyID.getId())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek tidak ditemukan")
                );

        // o(n) complexity: akan menunggu sampai selesai
        proyek.getLokasis().parallelStream().forEach(lokasi -> lokasi.getProyeks().remove(proyek));
        proyek.getLokasis().clear();
        proyekRepository.save(proyek);

        proyekRepository.delete(proyek);
        return proyek;
    }

    @Override
    public Proyek update(Proyek proyek) {
        if (proyek.getId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID Proyek tidak boleh kosong");
        }

        Proyek proyekToUpdate = proyekRepository
                .findById(proyek.getId())
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek tidak ditemukan")
                );

        proyekToUpdate.setNamaProyek(proyek.getNamaProyek());
        proyekToUpdate.setClient(proyek.getClient());
        proyekToUpdate.setTglMulai(proyek.getTglMulai());
        proyekToUpdate.setTglSelesai(proyek.getTglSelesai());
        proyekToUpdate.setKeterangan(proyek.getKeterangan());


        proyekRepository.save(proyekToUpdate);
        return proyekToUpdate;
    }

    @Override
    public Proyek getProyek(Integer id) {
        return proyekRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Proyek tidak ditemukan")
                );
    }
}
