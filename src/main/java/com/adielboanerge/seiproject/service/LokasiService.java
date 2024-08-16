package com.adielboanerge.seiproject.service;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.entity.Lokasi;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LokasiService {
    Lokasi createLokasi(Lokasi lokasi);

    List<Lokasi> getLokasis();

    Lokasi update(Lokasi lokasi);

    Lokasi delete(RequestBodyID requestBodyID);
}
