package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataDaAula;

    public Aula() {}

    public Aula(LocalDate dataDaAula) {
        this.dataDaAula = dataDaAula;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDataDaAula() {
        return dataDaAula;
    }

    public void setDataDaAula(LocalDate dataDaAula) {
        this.dataDaAula = dataDaAula;
    }
}
