package com.unilopers.mini_erp_escolar.model;

import jakarta.persistence.*;

@Entity
@Table(name = "presencas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id_aluno", "id_aula"})
})
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_presenca")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_aula", nullable = false)
    private Aula aula;

    @Column(nullable = false)
    private Boolean presente;

    // construtores, getters e setters
}