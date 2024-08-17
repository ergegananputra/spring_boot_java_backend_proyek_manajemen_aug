package com.adielboanerge.seiproject.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proyek")
public class Proyek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nama_proyek")
    @Column(name = "nama_proyek")
    private String namaProyek;

    @JsonProperty("client")
    @Column(name = "client")
    private String client;

    @JsonProperty("tgl_mulai")
    @Column(name = "tgl_mulai")
    private LocalDateTime tglMulai;

    @JsonProperty("tgl_selesai")
    @Column(name = "tgl_selesai")
    private LocalDateTime tglSelesai;

    @JsonProperty("pimpinan_proyek")
    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;

    @JsonProperty("keterangan")
    @Column(name = "keterangan")
    private String keterangan;

    @CreationTimestamp
    @JsonProperty("created_at")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "proyeks")
    private Collection<Lokasi> lokasis = new ArrayList<>();
}
