package com.adielboanerge.seiproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonProperty("nama_lokasi")
    @Column(name = "nama_lokasi")
    private String namaLokasi;

    @JsonProperty("negara")
    @Column(name = "negara")
    private String negara;

    @JsonProperty("provinsi")
    @Column(name = "provinsi")
    private String provinsi;

    @JsonProperty("kota")
    @Column(name = "kota")
    private String kota;

    @CreationTimestamp
    @JsonProperty("create_at")
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "proyek_lokasi",
            joinColumns = @JoinColumn(name = "lokasi_id"),
            inverseJoinColumns = @JoinColumn(name = "proyek_id")
    )
    private Collection<Proyek> proyeks = new ArrayList<>();
}
