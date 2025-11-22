package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Long id;

    @Column(nullable = false)
    private String nome;

    public Disciplina() {}

    public Disciplina(String nome) {
        this.nome = nome;
    }
