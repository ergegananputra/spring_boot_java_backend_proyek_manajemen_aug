package com.adielboanerge.seiproject.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequestProyekLokasi {

    @JsonProperty("nama_proyek")
    private String namaProyek;

    @JsonProperty("client")
    private String client;

    @JsonProperty("tgl_mulai")
    private LocalDateTime tglMulai;

    @JsonProperty("tgl_selesai")
    private LocalDateTime tglSelesai;

    @JsonProperty("pimpinan_proyek")
    private String pimpinanProyek;

    @JsonProperty("keterangan")
    private String keterangan;

    @JsonProperty("nama_lokasi")
    @Nullable
    private String namaLokasi;

    @JsonProperty("negara")
    @Nullable
    private String negara;

    @JsonProperty("provinsi")
    @Nullable
    private String provinsi;

    @JsonProperty("kota")
    @Nullable
    private String kota;

    @JsonProperty("id_lokasi")
    @Nullable
    private Integer idLokasi;
}
