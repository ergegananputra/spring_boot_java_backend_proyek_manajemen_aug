package com.adielboanerge.seiproject.service;

import com.adielboanerge.seiproject.dto.RequestBodyID;
import com.adielboanerge.seiproject.dto.RequestProyekLokasi;
import com.adielboanerge.seiproject.entity.Proyek;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProyekService {
    Proyek createProyek(RequestProyekLokasi proyek);

    List<Proyek> getProyeks();

    Proyek deleteProyek(RequestBodyID requestBodyID);

    Proyek update(Proyek proyek);
}
