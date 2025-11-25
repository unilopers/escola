package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "aulas")
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aula")
    private Long id;

    @Column(name = "data_aula", nullable = false)
    private LocalDate dataAula;

    public Aula() {}

    public Aula(LocalDate dataAula) {
        this.dataAula = dataAula;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataAula() {
        return dataAula;
    }

    public void setDataAula(LocalDate dataAula) {
        this.dataAula = dataAula;
    }
}
