package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
